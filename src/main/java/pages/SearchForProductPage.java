package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchForProductPage extends PageBase{
    public SearchForProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "small-searchterms")
    WebElement searchTextBox;
    @FindBy(css = ".search-box-button")
    WebElement ClickSearch;
   // @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[1]/form/div[2]/button")
   // WebElement clickSear;
   @FindBy(linkText = "Apple MacBook Pro 13-inch")
   public WebElement clickOnLinek;
    @FindBy(id = "ui-id-1")
    List<WebElement> productList;
    @FindBy(css = "/html/body/div[6]/div[3]/div/div[1]/ul/li[4]/strong")
   public WebElement assertItem;
    public void SearchForProduct(String productName)
    {
      setTextButton(searchTextBox,productName);
      clickButton(ClickSearch);
      clickButton(clickOnLinek);

    }
    public void openProductDeatilspage()
    {

        clickButton(clickOnLinek);

    }
    public void productSearchUsinAutoSugest(String search) throws InterruptedException {

       setTextButton(searchTextBox,search);
       Thread.sleep(2000);
       productList.get(0).click();
    }
}
