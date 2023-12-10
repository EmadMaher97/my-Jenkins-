package utiltie;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class Helper {
    //method to tack screenShoot When the test fail
    public static void caprureScreenShoot(WebDriver driver,String screenShootName)
    {
        Path deth=Paths.get("./Screenshots",screenShootName+".png");
        try {
            Files.createDirectories(deth.getParent());
            FileOutputStream out =new FileOutputStream(deth.toString());
            out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            out.close();

        } catch (IOException e) {

            System.out.println("Expetion While Taking ScreenShoot "+e.getMessage())	;	}
    }

}
