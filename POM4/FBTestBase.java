import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FBTestBase {

    public static WebDriver driver;

    public void DriverInitialization(String browsername){
        if(browsername.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","/home/ashwin/IdeaProjects/Selenium-MyProjects/DEPENDENCIES/geckodriver");
            driver = new FirefoxDriver();
        }
        else if(browsername.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","/home/ashwin/IdeaProjects/Selenium-MyProjects/DEPENDENCIES/chromedriver");
            driver = new ChromeDriver();
        }
    }

}
