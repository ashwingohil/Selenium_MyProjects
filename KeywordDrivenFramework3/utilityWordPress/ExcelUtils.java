package utilityWordPress;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {

    //https://docs.oracle.com/javase/7/docs/api/java/io/FileInputStream.html
    //https://poi.apache.org/apidocs/dev/org/apache/poi/xssf/usermodel/XSSFWorkbook.html
    //https://poi.apache.org/apidocs/dev/org/apache/poi/xssf/usermodel/XSSFCell.html

    public static XSSFWorkbook Workbook;
    public static XSSFSheet Sheet;
    public static XSSFCell Cell;

    //it should be static as i have to call these methods. else i will need an object for it
    public static void setExcel(String filepath, String sheetname){

        try {
            File file = new File(filepath);
            FileInputStream istream = new FileInputStream(file);

            Workbook = new XSSFWorkbook(istream);
            Sheet = Workbook.getSheet(sheetname);

        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static String getCellData(int rowNo, int cellNo){
        Cell = Sheet.getRow(rowNo).getCell(cellNo);
        String cellData = Cell.getStringCellValue();
        return cellData;
    }


}
