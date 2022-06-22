package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Selenium_2_2_17_Action_Class {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/#Photo%20Manager");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        Actions action = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"post-2669\"]/div[2]/div/div/div[1]/p/iframe")));
        WebElement el1 = driver.findElement(By.xpath("//*[@id=\"gallery\"]/li[1]/img"));
        WebElement el2 = driver.findElement(By.xpath("//*[@id=\"gallery\"]/li[2]/img"));
        WebElement el3 = driver.findElement(By.xpath("//*[@id=\"gallery\"]/li[3]/img"));
        WebElement definition = driver.findElement(By.id("trash"));

        action.dragAndDrop(el1, definition).perform();
        action.dragAndDrop(el2, definition).perform();
        action.clickAndHold(el3).moveToElement(definition).release().build().perform();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id=\"menu-item-1513\"]/a")).click();

//        action.moveToElement(el2).build().perform();
//        action.moveToElement(el3).build().perform();
//        action.moveToElement(definition).build().perform();


//        action.moveToElement(driver.findElement(By.xpath(""))).perform();
//        action.clickAndHold();
//        action.contextClick();

    }
}
