package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EmailAFriendTest extends TestBase{
    EmailAFriendPage emailAFriendobject;
    SearchForProductPage searchOpject;
    String productName="Apple MacBook Pro 13-inch";
    ProductDeatilesPage productDetalisObject;
    HomePage homeObject;
    LoginPage loginOpject;
    UserRegistrationPage registerOpject;
    UserRegistrationPage registerObject;
    @Test(priority = 1)
    public void userCanRegisterSuccessfully() throws InterruptedException {
        homeObject=new HomePage(driver);
        homeObject.openRegistrationPage();
        registerOpject=new UserRegistrationPage(driver);
        registerOpject.userRegistration("hala","maher","15","October",
                "1997","khalid2057@gmail.com","Hala2020@@");
        Assert.assertTrue(registerOpject.registerSuccessfully.getText().contains("Your registration completed"));


        System.out.println(registerOpject.registerSuccessfully.getText());

    }
    @Test(dependsOnMethods = "userCanRegisterSuccessfully")
    public void userCanLoginSucessfully()
    {
        homeObject=new HomePage(driver);
        loginOpject=new LoginPage(driver);
        homeObject.openLoginPage();

        loginOpject.clickOnLoigin("khalid2057@gmail.com","Hala2020@@");
        Assert.assertTrue(loginOpject.logoutButton.getText().contains("Log out"));

    }
    @Test(dependsOnMethods = "userCanLoginSucessfully")
    public void userCanSearchWithAutoSugest() throws InterruptedException {
        searchOpject=new SearchForProductPage(driver);
        searchOpject.productSearchUsinAutoSugest("MacB");
        productDetalisObject=new ProductDeatilesPage(driver);
        Assert.assertTrue(productDetalisObject.productnamebreadCrump.getText().equalsIgnoreCase(productName));
    }
    @Test(dependsOnMethods = "userCanSearchWithAutoSugest")
    public void emailAfriendForProduct()  {
        emailAFriendobject=new EmailAFriendPage(driver);

        emailAFriendobject.openEmailAFriendPage("ahmed123@gmail.com","please chose this item");
        Assert.assertTrue(emailAFriendobject.AsertPage.getText().equalsIgnoreCase("Email a friend"));
        Assert.assertTrue(emailAFriendobject.AsertsendingMessage.getText().equalsIgnoreCase("Your message has been sent."));
    }

}
