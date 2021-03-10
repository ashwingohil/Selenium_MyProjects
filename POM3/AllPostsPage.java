import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.html5.AddApplicationCache;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class AllPostsPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div/div[2]/div[2]/main/div[2]/div[1]/div[2]/a")
    WebElement clickAddNewPost;



    public AllPostsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickANewPost(){
        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        clickAddNewPost.click();

        try{
            Thread.sleep(10000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
        System.out.println("The total number of iframes are " + iframeElements.size());

    }

    public AddNewPostPage getAddNewPostPage(){
        return new AddNewPostPage(driver);
    }

}
