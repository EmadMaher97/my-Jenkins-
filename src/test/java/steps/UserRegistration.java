package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {
    HomePage homeOpject;
    UserRegistrationPage userregisterOpjectt;
    LoginPage loginOpject;
    @Given("the user in the home page")
    public void the_user_in_the_home_page() {
        homeOpject=new HomePage(driver);
        homeOpject.openRegistrationPage();
    }
    @When("i click on register link")
    public void i_click_on_register_link() {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));

    }

    /*
     * @When("I entered the user data") public void i_entered_the_user_data() {
     * userregisterOpjectt=new UserRegistrationPage(driver);
     * userregisterOpjectt.userRegistration("emad", "maher", "emad9302@gmail.com",
     * "123654"); }
     */
    @When("I entered {string} , {string} , {string} , {string}")
    public void i_entered(String firstname, String lastname, String email, String password) throws InterruptedException {
        userregisterOpjectt=new UserRegistrationPage(driver);
        userregisterOpjectt.userRegistration2(firstname, lastname,email,password);
    }
    @Then("the registration page displayed sucessfully")
    public void the_registration_page_displayed_sucessfully() {
        homeOpject.openLoginPage();
        loginOpject=new LoginPage(driver);
        loginOpject.clickOnLoigin( "ahsmead@user434.com", "12345678");
        homeOpject.clicimngOnLogout();
    }
}
