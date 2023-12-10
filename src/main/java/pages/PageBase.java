package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
    public JavascriptExecutor jse;
    public Actions actions;
    public Select select;
   // protected WebDriver driver;
public  PageBase(WebDriver driver)
{
    PageFactory.initElements(driver,this);
}
public static void clickButton(WebElement button)
{
    button.click();
}
public  static void setTextButton(WebElement txtElement,String value)
{
    txtElement.sendKeys(value);
}
    }
