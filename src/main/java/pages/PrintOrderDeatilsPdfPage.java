package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrintOrderDeatilsPdfPage extends PageBase{
    public PrintOrderDeatilsPdfPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a.button-2.pdf-invoice-button")
    WebElement donlowadPdf;
    @FindBy(css = "a.button-2.print-order-button")
    WebElement OrderDeatilsPrintButton;

    @FindBy(css = "cr-button.action-button")
    WebElement clickPrint;

    public void printOrderDeatils()
    {
        clickButton(donlowadPdf);
        clickButton(OrderDeatilsPrintButton);
    }

}
