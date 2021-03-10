

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;


    public void initializeWebDriver(String browserName) throws IOException {

        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/home/ashwin/IdeaProjects/Selenium-MyProjects/DEPENDENCIES/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "/home/ashwin/IdeaProjects/Selenium-MyProjects/DEPENDENCIES/geckodriver");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.gmail.com");
    }

    /*
    @AfterSuite
    public void quitDriver(){
        driver.quit();
    }
    */
}
