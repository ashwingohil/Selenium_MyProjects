package FacebookTestCases;

import FacebookExcelExport.ReadExcelFile_Facebook;
import FacebookOperation.ReadObject_Facebook;
import FacebookOperation.UIOperation_Facebook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;

import java.util.Properties;

public class ExecuteTest_Facebook {


    @Test
    public void TestLogin(){

        ReadExcelFile_Facebook file = new ReadExcelFile_Facebook();
        ReadObject_Facebook object = new ReadObject_Facebook();
        Properties allObjects = object.getRepository();
        UIOperation_Facebook operation = new UIOperation_Facebook();

        Sheet sheet = file.readExcel(System.getProperty("user.dir")+"/KeywordDrivenFramework1/", "TestCase-Facebook.xlsx", "FacebookSheet");
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        for(int i=0; i < rowCount + 1; i++){
            Row row = sheet.getRow(i);
            if(row.getCell(0).toString().length() == 0){
                System.out.println(row.getCell(1).toString()+"----"+ row.getCell(2).toString()+"----"+
                        row.getCell(3).toString()+"----"+ row.getCell(4).toString());

                operation.Perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(),
                        row.getCell(3).toString(), row.getCell(4).toString());
            }
            else{
                //Print the new testcase name when it started
                System.out.println("New Testcase->"+row.getCell(0).toString() +" Started");
            }
        }
    }
}

//It is necessary to creat testNG xml as we are using testNG annotations.Test. Click on topmost direction on left pane
//and right click and create testng xml. Add all the classes in this keywordDrivenFramework1
//Goto code menu and reformat the code
//There is notes in selenium Concepts 1 on testng