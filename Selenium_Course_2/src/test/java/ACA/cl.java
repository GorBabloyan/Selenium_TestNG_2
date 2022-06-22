package ACA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.testng.AssertJUnit.assertEquals;

public class cl {
    @Test
    public void mainTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(100));
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//img[@class='replace-2x img-responsive']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        // Wait till the element becomes visible
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='button ajax_add_to_cart_button btn btn-default']")));
        webElement.click();// add to card

        WebElement webElement1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'Proceed to checkout')]")));
        webElement1.click();//proceed to check out

        WebElement webElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='button btn btn-default standard-checkout button-medium']")));
        webElement2.click(); // proceed to check out


        WebElement EmailButton = driver.findElement(By.id("email"));
        EmailButton.sendKeys("tumanyanlili3@gmail.com");

        WebElement webElement4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwd")));
        webElement4.sendKeys("asl123");


        WebElement webElement5 = wait.until(ExpectedConditions.elementToBeClickable(By.id("SubmitLogin")));
        webElement5.click();

        String actualResult = driver.findElement(By.xpath("//*[text() = 'Authentication failed.']")).getText();
        String expectedResult = "Authentication failed.";
        assertEquals(actualResult, expectedResult);
        driver.close();
    }
}
