package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;

import static java.lang.Thread.sleep;


public class Selenium_2_2_24_AutoIT_2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ilovepdf.com/pdf_to_word");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement uploadPDF = driver.findElement(By.id("pickfiles"));
        uploadPDF.click();
        //sleep(500);
        Runtime.getRuntime().exec("C://Users//user//Desktop//fileUploadAutoIT.exe");
        driver.findElement(By.id("processTaskTextBtn")).click();
        String title = driver.getTitle();
        if (title.equals("Download file | iLovePDF")) {
            driver.findElement(By.id("pickfiles")).click();
        }

    }
}
