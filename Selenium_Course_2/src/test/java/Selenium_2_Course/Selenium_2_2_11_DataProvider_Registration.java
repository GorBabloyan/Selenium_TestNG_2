package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class Selenium_2_2_11_DataProvider_Registration {
    WebDriver driver;
    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    void setMetod(){
        driver.get("https://blazedemo.com/register");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test(dataProvider = "reg")
    void testRegistration(String name, String company, String email, String password){
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("company")).sendKeys(company);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password-confirm")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/form/div[6]/div/button")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title,"Page Expired");
            //Assert.assertEquals(title,"BlazeDemo");
    }
    @DataProvider(name = "reg")
    Object[][] data () throws IOException {
        FileInputStream file = new FileInputStream("D:/LoginData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("sheet2");
        int numOfRow = sheet.getLastRowNum();
        int numOfCell = sheet.getRow(0).getLastCellNum();

        String arr[][] = new String[numOfRow][numOfCell];
        for (int i=1; i<=numOfRow; i++){
            for (int j=0; j<numOfCell; j++){
                arr[i-1][j]=sheet.getRow(i).getCell(j).toString();
            }
        }
        file.close();
        return arr;
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
