package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Selenium_2_2_31_2_AshotAPI_DifferScreenshots {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.opencart.com/");
        driver.manage().window().maximize();

        BufferedImage expectedImage = ImageIO.read(new File("C://Users//user//Desktop//MySQL//logo1.png"));

        WebElement logo = driver.findElement(By.xpath("//img[@title='OpenCart - Open Source Shopping Cart Solution']"));
        Screenshot logoScreenshot = new AShot().takeScreenshot(driver,logo);
      //  ImageIO.write(logoScreenshot.getImage(),"png", new File("C://Users//user//Desktop//MySQL//logo2.png"));

        BufferedImage actualImage = logoScreenshot.getImage();
        //ImageIO.write(actualImage,"png",new File("C://Users//user//Desktop//MySQL//logo2.png"));

        ImageDiffer imageDiffer = new ImageDiffer();
        ImageDiff diff = imageDiffer.makeDiff(expectedImage,actualImage);

        if (diff.hasDiff()){
            System.out.println("Images are different");
        }
        else{
            System.out.println("Images are same");
        }





        driver.quit();
    }
}
