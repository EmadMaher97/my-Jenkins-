package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithJavaFaker extends TestBase{
    HomePage homeObject;
    LoginPage loginOpject;
    UserRegistrationPage registerObject;
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    @Test(priority = 1,alwaysRun = true)

    public void userCanRegisterSuccessfully() throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);



        // Verify if the First name and Last name contain only alphabets
            registerObject.userRegistration(firstName,lastName, "15", "October", "1997",
                    email, password);
        System.out.println(" the user data is:"+firstName+ " "+lastName+" "+email+" "+password);
            Assert.assertTrue(registerObject.registerSuccessfully.getText().contains("Your registration completed"));
            System.out.println(registerObject.registerSuccessfully.getText());

        }

   @Test(dependsOnMethods = "userCanRegisterSuccessfully")
    public void userCanLoginSucessfully()
    {
        homeObject=new HomePage(driver);
        loginOpject=new LoginPage(driver);
        homeObject.openLoginPage();

        loginOpject.clickOnLoigin(email, password);
        Assert.assertTrue(loginOpject.logoutButton.getText().contains("Log out"));

    }

}
