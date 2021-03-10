
package WordPressExecutionEngine;

//first import all the necessary classes;

import config.ConstantsWordPress;
import config.ActionKeywordsWordPress;
import org.testng.annotations.Test;
import utilityWordPress.ExcelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class WordPressDriverScript {

    public static Properties OR;
    public String PageObject;

    @Test(priority = 1)
    public void TestLogin() throws Exception{

        String filepath = ConstantsWordPress.Path_TestData;
        String sheetname = ConstantsWordPress.SheetName;
        ExcelUtils.setExcel(filepath,sheetname);

        String pathOR = ConstantsWordPress.Path_OR;
        File file = new File(pathOR);
        FileInputStream istream = new FileInputStream(file);   //this throws filenotfound exception so need exception in method

        OR = new Properties(System.getProperties());
        OR.load(istream);


        for(int irow = 1; irow <=9; irow++){
            PageObject = ExcelUtils.getCellData(irow, ConstantsWordPress.Col_PageObject);
            String actions = ExcelUtils.getCellData(irow,ConstantsWordPress.Col_ActionKeyword);

            if(actions.equals("OpenBrowser")){
                ActionKeywordsWordPress.OpenBrowser();
            }else if(actions.equals("NavigateToURL")){
                ActionKeywordsWordPress.NavigateToURL();
            }else if(actions.equals("OpenLoginLink")){
                ActionKeywordsWordPress.OpenLoginLink(PageObject);
            }else if(actions.equals("ClickContinueButton")){
                ActionKeywordsWordPress.ClickContinueButton(PageObject);
            }else if(actions.equals("SwitchToPopUpWindow")){
                ActionKeywordsWordPress.SwitchToPopUpWindow();
            }else if(actions.equals("EnterEmail")){
                ActionKeywordsWordPress.EnterEmail(PageObject);
            }else if(actions.equals("ClickNextButton1")){
                ActionKeywordsWordPress.ClickNextButton1(PageObject);
            }else if(actions.equals("EnterPassword")){
                ActionKeywordsWordPress.EnterPassword(PageObject);
            }else if(actions.equals("ClickNextButton2")){
                ActionKeywordsWordPress.ClickNextButton2(PageObject);
            }

        }


    }

}
