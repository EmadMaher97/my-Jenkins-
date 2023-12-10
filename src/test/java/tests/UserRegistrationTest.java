package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{
    HomePage homeObject;
    LoginPage loginOpject;
    UserRegistrationPage registerObject;
    @Test
    public void userCanRegisterSuccessfully() throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);

        String firstName = "hala";
        String lastName = "maher";
        // Other registration fields...

        // Verify if the First name and Last name contain only alphabets
        if (firstName.matches("^[a-zA-Z]+$") && lastName.matches("^[a-zA-Z]+$")) {
            registerObject.userRegistration(firstName, lastName, "15", "October", "1997",
                    "khalid1343@gmail.com", "Hala2020@@");
            Assert.assertTrue(registerObject.registerSuccessfully.getText().contains("Your registration completed"));
            System.out.println(registerObject.registerSuccessfully.getText());
        } else {
            if (!firstName.matches("^[a-zA-Z]+$")) {
                System.out.println("Invalid First name: " + firstName);
            }
            if (!lastName.matches("^[a-zA-Z]+$")) {
                System.out.println("Invalid Last name: " + lastName);
            }
        }
    }
   @Test(dependsOnMethods = "userCanRegisterSuccessfully")
    public void userCanLoginSucessfully()
    {
        homeObject=new HomePage(driver);
        loginOpject=new LoginPage(driver);
        homeObject.openLoginPage();

        loginOpject.clickOnLoigin("khalid1343@gmail.com","Hala2020@@");
        Assert.assertTrue(loginOpject.logoutButton.getText().contains("Log out"));

    }

}
