package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCompareListPage;
import pages.ProductDeatilesPage;
import pages.SearchForProductPage;

public class AddToCompareListTest extends TestBase{
    ProductDeatilesPage productObject;
    SearchForProductPage searchOpject;
    AddToCompareListPage addtocomparObject;
    String product1="Apple MacBook Pro 13-inch";
    String product2="Asus N551JK-XO076H Laptop";
    String FirstProductPrice="$1,500.00";
    String SecondProductPrice="$1,800.00";
    String FirstProductMemory="16 GB";
    String SecondProductMemory="4 GB";
    @Test(priority = 1)
    public void userCanSearchWithAutoSugest() throws InterruptedException {
        searchOpject=new SearchForProductPage(driver);
        productObject=new ProductDeatilesPage(driver);
        addtocomparObject=new AddToCompareListPage(driver);
        searchOpject.productSearchUsinAutoSugest("MacB");
        Assert.assertTrue(productObject.productnamebreadCrump.getText().equalsIgnoreCase(product1));
        productObject.addToCompareList();
        Assert.assertTrue(productObject.assertAddingProduct.getText().contains("The product has been added to your "));
        System.out.println(productObject.assertAddingProduct.getText());
        searchOpject.productSearchUsinAutoSugest("Asus");
        Assert.assertTrue(productObject.productnamebreadCrump.getText().equalsIgnoreCase(product2));
        productObject.addToCompareList();
        productObject.goToCompareList();
        Assert.assertTrue(addtocomparObject.firstProduct.isDisplayed());
        System.out.println(addtocomparObject.firstProduct.getText());
        Assert.assertTrue(addtocomparObject.firstProductPrice.getText().equalsIgnoreCase(FirstProductPrice));
        System.out.println(addtocomparObject.firstProductPrice.getText());
        Assert.assertTrue(addtocomparObject.firstProductMemory.getText().equalsIgnoreCase(FirstProductMemory));
        System.out.println(addtocomparObject.firstProductMemory.getText());

        Assert.assertTrue(addtocomparObject.secondProduct.isDisplayed());
        System.out.println(addtocomparObject.secondProduct.getText());
        Assert.assertTrue(addtocomparObject.secondProductPrice.getText().equalsIgnoreCase(SecondProductPrice));
        System.out.println(addtocomparObject.secondProductPrice.getText());
        Assert.assertTrue(addtocomparObject.secondtProductMemory.getText().equalsIgnoreCase(SecondProductMemory));
        System.out.println(addtocomparObject.secondtProductMemory.getText());
        addtocomparObject.CompareProduct();

    }
    @Test(priority = 2)
    public void clearTheProducts()
    {
        addtocomparObject.clearItems();
        Assert.assertTrue(addtocomparObject.assertClear.getText().contains("You have no items to compare."));
        System.out.println(addtocomparObject.assertClear.getText());
    }

}
