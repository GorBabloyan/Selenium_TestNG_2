package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Selenium_2_2_16_SwitchingAlerts {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Alert that have only OK button
        driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
        driver.switchTo().alert().accept();

        //Alert that have OK and Cancel button
        driver.findElement(By.linkText("Alert with OK & Cancel")).click();
        driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
        //driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        String text = driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText();
        System.out.println(text);

        //Alert that have Text_Box OK and Cancel
        driver.findElement(By.linkText("Alert with Textbox")).click();
        driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
        Alert window = driver.switchTo().alert();
        System.out.println(window.getText());
        window.sendKeys("Gor");
        window.accept();
        String text2 = driver.findElement(By.id("demo1")).getText();
        System.out.println(text2);







        //driver.quit();
    }
}
