import org.junit.Assert;
import org.testng.annotations.BeforeSuite;

public class GmailLoginDriver extends TestBaseFacebook {

    @BeforeSuite
    public void init() throws Exception{
        GmailLoginDriver object = new GmailLoginDriver();
        object.initializeWebDriver("chrome");

        GmailLoginPage loginPage = new GmailLoginPage(driver);
        loginPage.setUsername("ashwin.k.gohil@gmail.com");
        loginPage.usernameNext();
        loginPage.setPassword("yourpassword");
        loginPage.passwordNext();
        GetInboxPage inboxPage = loginPage.getInbox();

        Assert.assertTrue(inboxPage.getGmailVisbility());
    }
}
