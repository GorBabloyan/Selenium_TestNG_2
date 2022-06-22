package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Selenium_2_2_22_RobotClass {
    public static void main(String[] args) throws AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://pdf-reader.en.softonic.com/download");
        driver.manage().window().maximize();
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ACCEPT);
        r.keyRelease(KeyEvent.VK_ACCEPT);
        r.keyPress(KeyEvent.VK_TAB);


        driver.findElement(By.xpath("//a[contains(@class,'s-button-app')]")).click();



    }
}
