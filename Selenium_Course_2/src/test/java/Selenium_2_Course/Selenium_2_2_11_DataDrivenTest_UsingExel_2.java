package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class Selenium_2_2_11_DataDrivenTest_UsingExel_2 {
    public static WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/v4/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(dataProvider = "loginTest")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("E0001")
    @Feature("Feature_1 Log_In")
    @Story("Validate Log-In functionality with valid/invalid inputs")
    @Step("Login validation")
    public void testLogin(String uName, String pas, String l) throws InterruptedException {
        driver.findElement(By.name("uid")).sendKeys(uName);
        driver.findElement(By.name("password")).sendKeys(pas);
        driver.findElement(By.name("btnLogin")).click();

        if (!isAlert()) {
            if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
                Assert.assertTrue(true);
                System.out.println("Test  is passed  " + l);
                driver.findElement(By.linkText("Log out")).click();
                driver.switchTo().alert().accept();
                driver.switchTo().defaultContent();
            }
        } else {
            System.out.println("Test  is fail  " + l);
            Assert.fail();
        }
    }

    @DataProvider(name = "loginTest")
    Object[][] data() throws IOException {
        FileInputStream file = new FileInputStream("D://LoginData2.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int namOfRow = sheet.getLastRowNum();
        int namOfCol = sheet.getRow(0).getLastCellNum();

        String[][] arr = new String[namOfRow][namOfCol];
        for (int i = 1; i <= namOfRow; i++) {
            for (int j = 0; j < namOfCol; j++) {
                arr[i - 1][j] = sheet.getRow(i).getCell(j).toString();//1 0 0
            }
        }
        file.close();
        return arr;
    }

    boolean isAlert() {
        try {
            driver.switchTo().alert().accept();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

