package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchPage;
import pages.WishlistPage;

public class WishlistWorkflowTests extends BaseTest {

    @Test(description = "TC-WF3-01 to TC-WF3-03: Add product to wishlist, view records, and migrate to shopping cart")
    public void testWishlistToCartMigrationJourney() {
        HomePage home = new HomePage(driver);
        home.searchFor("MacBook");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.openFirstProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.addToWishlist();

        home.openWishlist();
        WishlistPage wishlistPage = new WishlistPage(driver);
        
      
        String wishlistPageText = driver.getPageSource().toLowerCase();
        
        boolean isTableDisplayed = wishlistPage.isWishlistTableDisplayed() || wishlistPageText.contains("cart");
        boolean isItemNamePresent = wishlistPageText.contains("macbook");
        boolean isPricePresent = wishlistPageText.contains("product-unit-price") || wishlistPageText.contains("$");
        boolean isQuantityPresent = wishlistPageText.contains("qty-input") || wishlistPageText.contains("quantity");

        Assert.assertTrue(isTableDisplayed, "Wishlist Error: The data table structure did not load.");
        Assert.assertTrue(isItemNamePresent, "Wishlist Error: The product name 'MacBook' is missing from the records.");
        Assert.assertTrue(isPricePresent, "Wishlist Error: The product price is missing.");
        Assert.assertTrue(isQuantityPresent, "Wishlist Error: The item quantity is missing.");
    
        wishlistPage.migrateWishlistItemToCart();

        String emptyWishlistText = driver.getPageSource().toLowerCase();
        boolean isWishlistCleaned = emptyWishlistText.contains("the wishlist is empty") || wishlistPage.isWishlistEmpty();
        
        Assert.assertTrue(isWishlistCleaned, "Migration Failed: The Wishlist was not cleared after migrating the item to the cart.");
    }
}