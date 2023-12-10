package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddProductReviewTest extends TestBase{
    SearchForProductPage searchOpject;
    String productName="Apple MacBook Pro 13-inch";
    ProductDeatilesPage productObject;
    HomePage homeObject;
    UserRegistrationPage registerOpject;
    LoginPage loginObject;
    AddProductReviewPage AddProductReviewObject;

    UserRegistrationPage registerObject;
    @Test(priority = 1)
    public void userCanRegisterSuccessfully() throws InterruptedException {
        homeObject=new HomePage(driver);
        homeObject.openRegistrationPage();
        registerOpject=new UserRegistrationPage(driver);
        registerOpject.userRegistration("hala","maher","15","October",
                "1997","khalid2056@gmail.com","Hala2020@@");
        Assert.assertTrue(registerOpject.registerSuccessfully.getText().contains("Your registration completed"));


        System.out.println(registerOpject.registerSuccessfully.getText());

    }
    @Test(dependsOnMethods = "userCanRegisterSuccessfully")
    public void userCanLoginSuccessfully()
    {
        homeObject=new HomePage(driver);
        loginObject =new LoginPage(driver);
        homeObject.openLoginPage();

        loginObject.clickOnLoigin("khalid2056@gmail.com","Hala2020@@");
        Assert.assertTrue(loginObject.logoutButton.getText().contains("Log out"));

    }
    @Test(dependsOnMethods = "userCanLoginSuccessfully")
    public void userCanSearchWithAutoSugest() throws InterruptedException {
        searchOpject=new SearchForProductPage(driver);
        searchOpject.productSearchUsinAutoSugest("MacB");
        productObject=new ProductDeatilesPage(driver);
        Assert.assertTrue(productObject.productnamebreadCrump.getText().equalsIgnoreCase(productName));
        System.out.println(productObject.productnamebreadCrump.getText());
    }
    @Test(dependsOnMethods = "userCanSearchWithAutoSugest")
    public void userCanAddProductReview() {
        productObject=new ProductDeatilesPage(driver);
        productObject.clickOnProductReviewPage();
        AddProductReviewObject=new AddProductReviewPage(driver);
       AddProductReviewObject.AddProductReview("Rating_Item","the item is good");
        Assert.assertTrue(AddProductReviewObject.AssertMessage.getText().contains("Product review is successfully added."));
       System.out.println(AddProductReviewObject.AssertMessage.getText());
    }

}
