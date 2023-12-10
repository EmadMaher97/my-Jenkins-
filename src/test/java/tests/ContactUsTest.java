package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsTest extends TestBase{
    ContactUsPage contactUsObject;
    @Test
    public void userCanContactUs()
    {
        contactUsObject=new ContactUsPage(driver);
        contactUsObject.clickOnContactUs("Emad","pleas answer me");
        Assert.assertTrue(contactUsObject.AsertPage.getText().contains("Contact Us"));
        System.out.println(contactUsObject.AsertPage.getText());
        Assert.assertTrue(contactUsObject.AsertsendingMessage.getText().contains("Your enquiry has been successfully sent to the store owner."));
        System.out.println(contactUsObject.AsertsendingMessage.getText());
    }
}
