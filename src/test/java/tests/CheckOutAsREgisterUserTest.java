package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckOutAsREgisterUserTest  extends TestBase{
    SearchForProductPage searchOpject;
    String productName="Apple MacBook Pro 13-inch";
    ProductDeatilesPage productDetalisObject;
    HomePage homeObject;
    LoginPage loginOpject;
    UserRegistrationPage registerOpject;
    AddToCartPage addtocartObject;
    CheckOutAsRegisterUserPage CheckOutAsRegisterUserObject;
    PrintOrderDeatilsPdfPage printOrderDeatilsPdfObject;

    @Test(priority = 1)
    public void userCanRegisterSuccessfully() throws InterruptedException {
        homeObject=new HomePage(driver);
        homeObject.openRegistrationPage();
        registerOpject=new UserRegistrationPage(driver);
        registerOpject.userRegistration("hala","maher","15","October",
                "1997","khali67d3187@gmail.com","Hala2020@@");
        Assert.assertTrue(registerOpject.registerSuccessfully.getText().contains("Your registration completed"));


        System.out.println(registerOpject.registerSuccessfully.getText());

    }
    @Test(priority = 2)
    public void userCanLoginSucessfully()
    {
        homeObject=new HomePage(driver);
        loginOpject=new LoginPage(driver);
        homeObject.openLoginPage();

        loginOpject.clickOnLoigin("khali67d3187@gmail.com","Hala2020@@");
        Assert.assertTrue(loginOpject.logoutButton.getText().contains("Log out"));

    }
    @Test(priority = 3)
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
    @Test(priority = 4)
    public void DealWithItems()
    {
        addtocartObject=new AddToCartPage(driver);
        addtocartObject.DealingWithProductinShopingCart("24");
        Assert.assertTrue(addtocartObject.assertShoppingPage.getText().contains("Shopping"));
        System.out.println(addtocartObject.assertShoppingPage.getText());
        Assert.assertTrue(addtocartObject.assertProduct.getText().contains(productName));
        System.out.println(addtocartObject.assertProduct.getText());
    }
    @Test(priority = 5)
    public void checkOutAsRegisterUser() throws InterruptedException {
        CheckOutAsRegisterUserObject= new CheckOutAsRegisterUserPage(driver);
        printOrderDeatilsPdfObject= new PrintOrderDeatilsPdfPage(driver);
        CheckOutAsRegisterUserObject.goToCheckOutPage();
        Assert.assertTrue(CheckOutAsRegisterUserObject.AssertCheckOutBage.getText().contains("Checkout"));
        System.out.println(CheckOutAsRegisterUserObject.AssertCheckOutBage.getText());
        CheckOutAsRegisterUserObject.FillBillingAddress("Algeria",
                "Algeria","Algeria","123456","01095982642");
        Assert.assertTrue(CheckOutAsRegisterUserObject.assertCheckOutMessage.getText().contains("Your order has been successfully processed!"));
        System.out.println(CheckOutAsRegisterUserObject.assertCheckOutMessage.getText());
        CheckOutAsRegisterUserObject.vieworderDetalis();
        printOrderDeatilsPdfObject.printOrderDeatils();

    }
}
