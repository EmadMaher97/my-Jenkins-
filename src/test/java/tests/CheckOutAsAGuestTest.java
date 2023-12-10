package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.CheckOutAsAGuestPage;
import pages.ProductDeatilesPage;
import pages.SearchForProductPage;

public class CheckOutAsAGuestTest extends TestBase{
    SearchForProductPage searchOpject;
    AddToCartPage addtocartObject;
    CheckOutAsAGuestPage checkOutGuestObject;
    String productName="Apple MacBook Pro 13-inch";
    ProductDeatilesPage productDetalisObject;
    @Test(priority = 1)
    public void userCanSearchWithAutoSugest() throws InterruptedException {
        searchOpject=new SearchForProductPage(driver);
        searchOpject.productSearchUsinAutoSugest("MacB");
        productDetalisObject=new ProductDeatilesPage(driver);
        Assert.assertTrue(productDetalisObject.productnamebreadCrump.getText().equalsIgnoreCase(productName));
        productDetalisObject.addTOCartClicking();
        Assert.assertTrue(productDetalisObject.assertAddingProductToCart.getText().contains("The product has been added to your"));
        System.out.println(productDetalisObject.assertAddingProductToCart.getText());
        productDetalisObject.goTOAddToCartPage();
    }
    @Test(priority = 2)
    public void DealWithItems()
    {
        addtocartObject=new AddToCartPage(driver);
        addtocartObject.DealingWithProductinShopingCart("24");
        Assert.assertTrue(addtocartObject.assertShoppingPage.getText().contains("Shopping"));
        System.out.println(addtocartObject.assertShoppingPage.getText());
        Assert.assertTrue(addtocartObject.assertProduct.getText().contains(productName));
        System.out.println(addtocartObject.assertProduct.getText());
    }
    @Test(priority = 3)
    public void checkOutAsAGuest() throws InterruptedException {
checkOutGuestObject=new CheckOutAsAGuestPage(driver);
checkOutGuestObject.goToCheckOutPage();
Assert.assertTrue(checkOutGuestObject.AssertCheckOutBage.getText().contains("Checkout"));
System.out.println(checkOutGuestObject.AssertCheckOutBage.getText());
checkOutGuestObject.FillBillingAddress("Emad","Maher","Emad@gmail.com","Algeria",
        "Algeria","Algeria","123456","01095982642");
Assert.assertTrue(checkOutGuestObject.assertCheckOutMessage.getText().contains("Your order has been successfully processed!"));
System.out.println(checkOutGuestObject.assertCheckOutMessage.getText());

    }
}
