import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ScratchDice {
    public static WebDriver driver;

    @Test
    public void Dice(){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        driver = new FirefoxDriver();

        driver.get("https://www.dice.com/");

        WebElement searchbox = driver.findElement(By.cssSelector("input.form-control.ng-tns-c31-0"));
        searchbox.sendKeys("selenium");

        try{
            Thread.sleep(8000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        WebElement selection = driver.findElement(By.cssSelector("div.typeahead-menu-container>div:first-of-type>div:nth-of-type(2)>button.dropdown-item>span>span.highlight"));
        selection.click();

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        WebElement searchButton = driver.findElement(By.cssSelector("button#submitSearch-button"));
        searchButton.click();

    }
}
