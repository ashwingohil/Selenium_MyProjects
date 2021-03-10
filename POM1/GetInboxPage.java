import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GetInboxPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, xpath = "//img[@class='gb_uc']")
    WebElement gmailHeader;

    public GetInboxPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean getGmailVisbility(){
        boolean truth;
        truth = gmailHeader.isEnabled();
        System.out.println("Truth is: "+truth);
        return truth;
    }
}
