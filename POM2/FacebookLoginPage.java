import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {

    WebDriver driver;

    @FindBy(how = How.ID, id = "email")
    WebElement username;

    @FindBy(how = How.ID, id = "pass")
    WebElement password;

    //@FindBy(how = How.XPATH, xpath = "//button[@id='u_0_f']")
    //WebElement LoginButton;

    @FindBy(how = How.XPATH, xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/button[1]")
    WebElement LoginButton;

    public FacebookLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setUsername(String username){
        this.username.sendKeys(username);
    }

    public void setPassword(String password){
        this.password.sendKeys(password);
    }

    public void clickLogin(){
        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        this.LoginButton.click();
    }

    public FacebookUserPage getFacebookUserPage(){
        return new FacebookUserPage(driver);
    }
}
