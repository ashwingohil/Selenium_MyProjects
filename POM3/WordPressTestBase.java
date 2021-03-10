import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WordPressTestBase {

    public static WebDriver driver;

    public void InitializeDriver(String browsername){

        if(browsername.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","/home/ashwin/IdeaProjects/Selenium-MyProjects/DEPENDENCIES/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browsername.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","/home/ashwin/IdeaProjects/Selenium-MyProjects/DEPENDENCIES/geckodriver");
            driver = new FirefoxDriver();
        }


        driver.get("https://wordpress.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.manage().window().maximize();

    }

    public void DriverQuit(){
        driver.quit();
    }
}
