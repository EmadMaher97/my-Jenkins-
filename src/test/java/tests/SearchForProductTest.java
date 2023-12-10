package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDeatilesPage;
import pages.SearchForProductPage;

public class SearchForProductTest extends TestBase{
    SearchForProductPage searchOpject;
    String productName="Apple MacBook Pro 13-inch";
    ProductDeatilesPage productDetalisObject;
    @Test
    public void userCanSerchForProduct()
    {

        searchOpject=new SearchForProductPage(driver);
        searchOpject.SearchForProduct(productName);
         productDetalisObject=new ProductDeatilesPage(driver);
        Assert.assertTrue(productDetalisObject.productnamebreadCrump.getText().equalsIgnoreCase(productName));
    }
}
