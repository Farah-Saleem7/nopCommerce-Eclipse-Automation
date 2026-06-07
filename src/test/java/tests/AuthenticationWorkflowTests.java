package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class AuthenticationWorkflowTests extends BaseTest {

    private final String LoginEmail = "farah@test.com";
    private final String LoginPassword = "123456";

    @Test(priority = 1, description = "TC-WF1-01 & TC-WF1-02: Test all invalid logins, then valid login")
    public void testLoginFlow() {
        HomePage home = new HomePage(driver);
        home.openLogin();

        LoginPage loginPage = new LoginPage(driver);

        String[][] invalidCredentials = {
            { "sarah@test.com", "123456" },              
            { "farah@test.com", "@#$%^&" },       
            { "#$%55878", "123456" },     
            { "farah     @test.com", "123456" },
            { "Admin", "Password" }
        };

        for (String[] credentials : invalidCredentials) {
            String email = credentials[0];
            String password = credentials[1];

            loginPage.login(email, password);

            if (email.contains("@") && !email.contains(" ")) {
                loginPage.getErrorMessage(); 
            }

            String pageText = driver.getPageSource().toLowerCase();
            boolean loginErrorFound = pageText.contains("wrong credentials") 
                                      || pageText.contains("login was unsuccessful") 
                                      || pageText.contains("wrong email")
                                      || pageText.contains("enter a valid email address");

            Assert.assertTrue(loginErrorFound, 
                "Validation Failure: No error warning appeared for invalid email: " + email);
        }

        loginPage.login(LoginEmail, LoginPassword);

        Assert.assertTrue(home.isLogoutDisplayed(), "Login failed with correct credentials");
        home.logout();
    }

    @Test(priority = 2, description = "TC-WF1-03: Verify logout functionality")
    public void testLogoutFlow() {
        HomePage home = new HomePage(driver);
        
        home.openLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(LoginEmail, LoginPassword);

        home.logout();

        Assert.assertTrue(home.isLoginDisplayed(), "Logout failed");
    }

    @Test(priority = 3, description = "TC-WF1-04:  Verify Remember Me functionality")
    public void testRememberMeDefect() {
        HomePage home = new HomePage(driver);
        home.openLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithRememberMe(LoginEmail, LoginPassword);
        
        home.logout();
        home.openLogin();

        Assert.assertEquals(loginPage.getEmailFieldValue(), LoginEmail, 
            "Remember Me function failed to auto-fill the email field.");
    }

    @Test(priority = 4, description = "TC-WF1-05:  Verify password recovery sends reset link to email")
    public void testPasswordRecoveryDefect() {
        HomePage home = new HomePage(driver);
        home.openLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPassword();
        loginPage.recoverPassword(LoginEmail);

        String bannerText = loginPage.getRecoveryBannerText();
        Assert.assertTrue(bannerText.contains("email with instructions has been sent".toLowerCase()) || 
                          bannerText.toLowerCase().contains("email with instructions has been sent"), 
            "Password recovery notification banner did not display.");

        Assert.fail("The UI displayed success notification banner, but backend failed to send the recovery email link.");
    }
}