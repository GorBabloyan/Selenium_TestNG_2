package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Selenium_2_2_18_Broken_links {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.deadlinkcity.com/");
        //driver.get("http://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        List<WebElement> links = driver.findElements(By.tagName("a"));
        int size = links.size();
        System.out.println("links ara: " +size);

        for (WebElement link :links){
            String url = link.getAttribute("href");
            System.out.println(url);
            if (url==null||url.isEmpty()){
                System.out.println(link.getText() + "  Empty list");
            }
            try {
            URL linki = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)linki.openConnection();
            connection.connect();
            int cod = connection.getResponseCode();


            if (cod>400){
                System.out.println(url + " Broken link " + cod);
            }
            else {
                System.out.println(url + " Not Broken link " + cod);
            }
        }
            catch (Exception e){
                System.out.println(e);
            }
        }

    }
}
