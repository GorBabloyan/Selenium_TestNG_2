package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Selenium_2_2_12_WebTable {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        int numOfRow = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr")).size();
        int numOfCell = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[2]/td")).size();

        System.out.println("rows are : " + numOfRow + "cells are : " + numOfCell);
        for (int i= 1; i<=numOfCell;i++){
            String headerText = driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[1]/th["+i+"]")).getText();
            System.out.print(" ---- " + headerText );
        }
        System.out.println("---------------------------------------");
        System.out.println();
        for (int i=2; i<=numOfRow; i++){
            for (int j=1; j<=numOfCell; j++){
                String tableText = driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.print(" ---- " + tableText );
            }
            System.out.println();
        }
    }
}
