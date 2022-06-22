package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.time.Duration;

public class Selenium_2_2_20_Sikuli_Upload_Download_files {
    public static void main(String[] args) throws InterruptedException, FindFailed {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

//        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//        driver.findElement(By.name("Submit")).click();

        driver.findElement(By.xpath("//*[@id=\"imagesrc\"]")).click();

        Screen s =new Screen();

        Pattern fileInputTextBox = new Pattern("D:\\Sikuli\\textBox.png");
        Pattern open = new Pattern("D:\\Sikuli\\cancel.png");

        s.wait(fileInputTextBox,20);
        s.type(fileInputTextBox,"C:\\Users\\user\\Desktop\\Selenium_Screenshots\\Gor_CV_EN.pdf");
        s.wait(open,5);
        s.click(open);



    }
}
