import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WordPressUserPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div/div[2]/div[1]/div/ul/li/div[2]/ul[2]/li[1]/h2/span")
    WebElement siteLink;

    @FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div/div[2]/div[1]/div/ul/li/div[2]/ul[2]/li[2]/ul/li[2]/a/span")
    WebElement postsLink;

    public WordPressUserPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void clickSiteLink(){

        System.out.println("Inside sitelink");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        siteLink.click();
    }

    public void clickPostsLink(){
        postsLink.click();
    }

    public AllPostsPage getAllPostPage(){
        return new AllPostsPage(driver);
    }

}
