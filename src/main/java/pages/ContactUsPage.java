package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;
    @FindBy(id = "FullName")
    WebElement firstName;
    @FindBy(id = "Email")
    WebElement email;
    @FindBy(xpath = "//*[@id=\"Enquiry\"]")
    WebElement message;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button")
    WebElement clickSubmit;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[1]/h1")
    public  WebElement AsertPage;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]")
    public  WebElement AsertsendingMessage;

    public void clickOnContactUs(String FName,String messages)
    {
        clickButton(contactUsLink);
        setTextButton(firstName,FName);
        setTextButton(message,messages);
        clickButton(clickSubmit);

    }
}

