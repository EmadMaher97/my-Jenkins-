package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    WebElement emailText;
    @FindBy(id = "Password")
    WebElement PasswordText;
    @FindBy(css = ".login-button")
    WebElement loginButtonClick;
    @FindBy(css = ".ico-logout")
    public WebElement logoutButton;
    public void clickOnLoigin(String email,String passoward)
    {


        emailText.sendKeys(email);
        PasswordText.sendKeys(passoward);
        clickButton(loginButtonClick);
    }
}
