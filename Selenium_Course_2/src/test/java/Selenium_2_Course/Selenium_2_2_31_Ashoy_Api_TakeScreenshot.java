package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Selenium_2_2_31_Ashoy_Api_TakeScreenshot {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement logo = driver.findElement(By.xpath("//img[@class='nav-logo']"));

        Screenshot logoScreenshot = new AShot().takeScreenshot(driver,logo);
        ImageIO.write(logoScreenshot.getImage(),"png", new File("C://Users/user/Desktop/MySQL/logo.png"));
        File f = new File("C://Users/user/Desktop/MySQL/logo.png");


//        File src = logo.getScreenshotAs(OutputType.FILE);
//        File target = new File("C://Users/user/Desktop/MySQL/logo2.png");
//        FileUtils.copyFile(src,target);

//        FileUtils.copyFile(logo.getScreenshotAs(OutputType.FILE), new File("C://Users/user/Desktop/MySQL/logo2.png"));



        if (f.exists()){
            System.out.println("File exist");
        }
        else{
            System.out.println("File Not exist");
        }
        driver.quit();
    }
}
