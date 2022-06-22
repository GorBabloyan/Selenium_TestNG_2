package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium_2_2_30_Encode_Decode_String {
    public static void main(String[] args) {
        String username = "Gor-123";

        byte[] encodeString = Base64.encodeBase64(username.getBytes());
        System.out.println("Encode value is:" + new String(encodeString)); //Encode value is: R29yLTEyMw==
        byte[] decodeString = Base64.decodeBase64(encodeString);
        System.out.println("Decode value is:" + new String(decodeString)); //Decode value is:Gor-123


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.nopcommerce.com/en");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions act = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript("document.getElementByClassName(user-actions-ico).click()");
        WebElement user = driver.findElement(By.xpath("//span[@class='user-actions-ico']"));
        act.moveToElement(user).perform();
        WebElement logIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"en-page\"]/body/div[7]/header/nav/ul/li[3]/ul/li[1]/a")));
        logIn.click();
        WebElement userName = driver.findElement(By.id("Username"));
        userName.sendKeys(decodingPassword("R29yLTEyMw=="));
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("admin");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log in']"));
        loginButton.click();
        String message = driver.findElement(By.xpath("//*[@class='message-error validation-summary-errors']")).getText();
        System.out.println(message);
    }
    static String decodingPassword(String password){
        byte[] decodeString = Base64.decodeBase64(password);
        return (new String(decodeString));
    }
}
