package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase{
    public WishlistPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "td.product")
    public WebElement productName ;
    @FindBy(css = "h1")
    public WebElement wishliesHeader;
    @FindBy(name = "updatecart")
    private WebElement updatecartBox;
    @FindBy(css = "button.remove-btn")
    private WebElement removefromcartbox;
    @FindBy(css = "div.no-data")
    public WebElement empetyCart;
    //The wishlist is empty!
    public void removeFromWishles()
    {

        clickButton(removefromcartbox);
    }
}
