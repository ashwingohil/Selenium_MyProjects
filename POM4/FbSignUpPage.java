import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FbSignUpPage {

    WebDriver driver;

    @FindBy(how = How.CSS, css = "input[name='firstname']")
    WebElement FirstName;

    @FindBy(how = How.CSS, css = "input[name='lastname']")
    WebElement Surname;

    @FindBy(how = How.CSS, css = "input[name='reg_email__']")
    WebElement EmailAddress;

    @FindBy(how = How.CSS, css = "input[name='reg_email_confirmation__']")
    WebElement ReEnterEmailAddress;


    @FindBy(how = How.CSS, css = "input[name='reg_passwd__']")
    WebElement Password;

    @FindBy(how = How.CSS, css = "input[name='sex'][value='1']")
    WebElement FemaleRadioButton;

    @FindBy(how = How.CSS, css = "input[name='sex'][value='2']")
    WebElement MaleRadioButton;

    @FindBy(how = How.CSS, css = "select#day")
    WebElement dropdownDay;

    @FindBy(how = How.CSS, css = "select#month")
    WebElement dropdownMonth;

    @FindBy(how = How.CSS, css = "select#year")
    WebElement dropdownYear;





    public FbSignUpPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void SleepTime(Long time){
        try{
            Thread.sleep(time);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public void fillFirstName(String text){
        SleepTime(3000L);
        FirstName.sendKeys(text);
        Assert.assertEquals(FirstName.getAttribute("value"),text);
    }

    public void fillSurname(String text){
        Surname.sendKeys(text);
        Assert.assertEquals(Surname.getAttribute("value"),text);
    }

    public void fillEmailAddress(String text){
        EmailAddress.sendKeys(text);
        Assert.assertEquals(EmailAddress.getAttribute("value"),text);
    }

    public void setEnterEmailAddress(String text){
        SleepTime(4000L);
        ReEnterEmailAddress.sendKeys(text);
        Assert.assertEquals(ReEnterEmailAddress.getAttribute("value"),text);
    }


    public void fillPassword(String text){
        Password.sendKeys(text);
        Assert.assertEquals(Password.getAttribute("value"),text);
    }

    public void selectGender(String text){

        if(text.equalsIgnoreCase("male")){
            MaleRadioButton.click();
        }
        else if(text.equalsIgnoreCase("female")){
            FemaleRadioButton.click();
        }
        if(text.equalsIgnoreCase("male")) {
            Assert.assertEquals(MaleRadioButton.getAttribute("value"), "2");
        }
        else if(text.equalsIgnoreCase("female")){
            Assert.assertEquals(FemaleRadioButton.getAttribute("value"),"1");
        }
    }


    public void selectDay(String value){
        Select select = new Select(dropdownDay);
        select.selectByValue(value);

    }

    public void selectMonth(String value){
        Select select = new Select(dropdownMonth);
        select.selectByValue(value);
    }

    public void selectYear(String value){
        Select select = new Select(dropdownYear);
        select.selectByValue(value);
    }




}
