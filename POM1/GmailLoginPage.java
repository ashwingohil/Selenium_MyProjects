import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class GmailLoginPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, xpath = "//input[@id='identifierId']\n")
    WebElement username;

    @FindBy(how = How.XPATH, xpath = "//div[@class='VfPpkd-RLmnJb']")
    WebElement userameNextButton;

    @FindBy(how = How.XPATH, xpath = "//input[@type='password']")
    WebElement password;

    @FindBy(how = How.XPATH, xpath = "//div[@id='passwordNext']//div[@class='VfPpkd-dgl2Hf-ppHlrf-sM5MNb']//button[@type='button']//div[@class='VfPpkd-RLmnJb']")
    WebElement passwordNextButton;

    public GmailLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setUsername(String username){
        this.username.sendKeys(username); //note the use of this
    }

    public void usernameNext(){
        userameNextButton.click();
    }

    public void setPassword(String password){

        //This is one way to wait

        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        

        //This is explicit wait. I can give conditions also. Check out methods
        //WebDriverWait wait = new WebDriverWait(driver,3); //This is also other type of wait

        /*
        //Below is method of Function class. After writing the below line, you need to write @Override and select "apply"
        //This is tricky haven't understood it correctly
        WebElement passwordcopy = this.password;
        Function<WebDriver,Boolean> function = new Function<WebDriver, Boolean>(){
            @Override
            public Boolean apply(WebDriver driver) {

                try{
                    passwordcopy.sendKeys(password);
                    return true;
                }catch(StaleElementReferenceException ex){
                    ex.printStackTrace();
                    return false;
                }
            }
        };
        wait.until(function); //this is used with WebDriverWait
        */


        this.password.sendKeys(password);
    }

    public void passwordNext(){
        passwordNextButton.click();
    }

    public GetInboxPage getInbox(){
        return new GetInboxPage(driver);
    }

}
