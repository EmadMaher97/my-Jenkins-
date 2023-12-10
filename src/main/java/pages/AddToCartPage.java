package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddToCartPage extends PageBase{
    public AddToCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "h1")
    public WebElement assertShoppingPage;
    @FindBy(css = "a.product-name")
    public WebElement assertProduct;
    @FindBy(css = "table.cart")
    WebElement   cartTable;
    @FindBy(tagName = "tr")
    List<WebElement> rows;
    @FindBy(tagName = "td")
    List<WebElement> cells;
    @FindBy(css = "input.qty-input")
    WebElement quantity;
    @FindBy(id = "updatecart")
    WebElement updatingCart;
    @FindBy(css = "td.subtotal")
    WebElement printTotalPrice;
    @FindBy(css = "button.remove-btn")
     WebElement RemoveFromCart;
    @FindBy(css = "div.no-data")
    public WebElement AssertRemovingItemsFromCart;

    public void DealingWithProductinShopingCart(String increasQuantity)
    {
        quantity.clear();
        setTextButton(quantity,increasQuantity);
        String quantityValue = quantity.getAttribute("value");
        System.out.println("quantityNumber: " +quantityValue);
        String subtotal = printTotalPrice.getText();
        System.out.println("Subtotal: " + subtotal);
        clickButton(updatingCart);
        String subtotal2 = printTotalPrice.getText();
        System.out.println("Subtotal: " + subtotal2);


    }
    public void removingElementsfromCart()
    {
        clickButton(RemoveFromCart);
    }

}
