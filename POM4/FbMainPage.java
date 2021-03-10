import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FbMainPage {

    public static final String pageURL = "https://www.facebook.com/";
    public static final String pageTitle = "Facebook - log in or signup";

    WebDriver driver;

    @FindBy(how = How.CSS, css = "input#email")
    WebElement emailField;

    @FindBy(how = How.CSS, css = "input#pass")
    WebElement passwordField;

    @FindBy(how = How.CSS, css = "button#u_0_b")
    WebElement loginButton;

    @FindBy(how = How.CSS, css = "a#u_0_2")
    WebElement createNewAccount;

    public FbMainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void setupEmailField(String email){
       emailField.sendKeys(email);
        Assert.assertEquals(emailField.getAttribute("value"),email); //important
    }

    public void setupPasswordField(String password){
        passwordField.sendKeys(password);
        Assert.assertEquals(passwordField.getAttribute("value"),password);
    }

    public void clickLogin(){
        loginButton.click();
    }

    public void clickCreateAccount(){
        createNewAccount.click();
    }


}
