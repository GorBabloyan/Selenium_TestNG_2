package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class Selenium_2_2_23_AutoIT_1 {
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://fs3.formsite.com/6r2bHB/uuiil8lpym/index.html");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(200));
        WebElement upload = driver.findElement(By.xpath("//*[@id=\"q16\"]/label"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",upload);
        upload.click();
        Thread.sleep(500);
        Runtime.getRuntime().exec("C://Users//user//Desktop//fileUploadAutoIT.exe");

    }
}
