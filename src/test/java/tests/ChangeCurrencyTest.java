package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDeatilesPage;
import pages.SearchForProductPage;

public class ChangeCurrencyTest extends TestBase{
HomePage homeObject;
    SearchForProductPage searchOpject;
    String productName="Apple MacBook Pro 13-inch";
    ProductDeatilesPage productDetalisObject;
ProductDeatilesPage ProductDeatilesObject;

@Test(priority = 1)
    public  void UserCanchangecurrency()
{
    homeObject=new HomePage(driver);
    homeObject.changeCurrency();


}
    @Test(priority = 2)
    public void userCanSearchWithAutoSugistt()
    {
        searchOpject =new SearchForProductPage(driver);

        try {
            searchOpject.productSearchUsinAutoSugest("MacB");
            productDetalisObject=new ProductDeatilesPage(driver);
            Assert.assertEquals(productDetalisObject.productnamebreadCrump.getText(), productName);
            Assert.assertTrue(productDetalisObject.productPricelable.getText().contains("€") );
            System.out.println(productDetalisObject.productPricelable.getText());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
