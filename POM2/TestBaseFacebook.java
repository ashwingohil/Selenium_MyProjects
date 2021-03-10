import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBaseFacebook {

    public static WebDriver driver;

    public void initializeWebDriver(String browsername) throws IOException {

        if(browsername.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","/home/ashwin/IdeaProjects/Selenium-MyProjects/DEPENDENCIES/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browsername.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","/home/ashwin/IdeaProjects/Selenium-MyProjects/DEPENDENCIES/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
    }


    public void quitDriver(){
        driver.quit();
    }
}
