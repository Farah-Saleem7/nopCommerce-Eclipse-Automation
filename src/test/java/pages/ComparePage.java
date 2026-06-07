package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComparePage extends BasePage {
    private By compareTable = By.className("compare-products-table");
    private By clearListButton = By.className("clear-list");
    private By noDataMessage = By.className("no-data");
    public static final String URL = "https://demo.nopcommerce.com/compareproducts";

    public ComparePage(WebDriver driver) { 
        super(driver); 
    }

    public boolean isCompareTableDisplayed() { 
        return isDisplayed(compareTable); 
    }
    
    public void clearCompareList() { 
        click(clearListButton); 
    }
    
    public String getNoDataMessageText() { 
        return text(noDataMessage); 
    }
}