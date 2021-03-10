package config;

import config.ConstantsWordPress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static WordPressExecutionEngine.WordPressDriverScript.OR; //this is important

public class ActionKeywordsWordPress {


    public static WebDriver driver;
    public static String parentWindow = null;
    public static String childWindow = null;

    //all static classes as these methods need to be called else i will have to create object

    public static void OpenBrowser(){
        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        driver = new FirefoxDriver();
    }

    public static void NavigateToURL(){
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.get(ConstantsWordPress.URL);
    }

    public static void OpenLoginLink(String object){
        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
        WebElement LoginLink = driver.findElement(By.cssSelector(OR.getProperty(object))); //name is chosen from pageObject column
        LoginLink.click();
    }

    public static void ClickContinueButton(String object){
      //driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
      WebElement ContinueButton = driver.findElement(By.cssSelector(OR.getProperty(object)));
      ContinueButton.click();
    }

    public static void SwitchToPopUpWindow(){
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

    public static void EnterEmail(String object){
        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
        WebElement textBox_email = driver.findElement(By.cssSelector(OR.getProperty(object)));
        textBox_email.sendKeys(ConstantsWordPress.Email);
    }

    //you can have one more column which state type of locator so I can tally here
    public static void ClickNextButton1(String object){
        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
        WebElement NextButton1 = driver.findElement(By.cssSelector(OR.getProperty(object)));
        NextButton1.click();
    }

    public static void EnterPassword(String object){
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        WebElement textBox_password = driver.findElement(By.cssSelector(OR.getProperty(object)));
        textBox_password.sendKeys(ConstantsWordPress.Password);
    }

    public static void ClickNextButton2(String object){
        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
        WebElement NextButton2 = driver.findElement(By.cssSelector(OR.getProperty(object)));
        NextButton2.click();
    }


}
