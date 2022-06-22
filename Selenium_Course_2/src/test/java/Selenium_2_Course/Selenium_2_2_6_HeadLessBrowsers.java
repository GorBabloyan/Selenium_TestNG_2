package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Selenium_2_2_6_HeadLessBrowsers
{
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
        System.out.println("The page Title is: " + driver.getTitle());
        System.out.println("The page URL is: " + driver.getCurrentUrl());


        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options1 = new FirefoxOptions();
        options1.setHeadless(true);
        FirefoxDriver driver1 = new FirefoxDriver(options1);
        driver1.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
        System.out.println("The page Title is: " + driver.getTitle());
        System.out.println("The page URL is: " + driver.getCurrentUrl());

//        HtmlUnitDriver driver2 = new HtmlUnitDriver();
//        driver2.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
//        System.out.println("The page Title is: " + driver.getTitle());
//        System.out.println("The page URL is: " + driver.getCurrentUrl());


    }
}
