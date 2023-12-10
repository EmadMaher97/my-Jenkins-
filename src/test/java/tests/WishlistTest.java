package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDeatilesPage;
import pages.SearchForProductPage;
import pages.WishlistPage;

public class WishlistTest extends TestBase{
    ProductDeatilesPage productObject;
    WishlistPage wishlistObject;
    SearchForProductPage searchOpject;
    String productName="Apple MacBook Pro 13-inch";
    ProductDeatilesPage productDetalisObject;
    @Test(priority = 1)
    public void userCanSearchWithAutoSugest() throws InterruptedException {
        searchOpject=new SearchForProductPage(driver);
        searchOpject.productSearchUsinAutoSugest("MacB");
        productDetalisObject=new ProductDeatilesPage(driver);
        Assert.assertTrue(productDetalisObject.productnamebreadCrump.getText().equalsIgnoreCase(productName));
    }
    @Test(priority = 2)
    public void addToWisList()
    {
        productObject=new ProductDeatilesPage(driver);
        wishlistObject=new WishlistPage(driver);
        productObject.clickOnProductwishlist();


        Assert.assertTrue(wishlistObject.productName.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(wishlistObject.wishliesHeader.isDisplayed());
       System.out.println(wishlistObject.productName.getText());
       System.out.println(wishlistObject.wishliesHeader.getText());

    }
    @Test(priority = 3)
    public void removeAndUpdatewishiles()
    {
        wishlistObject=new WishlistPage(driver);
        wishlistObject.removeFromWishles();
        Assert.assertTrue(wishlistObject.empetyCart.getText().contains("The wishlist is empty!"));
        System.out.println(wishlistObject.empetyCart.getText());
    }
}
