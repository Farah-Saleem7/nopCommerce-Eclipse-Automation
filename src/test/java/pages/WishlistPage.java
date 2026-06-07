package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage {
    private By wishlistTable = By.cssSelector(".wishlist-content .cart");
    private By removeCheckbox = By.name("removefromcart");
    private By updateWishlistButton = By.name("updatecart");
    private By wishlistContent = By.cssSelector(".wishlist-content");
    private By addToCartCheckbox = By.name("addtocart");
    private By updateCartButton = By.name("updatecart");

    public WishlistPage(WebDriver driver) { 
        super(driver); 
    }

    public boolean isWishlistTableDisplayed() { 
        return isDisplayed(wishlistTable); 
    }

    public void removeProduct() {
        click(removeCheckbox);
        click(updateWishlistButton);
    }

    public void migrateWishlistItemToCart() {
        click(addToCartCheckbox);
        click(updateCartButton);
    }

    public boolean isWishlistEmpty() {
        return text(wishlistContent).toLowerCase().contains("empty");
    }
}