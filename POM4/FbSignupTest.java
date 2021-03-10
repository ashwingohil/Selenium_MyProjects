import executionEngine.DriverScript;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class FbSignupTest extends FBTestBase{

    public FbMainPage fbMainPageObject;
    public FbSignUpPage fbSignUpPageObject;

    public String parentWindow;
    public String childWindow;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        DriverInitialization("firefox");
        fbMainPageObject = new FbMainPage(driver);
        fbSignUpPageObject = new FbSignUpPage(driver);
    }

    @Test(groups = {"p1","pageloads"})
    public void loadpage(){
        driver.get(fbMainPageObject.pageURL);
        Assert.assertEquals(driver.getCurrentUrl(),fbMainPageObject.pageURL);
    }

    @Test(groups = {"p1","pageloads"}, dependsOnMethods = "loadpage")
    public void clickCreateAccount(){
        fbMainPageObject.clickCreateAccount();
    }

    @Test(groups = {"p2", "switchwindow"}, dependsOnMethods = "clickCreateAccount")
    public void switchToSignupPage(){
        Set<String> handles = driver.getWindowHandles();

        Iterator<String> iterator = handles.iterator();
        int i=0;
        while(iterator.hasNext()){
            if(i==0) {
                parentWindow = iterator.next();
            }
            else childWindow = iterator.next();
            i++;
        }

        System.out.println("Parent window: "+parentWindow);
        System.out.println("Child window: "+childWindow);

        //if(!childWindow.equals(null)) driver.switchTo().window(childWindow);
    }



    @Test(groups = {"p3", "field"}, dependsOnMethods = "switchToSignupPage")
    public void fillFirstName(){
        fbSignUpPageObject = new FbSignUpPage(driver);
        fbSignUpPageObject.fillFirstName("Ashwin");
    }

    @Test(groups = {"p3", "field"}, dependsOnMethods = "fillFirstName")
    public void fillSurname(){
        fbSignUpPageObject.fillSurname("Gohil");
    }

    @Test(groups = {"p3", "field"}, dependsOnMethods = "fillSurname")
    public void fillEmailAddress(){
        fbSignUpPageObject.fillEmailAddress("ashwin.k.gohil@gmail.com");
    }

    @Test(groups = {"p3", "field"}, dependsOnMethods = "fillEmailAddress")
    public void reEnterEmailAddress(){
        fbSignUpPageObject.setEnterEmailAddress("ashwin.k.gohil@gmail.com");
    }

    @Test(groups = {"p3", "field"}, dependsOnMethods = "fillEmailAddress")
    public void fillPassword(){
        fbSignUpPageObject.fillPassword("helloworld");
    }

    @Test(groups = {"p3", "field"}, dependsOnMethods = "fillPassword")
    public void selectGender(){
        fbSignUpPageObject.selectGender("male");
    }

    @Test(groups = {"p4", "select"}, dependsOnMethods = "selectGender")
    public void selectDay(){
        fbSignUpPageObject.selectDay("12");
    }

    @Test(groups = {"p4", "select"}, dependsOnMethods = "selectDay")
    public void selectMonth(){
        fbSignUpPageObject.selectMonth("9");
    }

    @Test(groups = {"p4", "select"}, dependsOnMethods = "selectMonth")
    public void selectYear(){
        fbSignUpPageObject.selectYear("1980");
    }

}
