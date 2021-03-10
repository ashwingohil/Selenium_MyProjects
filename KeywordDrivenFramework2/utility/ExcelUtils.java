package utility;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {

    private static XSSFWorkbook Workbook;
    private static XSSFSheet sheet;
    private static XSSFCell cell;

    public static void setExcel(String pathToFile, String sheetname){
        try {
            File file = new File(pathToFile);
            FileInputStream istream = new FileInputStream(file);
            Workbook = new XSSFWorkbook(istream);
            sheet = Workbook.getSheet(sheetname);

        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }


    public static String getCellData(int rowNum, int cellNum){

        cell = sheet.getRow(rowNum).getCell(cellNum);
        String celldata = cell.getStringCellValue();
        return celldata;
    }

}
