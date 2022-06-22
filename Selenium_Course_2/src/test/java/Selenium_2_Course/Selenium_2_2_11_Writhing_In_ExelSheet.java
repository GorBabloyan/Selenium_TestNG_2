package Selenium_2_Course;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Selenium_2_2_11_Writhing_In_ExelSheet {
    public static void main(String[] args) throws IOException {
        FileOutputStream file = new FileOutputStream("D:/LoginData10.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");
        int k=1;
        for(int i = 0; i<3; i++){
            XSSFRow row = sheet.createRow(i);
            for (int j = 0; j< 5; j++){
                row.createCell(j).setCellValue( k + ":   xyz");
                k++;
            }
        }
        workbook.write(file);
        workbook.close();
    }
}
