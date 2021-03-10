package executionEngine;

import config.Constants;

import utility.ExcelUtils;
import config.ActionKeywords;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/*
//This method from reflection class not working. method not being able to call
public class DriverScript{

    public  ActionKeywords actionKeywords;
    public  String actions;
    public  Method method[];
    Class cls;

    public DriverScript(){
        actionKeywords = new ActionKeywords();
        cls = actionKeywords.getClass();
        //method = actionKeywords.getClass().getMethods();
        method = cls.getMethods();
    }

    public  void execute_Actions() throws Exception{ //how this is written to write exception

        for(int i=0; i< method.length; i++){

            if(method[i].getName().equals(actions)){
                System.out.println("inside"+ method[i].getName());
                //method[i].invoke(actionKeywords);
                method[i].invoke(actionKeywords);
                break;
            }
        }
    }

    public void passToExecute() throws Exception{

        String pathToFile = "/home/ashwin/IdeaProjects/Selenium-MyProjects/KeywordDrivenFramework2/dataEngine/DataEngine.xlsx";
        ExcelUtils.setExcel(pathToFile,"TestSteps");

        for(int irow=1; irow <=8; irow++){
            actions = ExcelUtils.getCellData(irow,3);
            execute_Actions();
        }
    }

    public static void main(String[] args) throws Exception{

        DriverScript object  = new DriverScript();
        object.passToExecute();
    }
}
*/


//Draft2
public class DriverScript{

    public static Properties OR;
    public String sPageObject;

    public void TestLogin() throws Exception{

        String pathToFile = Constants.Path_TestData;
        ExcelUtils.setExcel(pathToFile,Constants.SheetName);

        String Path_OR = Constants.Path_OR;
        File file = new File(Path_OR);
        FileInputStream fs = new FileInputStream(file);

        OR = new Properties(System.getProperties());
        OR.load(fs);
        System.out.println("here");


        for(int irow = 1; irow <=9; irow++){

            sPageObject = ExcelUtils.getCellData(irow, Constants.Col_PageObject);
            String actions = ExcelUtils.getCellData(irow,Constants.Col_ActionKeyword);

                if (actions.equals("OpenBrowser")) {
                    ActionKeywords.openBrowser();
                } else if (actions.equals("Navigate")) {
                    ActionKeywords.navigate();
                } else if (actions.equals("InputUsername")) {
                    ActionKeywords.inputUsername(sPageObject);
                } else if (actions.equals("InputPassword")) {
                    ActionKeywords.inputPassword(sPageObject);
                } else if (actions.equals("ClickLogin")) {
                    ActionKeywords.clickOnLogin(sPageObject);
                } else if (actions.equals("WaitFor")) {
                    ActionKeywords.WaitFor();
                } else if (actions.equals("ClickLogout1")) {
                    ActionKeywords.clickOnLogout1(sPageObject);
                } else if (actions.equals("ClickLogout2")) {
                    ActionKeywords.clickOnLogout2(sPageObject);
                } else if (actions.equals("CloseBrowser")) {
                    ActionKeywords.closeBrowser();
                }
        }

    }

    public static void main(String[] args){

        DriverScript object = new DriverScript();
        try {
            object.TestLogin();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}




//original draft https://www.toolsqa.com Topic Keyword Driven Framwork
/*
public class DriverScript {

    WebDriver driver;

    public DriverScript(){
        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        driver = new FirefoxDriver();
    }

    public void TestLogin(){

        driver.get("https://www.facebook.com/");
        WebElement username = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("pass"));


        username.sendKeys("ashwin.k.gohil@gmail.com");
        password.sendKeys("nopassword16");

        WebElement loginButton = driver.findElement(By.name("login"));
        System.out.println(loginButton.getText());
        System.out.println("here");
        loginButton.click();

        try{
            Thread.sleep(2000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        WebElement LogOutArrow = driver.findElement(By.xpath("//i[@class='hu5pjgll lzf7d6o1 sp_lEy1gKUaRdz sx_2413cb']"));
        LogOutArrow.click();

        WebElement clickLogout = driver.findElement(By.xpath("//span[contains(text(),'Log Out')]"));
        clickLogout.click();
    }

    public static void main(String[] args){
        DriverScript object = new DriverScript();
        object.TestLogin();
    }
}
*/