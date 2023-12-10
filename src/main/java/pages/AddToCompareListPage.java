package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddToCompareListPage extends PageBase{
    public AddToCompareListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "h1")
    WebElement CompareProductAssert;
    @FindBy(css = "button.button-2.remove-button")
    WebElement RemoveProduct;
    @FindBy(css = "table.compare-products-table")
    WebElement   compareProductTable;
@FindBy(tagName = "tr")
 private  List<WebElement>allRows;
    @FindBy(tagName = "td")
    private  List<WebElement>allCols;
    @FindBy(css = "a.clear-list")
    WebElement ClearList;
    @FindBy(css = "div.no-data")
   public WebElement assertClear;

    @FindBy(linkText = "Asus N551JK-XO076H Laptop")
   public WebElement firstProduct;
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
  public   WebElement secondProduct;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[4]/td[2]")
  public   WebElement firstProductPrice;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[4]/td[3]")
  public   WebElement secondProductPrice;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[7]/td[2]")
    public   WebElement firstProductMemory;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[7]/td[3]")
    public   WebElement secondtProductMemory;

    public void clearItems()
    {
        clickButton(ClearList);
    }
    public void CompareProduct()
    {
        System.out.println(allRows.size());
        for (WebElement row:allRows)
        {
            System.out.println(row.getText()+"\t");
            for (WebElement col:allCols)
            {
                System.out.println(col.getText()+"\t");
            }
        }


    }
}
