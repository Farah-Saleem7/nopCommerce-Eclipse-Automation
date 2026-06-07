package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By registerLink = By.className("ico-register");
    private By loginLink = By.className("ico-login");
    private By logoutLink = By.className("ico-logout");
    private By cartLink = By.className("ico-cart");
    private By wishlistLink = By.className("ico-wishlist");
    private By searchInput = By.id("small-searchterms");
    private By searchButton = By.cssSelector("button.search-box-button");
    private By computersMenu = By.linkText("Computers");
    private By electronicsMenu = By.linkText("Electronics");
    private By contactUsLink = By.linkText("Contact us");

    public HomePage(WebDriver driver) { 
        super(driver); 
    }

    public void openRegister() { 
        click(registerLink); 
    }
    
    public void openLogin() { 
        click(loginLink); 
    }
    
    public void logout() { 
        click(logoutLink); 
    }
    
    public void openCart() { 
        click(cartLink); 
    }
    
    public void openWishlist() { 
        click(wishlistLink); 
    }
    
    public void openComputers() { 
        click(computersMenu); 
    }
    
    public void openElectronics() { 
        click(electronicsMenu); 
    }
    
    public void openContactUs() { 
        click(contactUsLink); 
    }

    public void searchFor(String productName) {
        type(searchInput, productName);
        click(searchButton);
    }

    public boolean isLoginDisplayed() { 
        return isDisplayed(loginLink); 
    }

    public boolean isLogoutDisplayed() { 
        return isDisplayed(logoutLink); 
    }
}