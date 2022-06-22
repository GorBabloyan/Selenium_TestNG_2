package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class SeleniumLogTest {
   public static Logger logger;
   public static WebDriver driver;


    @BeforeClass
    public void setup(){
        logger = Logger.getLogger("SeleniumLogTest.class");
        //BasicConfigurator.configure();
        PropertyConfigurator.configure("log4j.properties");
        //DOMConfigurator.configure("log4j.xml");

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        logger.info("ChromeDriver instance is created ");
        driver.get("https://restfulapi.net/http-status-codes/");
        logger.info("WebBrowser is opened");

    }

    @Test
    public void test1(){
        logger.info("test1 started");
        Assert.assertEquals("Gor","Gor");
    }
    @Test
    public void test2(){
        logger.info("test2 started");
        Assert.assertEquals("Gor","Goor");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        logger.info("WebBrowser closed");
    }
}
