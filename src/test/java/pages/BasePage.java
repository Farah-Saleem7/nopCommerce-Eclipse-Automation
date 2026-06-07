package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


       public class BasePage {

      protected WebDriver driver;
      protected WebDriverWait wait;
      public BasePage(WebDriver driver) {
       this.driver = driver;
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

}
          protected WebElement visible(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

}

         protected WebElement clickable(By locator) {

       return wait.until(ExpectedConditions.elementToBeClickable(locator));

}

          protected void click(By locator) {

        WebElement element = clickable(locator);

   try {

       element.click();

        } catch (ElementClickInterceptedException e) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

}

}

       protected void type(By locator, String text) {

        WebElement element = visible(locator);

       element.clear();

       element.sendKeys(text);

}

        protected String text(By locator) {

        return visible(locator).getText().trim();

}

        protected boolean isDisplayed(By locator) {

       try {

       return visible(locator).isDisplayed();

         } catch (TimeoutException | NoSuchElementException e) {

         return false;

}

}

       protected void waitForText(By locator, String expectedText) {

      wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));

}

} 

