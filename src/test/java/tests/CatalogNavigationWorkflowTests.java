package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchPage;

public class CatalogNavigationWorkflowTests extends BaseTest {

    @Test(description = "TC-WF2-01 and TC-WF2-02: Validate product search, navigation, and details display")
    public void testProductSearchAndNavigationFlow() {
        HomePage home = new HomePage(driver);
        home.searchFor("MacBook");

        SearchPage searchPage = new SearchPage(driver);
        
        String searchGridText = driver.getPageSource().toLowerCase();
        Assert.assertTrue(searchGridText.contains("macbook"), 
            "Search Validation Failed: Results grid did not display the matching item.");

        searchPage.openFirstProduct();
        
        String productDetailsText = driver.getPageSource().toLowerCase();
        
        boolean isNameDisplayed = productDetailsText.contains("macbook");
        boolean isPriceDisplayed = productDetailsText.contains("price-value") || productDetailsText.contains("$");
        boolean isQuantityBoxDisplayed = productDetailsText.contains("qty-input") || productDetailsText.contains("quantity");

        Assert.assertTrue(isNameDisplayed, "Product Details Error: Item name is missing.");
        Assert.assertTrue(isPriceDisplayed, "Product Details Error: Item price is missing.");
        Assert.assertTrue(isQuantityBoxDisplayed, "Product Details Error: Custom quantity box is missing.");
    }
    
    @Test(description = "TC_WF2_03 : Search for a non-existing product")
    public void searchForNonExistingProduct() {
        HomePage home = new HomePage(driver);
        home.searchFor("Pizza");

        SearchPage search = new SearchPage(driver);
        Assert.assertTrue(search.hasNoResultsMessage(), "Error: No results message did not display for invalid search.");
    }
    
    @Test(description = "TC_WF2_04 : Verify decimal input handling")
    public void verifyDecimalQuantityHandling() {
        HomePage home = new HomePage(driver);
        home.searchFor("Apple");

        SearchPage search = new SearchPage(driver);
        search.openFirstProduct();

        ProductPage product = new ProductPage(driver);
        product.setQuantity("1.5");
        product.addToCart();

        String pageSourceText = driver.getPageSource().toLowerCase();
        boolean validationHandled = pageSourceText.contains("enter a whole number") 
                                 || pageSourceText.contains("quantity must be an integer");
                                
        Assert.assertTrue(validationHandled, "Validation Failure: Unclear error message for decimal quantity input.");
    }
}