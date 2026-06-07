package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private By addToCartButton = By.cssSelector("button[id^='add-to-cart-button']");
    private By addToWishlistButton = By.cssSelector("button[id^='add-to-wishlist-button']");
    private By successBar = By.cssSelector(".bar-notification.success");
    private By closeNotification = By.cssSelector(".bar-notification .close");
    private By quantityInput = By.cssSelector("input.qty-input");

    public ProductPage(WebDriver driver) { 
        super(driver); 
    }

    public void addToCart() {
        click(addToCartButton);
        waitForText(successBar, "shopping cart");
    }

    public void addToWishlist() {
        click(addToWishlistButton);
        waitForText(successBar, "wishlist");
    }

    public void setQuantity(String qty) { 
        type(quantityInput, qty); 
    }
    
    public boolean isSuccessDisplayed() { 
        return isDisplayed(successBar); 
    }
    
    public void closeSuccess() { 
        if (isDisplayed(closeNotification)) {
            click(closeNotification); 
        }
    }
}