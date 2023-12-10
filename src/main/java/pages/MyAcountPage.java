package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAcountPage extends PageBase{
    public MyAcountPage(WebDriver driver) {

        super(driver);
    }
    @FindBy(css = ".ico-account")
    WebElement myAcountLink;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a")
    WebElement changePassoward;

    @FindBy(id = "OldPassword")
    WebElement OldPassword;
    @FindBy(id = "NewPassword")
    WebElement NewPassword;
    @FindBy(id = "ConfirmNewPassword")
    WebElement ConfirmNewPassword;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button")
    WebElement clickOnChangePassoward;
    @FindBy(css = ".content")
    public WebElement passowrdChangedSuccessful;
    @FindBy(css = ".close")
    WebElement closeThMessage;
    public void clicOnMyAcount(String oldPass,String newPass)
    {
        clickButton(myAcountLink);
        clickButton(changePassoward);
        setTextButton(OldPassword,oldPass);
        setTextButton(NewPassword,newPass);
        setTextButton(ConfirmNewPassword,newPass);
        clickButton(clickOnChangePassoward);
        clickButton(closeThMessage);
    }
}
