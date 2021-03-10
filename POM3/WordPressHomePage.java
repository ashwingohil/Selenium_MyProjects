import config.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordPressHomePage {

    WebDriver driver;

    @FindBy(how = How.XPATH, xpath = "//a[@class='x-nav-link x-link'][contains(text(),'Log In')]")
    WebElement LoginButton;


    public WordPressHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WordPressLoginPage clickLoginButton(){
        LoginButton.click();
        return new WordPressLoginPage(driver);
    }



}
