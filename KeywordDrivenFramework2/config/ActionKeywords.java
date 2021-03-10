package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import static executionEngine.DriverScript.OR;

public class ActionKeywords {

    public static WebDriver driver;

    public static void openBrowser(){
        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        driver = new FirefoxDriver();
    }

    public static void navigate(){
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.get(Constants.URL);
    }

    public static void inputUsername(String object){
        WebElement username = driver.findElement(By.id(OR.getProperty(object)));
        username.sendKeys(Constants.Username);
    }

    public static void inputPassword(String object){
        WebElement password = driver.findElement(By.id(OR.getProperty(object)));
        password.sendKeys(Constants.Password);
    }

    public static void clickOnLogin(String object){
        System.out.println(object);
        WebElement loginButton = driver.findElement(By.xpath(OR.getProperty(object)));
        loginButton.click();
    }

    public static void WaitFor(){
        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public static void clickOnLogout1(String object) {

        WebElement LogOutArrow = driver.findElement(By.xpath(OR.getProperty(object)));
        LogOutArrow.click();
    }

    public static void clickOnLogout2(String object){
        WebElement clickLogout = driver.findElement(By.xpath(OR.getProperty(object)));
        clickLogout.click();
    }

    public static void closeBrowser(){
        driver.quit();
    }
}
