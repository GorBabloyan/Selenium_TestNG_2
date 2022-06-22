package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class Selenium_2_2_14_Handling_Browser_Windows {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Windows.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();

        Set<String> windows =driver.getWindowHandles();
        for (String window : windows){
            System.out.println(window);
            String title = driver.switchTo().window(window).getTitle();
            System.out.println(title);
//            if (title.equals("Frames & windows")){
//                driver.close();
//            }
        }




        //driver.quit();

    }
}
