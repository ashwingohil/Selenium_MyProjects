import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewPostPage {

    WebDriver driver;
    String frameUrl = "https://pwnmojo.wordpress.com/wp-admin/post-new.php?calypsoify=1&block-editor=1&frame-nonce=35840ee6fd&origin=https%3A%2F%2Fwordpress.com&environment-id=production&support_user&_support_token";

    @FindBy(how = How.XPATH, xpath = "//*[@id=\"post-title-0\"]")
    WebElement writeTitle;

    @FindBy(how = How.XPATH, xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/div[3]/div[2]/p[1]")
    WebElement writeDescription;

    @FindBy(how = How.CLASS_NAME, className = "block-editor-rich-text__editable block-editor-block-list__block wp-block is-selected rich-text")
    WebElement writeDescription1;

    @FindBy(how = How.XPATH, xpath = "//button[contains(text(),'Publish')]")
    WebElement publish1;

    //on earlier version of POM this had worked
    @FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[3]/div/div/div/div[1]/div[1]/button")
    WebElement publish2;

    //this worked
    @FindBy(how=How.XPATH, xpath = "//div[@class='editor-post-publish-panel__header-publish-button']//button[@type='button'][contains(text(),'Publish')]")
    WebElement publish3;

    public AddNewPostPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void addAPost(String title, String description){
        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        driver.get(frameUrl);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        writeTitle.sendKeys(title);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        //Below does not work
        //writeDescription1.sendKeys(description);

        try{
            Thread.sleep(10000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        publish1.click();
        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        publish3.click();

        try{
            Thread.sleep(4000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        driver.navigate().back();
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        driver.navigate().back();

    }

}
