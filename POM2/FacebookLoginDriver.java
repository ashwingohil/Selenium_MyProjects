import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FacebookLoginDriver extends TestBaseFacebook{

    @Test(priority = 0)
    public void init() throws Exception{
        FacebookLoginDriver object = new FacebookLoginDriver();
        object.initializeWebDriver("chrome");
        FacebookLoginPage loginPage = new FacebookLoginPage(driver);
        loginPage.setUsername("ashwin.k.gohil@gmail.com");
        loginPage.setPassword("yourpassword");
        loginPage.clickLogin();
        FacebookUserPage userPage = loginPage.getFacebookUserPage();
    }
}
