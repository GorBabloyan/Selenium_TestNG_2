package Selenium_2_Course;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Selenium_2_2_10_DataDrivenTest_UsingExel_1 {
    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream("D://Exel_2_2_10.xlsx");
        XSSFWorkbook workBook = new XSSFWorkbook(file);
        XSSFSheet sheet = workBook.getSheetAt(0);
        int lastRow = sheet.getLastRowNum();
        int lastCell = sheet.getRow(0).getLastCellNum();
        System.out.println("cells = :" + lastCell + "  rows = :" + lastRow);

        for (int i=1; i<=lastRow; i++){
            XSSFRow row = sheet.getRow(i);
            for (int j=0; j<lastCell; j++){
                System.out.print(" "+row.getCell(j).toString());
            }
            System.out.println();
        }

    }
}
