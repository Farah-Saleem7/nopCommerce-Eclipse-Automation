package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    private By productGrid = By.cssSelector(".product-grid");
    private By noResults = By.cssSelector(".no-result");
    private By firstProductTitle = By.cssSelector(".product-title a");
    private By addToCompareButtons = By.cssSelector("button.add-to-compare-list-button");
    private By successBar = By.cssSelector(".bar-notification.success");

    public SearchPage(WebDriver driver) { 
        super(driver); 
    }

    public boolean hasSearchResults() { 
        return isDisplayed(productGrid); 
    }
    
    public boolean hasNoResultsMessage() { 
        return isDisplayed(noResults); 
    }
    
    public String getFirstProductName() { 
        return text(firstProductTitle); 
    }
    
    public void openFirstProduct() { 
        click(firstProductTitle); 
    }
    
    public void addFirstProductToCompare() { 
        click(addToCompareButtons); 
    }
    
    public boolean isSuccessDisplayed() { 
        return isDisplayed(successBar); 
    }
}