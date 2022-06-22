package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Selenium_2_2_26_Cookies {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.list.am/");
    }
    @Test(priority = 1, description = "Cookies get/add/delete", enabled = false)
    public void test_1(){
        Cookie myCookie = new Cookie("Gor add","123456");
        driver.manage().addCookie(myCookie);

        driver.manage().deleteCookie(myCookie);

        Set<Cookie> cookies =driver.manage().getCookies();
        int cookiesSize = driver.manage().getCookies().size();

        System.out.println("Cookies size is   " + cookiesSize);
        for (Cookie cookie: cookies){
            System.out.println(cookie.getName() + "   " + cookie.getValue());
        }
        System.out.println("Cookies size is   " + cookiesSize);
        driver.manage().deleteAllCookies();
        System.out.println("Cookies size is   " + cookiesSize);
        System.out.println();
    }

    @Test(description = "List main page Title Test")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Epic_1")
    @Feature("Title test")

    public void test2(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement armenian = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dlgLangSel\"]/div[3]/a[1]")));
        armenian.click();
        String title = driver.getTitle();
        if (title.contains("List.am - ")){
            Assert.assertTrue(true,"test is passed");
        }
        else{
            Assert.fail("Title test is not passed");
        }

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
