package tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.ComparePage;
import pages.HomePage;
import pages.SearchPage;

public class ProductComparisonWorkflowTests extends BaseTest {

    @Test(description = "TC-WF4-01 to TC-WF4-04: Add products, verify details, and clear comparison table")
    public void testProductComparisonMatrixLifecycle() {
        HomePage home = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        home.searchFor("computer");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.addFirstProductToCompare();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bar-notification.success")));
        
        home.searchFor("phone");
        searchPage.addFirstProductToCompare();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bar-notification.success")));
        
        driver.get(ComparePage.URL);
        ComparePage comparePage = new ComparePage(driver);
        
        String pageText = driver.getPageSource().toLowerCase();
        Assert.assertTrue(pageText.contains("computer") && pageText.contains("phone"), 
            "Comparison Matrix Error: Products were not added correctly.");

        comparePage.clearCompareList();
        
        boolean isListEmpty = false;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("no-data")));
            isListEmpty = true;
        } catch (TimeoutException e) {
            String finalSource = driver.getPageSource().toLowerCase();
            isListEmpty = finalSource.contains("you have no items to compare");
        }
        
        Assert.assertTrue(isListEmpty, "Clear List Error: The comparison list was not properly wiped clean.");
    }
}