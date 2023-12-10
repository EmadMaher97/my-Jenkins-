package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDeatilesPage;

public class HoverMenuTest extends TestBase {
    HomePage homeObject;
    ProductDeatilesPage productObject;

    @Test
    public void userCanHoverOnProducts() {
        homeObject = new HomePage(driver);
        homeObject.HoverOnMenu();
/*        productObject = new ProductDeatilesPage(driver);
        Assert.assertTrue(productObject.assertHover.getText().contains("Notebooks"));
        System.out.println(productObject.assertHover.getText());*/
    }
}
