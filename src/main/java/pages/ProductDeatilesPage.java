package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDeatilesPage extends PageBase{
    public ProductDeatilesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "strong.current-item")
   public WebElement productnamebreadCrump;
    @FindBy(id = "price-value-4")
   public WebElement productPricelable;

    @FindBy(linkText = "Add your review")
    public WebElement AddProductReviewlink;
    @FindBy(id = "add-to-wishlist-button-4")
    WebElement addToWishlist;

    @FindBy(id = "add-to-cart-button-4")
    WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
    public WebElement assertAddingProductToCart;
    @FindBy(linkText = "shopping cart")
     WebElement goToShopping;


    @FindBy(linkText = "wishlist")
     WebElement wishlistlink;
    @FindBy(css = "h1")
    public WebElement assertHover;
    @FindBy(css = "button.button-2.add-to-compare-list-button")
    WebElement addToCompareList;
    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
    public WebElement assertAddingProduct;
    @FindBy(linkText = "product comparison")
    WebElement productComparison;


    public void clickOnProductReviewPage()
    {
        clickButton(AddProductReviewlink);
    }
    public void clickOnProductwishlist()
    {
        clickButton(addToWishlist);
        clickButton(wishlistlink);
    }
    public void addToCompareList()
    {
        clickButton(addToCompareList);

    }
    public void goToCompareList()
    {

        clickButton(productComparison);
    }
    public void addTOCartClicking()
    {

        clickButton(addToCartButton);
    }
    public void goTOAddToCartPage()
    {

        clickButton(goToShopping);
    }

}
