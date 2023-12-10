package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserRegistrationPage extends PageBase {
    public UserRegistrationPage(WebDriver driver) {
        super(driver);


    }
    @FindBy(id = "gender-male")
    WebElement GenderButton;
    @FindBy(id = "FirstName")
    WebElement FName;
    @FindBy(id = "LastName")
    WebElement Lname;

    @FindBy(name = ("DateOfBirthDay"))
    WebElement Day;
    @FindBy(name = "DateOfBirthMonth")
    WebElement month;
    @FindBy(name = "DateOfBirthYear")
    WebElement year;
    @FindBy(id = "Email")
    WebElement Email;
    @FindBy(id = "Password")
    WebElement PasswordTextBox;
    @FindBy(id = "ConfirmPassword")
    WebElement CnfirmPasswordTextBox;
    @FindBy(id = "register-button")
    WebElement RegisterButton;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")
    public WebElement registerSuccessfully;


    public void userRegistration(String FirstName,String LastName,String day,
                                 String months,String years,String email,String passowrd) throws InterruptedException {
        clickButton(GenderButton);
        setTextButton(FName,FirstName);
        setTextButton(Lname,LastName);
        Select select = new Select(Day);
        select.selectByVisibleText(day);
        Select select1 = new Select(month);
        select1.selectByVisibleText(months);
        Select select2 = new Select(year);
        select2.selectByVisibleText(years);
        setTextButton(Email,email);
        setTextButton(PasswordTextBox,passowrd);
        setTextButton(CnfirmPasswordTextBox,passowrd);
        clickButton(RegisterButton);




    }
    public void userRegistration2(String FirstName,String LastName,String email,String passowrd) throws InterruptedException {
        clickButton(GenderButton);
        setTextButton(FName,FirstName);
        setTextButton(Lname,LastName);
        setTextButton(Email,email);
        setTextButton(PasswordTextBox,passowrd);
        setTextButton(CnfirmPasswordTextBox,passowrd);
        clickButton(RegisterButton);




    }
   /* public void userCanLogout()
    {
        clickButton(logoutButton);
    }*/

}
