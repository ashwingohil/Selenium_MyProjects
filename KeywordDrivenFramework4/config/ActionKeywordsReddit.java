package config;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static ExecutionEngineReddit.DriverScriptReddit.OR;
public class ActionKeywordsReddit {

    public static WebDriver driver;
    public static String parentWindow = null;
    public static String childWindow = null;

    public static void OpenBrowser(){
        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        driver = new FirefoxDriver();
    }

    public static void NavigateURL(){
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.get(Constants_Reddit.URL);
    }

    public static void ClickLogin(String object){
        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
        WebElement loginButton = driver.findElement(By.cssSelector(OR.getProperty(object)));
        loginButton.click();
    }

    public static void SwitchToFrame(String object){
        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
        WebElement iframeElement = driver.findElement(By.cssSelector(OR.getProperty(object)));
        driver.switchTo().frame(iframeElement);
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public static void ClickOnContinueToGoogle(String object){
        try{
            Thread.sleep(2000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        By googlebutton = By.cssSelector(OR.getProperty(object));
        WebElement clickOnContinue = driver.findElement(googlebutton);
        JavascriptExecutor jexecute = (JavascriptExecutor)driver;
        jexecute.executeScript("arguments[0].click()",clickOnContinue);

        //THERE SHOULD HAVE BEEN ANOTHER METHOD

        try{
            Thread.sleep(2000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        int i=0;
        while(it.hasNext()){
            if(i==0) parentWindow = it.next();
            else childWindow = it.next();
            i++;
        }
        System.out.println("parentwindow:"+parentWindow);
        System.out.println("childwindow:"+childWindow);

        driver.switchTo().window(childWindow);
    }



    public static void EnterEmail(String object, String email){
        WebElement emailTextBox = driver.findElement(By.cssSelector(OR.getProperty(object)));
        emailTextBox.sendKeys(email);
    }

    public static void ClickOnNext1(String object){
        WebElement nextButton1 = driver.findElement(By.cssSelector(OR.getProperty(object)));
        nextButton1.click();
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public static void EnterPassword(String object, String password){
        WebElement passwordTextBox = driver.findElement(By.cssSelector(OR.getProperty(object)));
        passwordTextBox.sendKeys(password);
    }

    public static void ClickOnNext2(String object){
        WebElement nextButton2 = driver.findElement(By.cssSelector(OR.getProperty(object)));
        nextButton2.click();
    }


}
