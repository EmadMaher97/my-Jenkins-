package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailAFriendPage extends PageBase{
    public EmailAFriendPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[9]/div[3]/button")
    WebElement EmailFriend;
    @FindBy(id = "FriendEmail")
    WebElement friendEmail;
    @FindBy(id = "YourEmailAddress")
    WebElement yourEmailAddress;
    @FindBy(id = "PersonalMessage")
    WebElement personalMessage;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button")
    WebElement clickSend;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[1]/h1")
    public  WebElement AsertPage;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]")
    public  WebElement AsertsendingMessage;

    public void openEmailAFriendPage(String FEmail,String messages)
    {
        clickButton(EmailFriend);
        setTextButton(friendEmail,FEmail);
        setTextButton(personalMessage,messages);
        clickButton(clickSend);
    }
}
