package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAcountPage;
import pages.UserRegistrationPage;

public class MyAcountTest extends TestBase{
    MyAcountPage myAcountObject;
    LoginPage loginOpject;
    HomePage homeObject;
    UserRegistrationPage registerOpject;
    @Test(priority = 1)
    public void userCanRegisterSuccessfully() throws InterruptedException {
        homeObject=new HomePage(driver);
        homeObject.openRegistrationPage();
        registerOpject=new UserRegistrationPage(driver);
        registerOpject.userRegistration("hala","maher","15","October",
                "1997","khalid2017@gmail.com","Hala2020@@");
        Assert.assertTrue(registerOpject.registerSuccessfully.getText().contains("Your registration completed"));


        System.out.println(registerOpject.registerSuccessfully.getText());

    }
    @Test(dependsOnMethods = "userCanRegisterSuccessfully")
    public void userCanLoginSucessfully()
    {
        homeObject=new HomePage(driver);
        loginOpject=new LoginPage(driver);
        homeObject.openLoginPage();

        loginOpject.clickOnLoigin("khalid2017@gmail.com","Hala2020@@");
        Assert.assertTrue(loginOpject.logoutButton.getText().contains("Log out"));

    }
    @Test(dependsOnMethods ="userCanLoginSucessfully")
    public void openMyAcount()
    {
        myAcountObject=new MyAcountPage(driver);
        myAcountObject.clicOnMyAcount("Hala2020@@","Hala2021@@");
        Assert.assertTrue(myAcountObject.passowrdChangedSuccessful.getText().contains("Password was changed"));
        System.out.println(myAcountObject.passowrdChangedSuccessful.getText());
    }
}
