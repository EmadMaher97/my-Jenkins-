package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);

        actions=new Actions(driver);

    }
    @FindBy(css = ".ico-register")
    WebElement registerButton;

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
    WebElement loginLinke;
    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
    WebElement logoutLink;
    @FindBy(id = "customerCurrency")
    WebElement currencyDropDownList;
    @FindBy(linkText = "Computers")
    WebElement ComputerMenu;
    @FindBy(linkText = "Electronics")
    WebElement ElectronicsMenu;
    @FindBy(linkText = "Cell phones")
    WebElement CellPhonesMenu ;
    @FindBy(linkText = "Notebooks")
     WebElement NotebookMenu ;

    public void  openRegistrationPage()
    {

        clickButton(registerButton);
    }
 public void  openLoginPage()
    {

        clickButton(loginLinke);
    }
    public void  changeCurrency()
    {
select=new Select(currencyDropDownList);
select.selectByVisibleText("Euro");

    }
    public void  HoverOnMenu()
    {
        actions.moveToElement(ComputerMenu).perform();
        actions.moveToElement(NotebookMenu).perform();
        actions.click().perform();

    }
    public void  clicimngOnLogout()
    {
       clickButton(logoutLink);

    }

}
