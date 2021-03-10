package FacebookOperation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class UIOperation_Facebook {

    WebDriver driver;

    public UIOperation_Facebook(){
        System.setProperty("webdriver.gecko.driver", "/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        this.driver = driver;
    }

    public void Perform(Properties p, String operation, String objectName, String objectType, String value){
        System.out.println(" ");
        switch(operation.toUpperCase()){
            case "CLICK":
                //Perform click
                driver.findElement(getObject(p, objectName, objectType)).click();
                break;
            case "SETTEXT":
                //set text on control
                driver.findElement(getObject(p, objectName, objectType)).sendKeys(value);
                break;
            case "GOTOURL":
                driver.get(p.getProperty(value));
                break;
            case "GETTEXT":
                driver.findElement(getObject(p, objectName, objectType)).getText();
                break;
            default:
                break;
        }
    }

    /**
     * Find element BY using object type and value
     * @param p
     * @param objectName
     * @param objectType
     * @return
     * @throws Exception
     */

    private By getObject(Properties p, String objectName, String objectType){

        //find by Xpath
        if(objectType.equalsIgnoreCase("XPATH")){
            return By.xpath(p.getProperty(objectName));
        }
        else if(objectType.equalsIgnoreCase("CLASSNAME")){
            return By.className(p.getProperty(objectName));
        }
        //find by name
        else if(objectType.equalsIgnoreCase("NAME")){
            System.out.println("ObjectName: "+p.getProperty(objectName));
            return By.name(p.getProperty(objectName));
        }
        //Find by css
        else if(objectType.equalsIgnoreCase("CSS")){
            return By.cssSelector(p.getProperty(objectName));
        }
        //find by link
        else if(objectType.equalsIgnoreCase("LINK")){
            return By.linkText(p.getProperty(objectName));
        }
        //find by partial link
        else if(objectType.equalsIgnoreCase("PARTIALLINK")){
            return By.partialLinkText(p.getProperty(objectName));
        }
        else if(objectType.equalsIgnoreCase("ID")){
            return By.id(p.getProperty(objectName));
        }


        return null;
    }
}
