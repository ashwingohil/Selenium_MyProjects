import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WordPressLoginPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Continue with Google')]")
    WebElement ContinueWithGoogle;

    @FindBy(how = How.XPATH, xpath = "//*[@id=\"identifierId\"]")
    WebElement email;

    @FindBy(how = How.CLASS_NAME, className =  "VfPpkd-RLmnJb")
    WebElement next;

    @FindBy(how = How.XPATH, xpath = "//input[@type='password']")
    WebElement password;

    @FindBy(how = How.XPATH, xpath = "//div[@id='passwordNext']//div[@class='VfPpkd-dgl2Hf-ppHlrf-sM5MNb']//button[@type='button']//div[@class='VfPpkd-RLmnJb']")
    WebElement next2;

    String parentWindow = null;
    String childWindow = null;


    public WordPressLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void waitForContinueWithEmail(){

        try{
            Thread.sleep(10000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

    }

    public void clickContinueWithGoogle(){
        ContinueWithGoogle.click();
    }

    public void switchToPopUp(){

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        for(String h : handles){
            System.out.println("Handle: "+h);
        }
        int i=0;
        while(it.hasNext()){
            if(i == 0) {
                parentWindow = it.next();
            }
            childWindow = it.next();
            i++;
        }

        System.out.println(parentWindow);
        System.out.println(childWindow);
        driver.switchTo().window(childWindow);
    }

    public void setUsername(String username){
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        email.sendKeys(username);
    }

    public void clickNext(){
        next.click();
    }

    public void setPassword(String password){

        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        this.password.sendKeys(password);
    }

    public void clickNext2(){
        next2.click();
    }

    public WordPressUserPage getUserPage(){
        try{
            Thread.sleep(10000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        driver.switchTo().window(parentWindow);
        return new WordPressUserPage(driver);
    }


}
