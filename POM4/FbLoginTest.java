import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FbLoginTest extends FBTestBase{

    FbMainPage fbMainPageobject;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        DriverInitialization("firefox");
        fbMainPageobject = new FbMainPage(driver);

    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    @Test(groups = {"p1","pageloads"})
    public void loadPage(){
        driver.get(fbMainPageobject.pageURL); //i can call static by object also or classname
        Assert.assertEquals(driver.getCurrentUrl(),fbMainPageobject.pageURL);
    }

    @Test(groups = {"p2", "field"}, dependsOnMethods = "loadPage")
    public void fillEmailId(){
        fbMainPageobject.setupEmailField("ashwin.k.gohil@gmail.com");
    }

    @Test(groups = {"p2", "field"}, dependsOnMethods = "fillEmailId")
    public void fillPassword(){
        fbMainPageobject.setupPasswordField("yourpassword");
    }

    @Test(groups = {"p3", "clicksignin"}, dependsOnMethods = "fillPassword")
    public void clickLogin(){
        fbMainPageobject.clickLogin();
    }

}
