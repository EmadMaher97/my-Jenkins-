package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationًWithDDtTest extends TestBase{
    HomePage homeObject;
    LoginPage loginOpject;
    UserRegistrationPage registerObject;
    @DataProvider(name = "TestData")
    public static Object[][]userData()
    {
return  new Object[][]{
        {
            "ali","maher","khalid2095@gmail.com","Khalid1010@@"
        },
        {
            "ahmed","ali","khalid2096@gmail.com","Khalid1010@@"
        }
};
    }

    @Test(dataProvider = "TestData")
    public void userCanRegisterSuccessfully(String fiiName,String LaName,String EMail,String Passs) throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);


            registerObject.userRegistration(fiiName, LaName, "15", "October", "1997",
                    EMail,Passs );
            Assert.assertTrue(registerObject.registerSuccessfully.getText().contains("Your registration completed"));
            System.out.println(registerObject.registerSuccessfully.getText());
        loginOpject=new LoginPage(driver);
        homeObject.openLoginPage();

        loginOpject.clickOnLoigin(EMail,Passs);
        Assert.assertTrue(loginOpject.logoutButton.getText().contains("Log out"));
        System.out.println(loginOpject.logoutButton.getText());
        homeObject.clicimngOnLogout();


    }


}
