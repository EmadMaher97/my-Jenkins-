package tests;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utiltie.Helper;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    public static String DonlowadPath=System.getProperty("user.dir")+"\\Donlowads";
    public  static FirefoxOptions firefoxOption()
    {
        FirefoxOptions option =new FirefoxOptions();
        option.addPreference("browser.download.folderList", 2);
        option.addPreference("browser.download.dir",DonlowadPath);
        option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
        option.addPreference("browser.download.manager.showWhenStarting", false);
        return option;

    }
    public  static ChromeOptions chromeOption()
    {
        HashMap<String, Object> chromRevrences=new HashMap<String, Object>();
        chromRevrences.put("profile.default_content_settings.popups", 0);
        chromRevrences.put("download.default_directory", DonlowadPath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromRevrences);
        //DesiredCapabilities cap = DesiredCapabilities.chrome();
        //	cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        //cap.setCapability(ChromeOptions.CAPABILITY, options);
        return options;
    }

    @Parameters(("browser"))
    @BeforeSuite
    public void StartDriver(@Optional("firefox")String browserName)
    {
        if (browserName.equalsIgnoreCase("firefox"))
        {
            driver=new FirefoxDriver(firefoxOption());
        }
        else if (browserName.equalsIgnoreCase("chrome"))
        {
            driver=new ChromeDriver(chromeOption());
        }

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
driver.navigate().to("https://demo.nopcommerce.com/");

    }
    @AfterSuite
    public void StopDriver()
    {
       driver.quit();

    }

        @AfterMethod
        public void screenShootOnFiler(ITestResult result)
        {
            if(result.getStatus()==ITestResult.FAILURE)
            {
                System.out.println("Filed!");
                System.out.println("Taking ScreenShoot");
                Helper.caprureScreenShoot(driver, result.getName());


            }
    }
}
