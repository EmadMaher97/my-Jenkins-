package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductReviewPage extends PageBase{
    public AddProductReviewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "AddProductReview_Title")
    WebElement AddProductReview_Title;
    @FindBy(id = "AddProductReview_ReviewText")
    WebElement AddProductReview_ReviewText;
    @FindBy(id = "addproductrating_4")
    WebElement AddProductRating;
    @FindBy(xpath = "//*[@id=\"review-form\"]/form/div[2]/button")
    WebElement clickOnSubmit;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")
   public WebElement AssertMessage;
    public void AddProductReview(String title,String TextMessage)
    {
setTextButton(AddProductReview_Title,title);
setTextButton(AddProductReview_ReviewText,TextMessage);
clickButton(AddProductRating);
clickButton(clickOnSubmit);
    }
}
