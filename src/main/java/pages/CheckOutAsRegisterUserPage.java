package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutAsRegisterUserPage extends PageBase
{
    public CheckOutAsRegisterUserPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "termsofservice")
    WebElement checkBox;
    @FindBy(id = "checkout")
    WebElement checkoutButton;
    @FindBy(css = "h1")
    public WebElement AssertCheckOutBage;

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement BillingNewAddress_CountryId;
    @FindBy(id = "BillingNewAddress_City")
    WebElement BillingNewAddress_City;
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement BillingNewAddress_Address1;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement BillingNewAddress_ZipPostalCode;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement BillingNewAddress_PhoneNumber;
    @FindBy(css = "button.button-1.new-address-next-step-button")
    WebElement clickContinue;
    @FindBy(id = "shippingoption_1")
    WebElement shippingoption_1;
    @FindBy(css = "button.button-1.shipping-method-next-step-button")
    WebElement ShippingMethodContinue;
    @FindBy(css = "button.button-1.payment-method-next-step-button")
    WebElement shippingPayment;
    @FindBy(css = "button.button-1.payment-info-next-step-button")
    WebElement paymentInfo;
    @FindBy(css = "button.button-1.confirm-order-next-step-button")
    WebElement confirmCheckout;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")
    public   WebElement assertCheckOutMessage;
    @FindBy(linkText = "Click here for order details.")
    WebElement orderDetailsLink;
    public void goToCheckOutPage()
    {
        clickButton(checkBox);
        clickButton(checkoutButton);

    }

    public void FillBillingAddress(String country,
                                   String city,String address,String zipCode,String mobileNumber) throws InterruptedException {


        Select select = new Select(BillingNewAddress_CountryId);
        select.selectByVisibleText(country);
        setTextButton(BillingNewAddress_City,city);
        setTextButton(BillingNewAddress_Address1,address);
        setTextButton(BillingNewAddress_ZipPostalCode,zipCode);
        setTextButton(BillingNewAddress_PhoneNumber,mobileNumber);
        clickButton(clickContinue);
        clickButton(shippingoption_1);
        Thread.sleep(1000);
        clickButton(ShippingMethodContinue);
        Thread.sleep(1000);
        clickButton(shippingPayment);
        Thread.sleep(1000);
        clickButton(paymentInfo);
        Thread.sleep(1000);
        clickButton(confirmCheckout);

    }
    public void vieworderDetalis()
    {
        clickButton(orderDetailsLink);

    }


}
