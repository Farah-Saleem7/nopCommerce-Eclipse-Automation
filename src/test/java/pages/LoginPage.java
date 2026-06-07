package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By loginButton = By.cssSelector("button.login-button");
    private By errorMessage = By.cssSelector(".message-error, .validation-summary-errors");
    private By rememberMe = By.id("RememberMe");
    private By forgotPasswordLink = By.linkText("Forgot password?");
    private By recoveryEmailInput = By.id("Email");
    private By recoverButton = By.name("send-email");
    private By recoveryBanner = By.cssSelector("p.content");

    public LoginPage(WebDriver driver) { 
        super(driver); 
    }

    public void login(String userEmail, String userPassword) {
        type(email, userEmail);
        type(password, userPassword);
        click(loginButton);
    }

    public void loginWithRememberMe(String userEmail, String userPassword) {
        type(email, userEmail);
        type(password, userPassword);
        WebElement checkbox = visible(rememberMe);
        if (!checkbox.isSelected()) {
            click(rememberMe);
        }
        click(loginButton);
    }

    public void clickForgotPassword() { 
        click(forgotPasswordLink); 
    }

    public void recoverPassword(String userEmail) {
        type(recoveryEmailInput, userEmail);
        click(recoverButton);
    }

    public String getEmailFieldValue() { 
        return visible(email).getAttribute("value"); 
    }

    public String getRecoveryBannerText() { 
        return text(recoveryBanner); 
    }

    public String getErrorMessage() { 
        return text(errorMessage); 
    }
}