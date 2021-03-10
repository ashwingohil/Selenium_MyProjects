import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FacebookUserPage {

    WebDriver driver;

    public FacebookUserPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}
