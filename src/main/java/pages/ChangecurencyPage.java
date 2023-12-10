package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ChangecurencyPage extends PageBase{
    public ChangecurencyPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "customerCurrency")
    WebElement changeCurencyButtons;
    List<WebElement> changeCurencyButton;



    public void changecurrencyElement()
    {


    }
}
