package Selenium_2_Course.utest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Link_Test {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.xoom.com/armenia/send-money");
        driver.manage().window().maximize();
    }


    @Test
    public void linkTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int size = links.size();
        System.out.println("links ara------------------------->: " +size);

        for (WebElement link:links){
            String url = link.getAttribute("href");
            System.out.println(url);
            if (url==null||url.isEmpty()){
                System.out.println(link.getText() + "  <------------------------Empty link");
            }
            try {
                URL linki = new URL(url);
                HttpURLConnection connection = (HttpURLConnection)linki.openConnection();
                connection.connect();
                int cod = connection.getResponseCode();

                if (cod>=400){
                    System.out.println(url + " <---------------------------Broken link " + cod);
                }
                else {
                    System.out.println(url + " Not Broken link--------------------------> " + cod);
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

    }





    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
