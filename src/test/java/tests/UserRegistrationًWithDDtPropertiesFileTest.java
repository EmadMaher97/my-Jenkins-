package tests;

import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationًWithDDtPropertiesFileTest extends TestBase{
    HomePage homeObject;
    LoginPage loginOpject;
    UserRegistrationPage registerObject;
    String Fn= LoadProperties.userData.getProperty("firstName");
    String Ln= LoadProperties.userData.getProperty("lastName");
    String Em= LoadProperties.userData.getProperty("email");
    String Pas= LoadProperties.userData.getProperty("password");


    @Test()
    public void userCanRegisterSuccessfully() throws InterruptedException {
        System.out.println(LoadProperties.userData);
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);


            registerObject.userRegistration(Fn, Ln, "15", "October", "1997",
                    Em,Pas );
            Assert.assertTrue(registerObject.registerSuccessfully.getText().contains("Your registration completed"));
            System.out.println(registerObject.registerSuccessfully.getText());
        loginOpject=new LoginPage(driver);
        homeObject.openLoginPage();

        loginOpject.clickOnLoigin(Em,Pas);
        Assert.assertTrue(loginOpject.logoutButton.getText().contains("Log out"));
        System.out.println(loginOpject.logoutButton.getText());
        homeObject.clicimngOnLogout();


    }


}
