package utilityReddit;

import config.Constants_Reddit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {

    public static XSSFWorkbook WorkBook;
    public static XSSFSheet Sheet;
    public static XSSFCell Cell;

    //https://docs.oracle.com/javase/7/docs/api/java/io/File.html
    //https://poi.apache.org/apidocs/dev/org/apache/poi/xssf/usermodel/XSSFWorkbook.html [from here methods are used]
    //https://poi.apache.org/apidocs/dev/org/apache/poi/xssf/usermodel/XSSFCell.html [getStringCellValue]

    public static void setExcel(String filepath, String sheetname){

        try {
            File file = new File(Constants_Reddit.FilePath_dataEngine);
            FileInputStream istream = new FileInputStream(file);
            WorkBook = new XSSFWorkbook(istream);
            Sheet = WorkBook.getSheet(Constants_Reddit.Sheetname);

        }catch(IOException ex){
            ex.printStackTrace();
        }

        //file not found exception if i had used then ioexception would be required as it is bigger class. This one contains
        //file not found exception anyways

    }


    public static String getCellValue(int rowNo, int cellNo){
        Cell = Sheet.getRow(rowNo).getCell(cellNo);
        String cellvalue = Cell.getStringCellValue();
        return cellvalue;
    }
}
