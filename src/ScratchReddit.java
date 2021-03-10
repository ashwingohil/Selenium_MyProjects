import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ScratchReddit {

    public static WebDriver driver;

    @Test
    public void Reddit(){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        driver = new FirefoxDriver();

        driver.get("https://www.reddit.com/");


        WebElement login = driver.findElement(By.cssSelector("div._1JBkpB_FOZMZ7IPr3FyNfH>a:first-of-type"));
        login.click();


        WebElement iframe = driver.findElement(By.cssSelector("iframe._25r3t_lrPF3M6zD2YkWvZU"));
        driver.switchTo().frame(iframe);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }


        /*
        WebElement loginbutton = driver.findElement(By.cssSelector("button.AnimatedForm__submitButton"));
        WebDriverWait wait = new WebDriverWait(driver,50);
        WebElement elementlogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.AnimatedForm__submitButton")));
        elementlogin.submit();

         */


        try{
            Thread.sleep(2000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        /*
        WebElement continuegoogle = driver.findElement(By.cssSelector("div.Sso__button.Sso__googleIdButton"));
        continuegoogle.click();

         */

        By google = By.cssSelector("div.Sso__button.Sso__googleIdButton");
        WebElement continueGoogle = driver.findElement(google);
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click()",continueGoogle);


        try{
            Thread.sleep(2000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        String parentWindow = null;
        String childWindow = null;

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


        WebElement email = driver.findElement(By.cssSelector("input#identifierId"));
        email.sendKeys("ashwin.k.gohil@gmail.com");

        WebElement next1button = driver.findElement(By.cssSelector("div.VfPpkd-RLmnJb"));
        next1button.click();

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys("yourpassword");

        WebElement next2button = driver.findElement(By.cssSelector("div.VfPpkd-RLmnJb"));
        next2button.click();












    }
}
