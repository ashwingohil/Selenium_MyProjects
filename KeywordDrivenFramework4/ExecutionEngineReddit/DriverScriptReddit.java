package ExecutionEngineReddit;

import config.ActionKeywordsReddit;
import config.Constants_Reddit;
import org.testng.annotations.Test;
import utilityReddit.ExcelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DriverScriptReddit {

    public static Properties OR;
    public String PageObject;


    @Test(priority = 1)
    public void TestLogin() throws Exception{


        File file = new File(Constants_Reddit.FilePath_OR);
        FileInputStream istream = new FileInputStream(file);

        OR = new Properties(System.getProperties());
        OR.load(istream); //load requires inputStream so...  there is java io exception show mark method with exception

        String excelfilename = Constants_Reddit.FilePath_dataEngine;
        String sheetname = Constants_Reddit.Sheetname;
        ExcelUtils.setExcel(excelfilename,sheetname);

        for(int rowNo = 1; rowNo <= 9; rowNo++){
            PageObject = ExcelUtils.getCellValue(rowNo,Constants_Reddit.Col_PageObject);
            String actions = ExcelUtils.getCellValue(rowNo,Constants_Reddit.Col_ActionKeyword);


            if(actions.equals("OpenBrowser")){
                ActionKeywordsReddit.OpenBrowser();
            }
            else if(actions.equals("NavigateURL")){
                ActionKeywordsReddit.NavigateURL();
            }
            else if(actions.equals("ClickLogin")){
                ActionKeywordsReddit.ClickLogin(PageObject);
            }
            else if(actions.equals("SwitchToFrame")){
                ActionKeywordsReddit.SwitchToFrame(PageObject);
            }
            else if(actions.equals("ClickOnContinueToGoogle")){
                ActionKeywordsReddit.ClickOnContinueToGoogle(PageObject);
            }
            else if(actions.equals("EnterEmail")){
                String email = ExcelUtils.getCellValue(rowNo,Constants_Reddit.Col_Email);
                ActionKeywordsReddit.EnterEmail(PageObject,email);
            }else if(actions.equals("ClickOnNext1")){
                ActionKeywordsReddit.ClickOnNext1(PageObject);
            }else if(actions.equals("EnterPassword")){
                String password = ExcelUtils.getCellValue(rowNo,Constants_Reddit.Col_Password);
                ActionKeywordsReddit.EnterPassword(PageObject,password);
            }else if(actions.equals("ClickOnNext2")){
                ActionKeywordsReddit.ClickOnNext2(PageObject);
            }

        }
    }
}
