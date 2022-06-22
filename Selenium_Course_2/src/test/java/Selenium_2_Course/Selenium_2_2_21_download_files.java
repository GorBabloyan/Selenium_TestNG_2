package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.time.Duration;

public class Selenium_2_2_21_download_files {
    public static void main(String[] args) throws InterruptedException {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text.plain, application/pdf"); //Mime type "text.plain, application/pdf" you can find mor by searching in google mine types
        profile.setPreference("browser.download.manager.showWhenStarting",false);
        profile.setPreference("pdfjs.disabled",true); //only for pdf files


        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options);
        driver.get("http://demo.automationtesting.in/FileDownload.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("textbox")).sendKeys("Hello Word");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"createTxt\"]")).click();
        driver.findElement(By.id("link-to-download")).click();
    }
}
