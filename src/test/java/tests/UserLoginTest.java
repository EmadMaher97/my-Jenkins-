package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserLoginTest extends TestBase{
    LoginPage loginOpject;
    HomePage homeObject;
    UserRegistrationPage registerOpject;
    @Test(priority = 1)
    public void userCanRegisterSuccessfully() throws InterruptedException {
        homeObject=new HomePage(driver);
        homeObject.openRegistrationPage();
        registerOpject=new UserRegistrationPage(driver);
        registerOpject.userRegistration("hala","maher","15","October",
                "1997","khalid2033@gmail.com","Hala2020@@");
        Assert.assertTrue(registerOpject.registerSuccessfully.getText().contains("Your registration completed"));


        System.out.println(registerOpject.registerSuccessfully.getText());

    }

}
