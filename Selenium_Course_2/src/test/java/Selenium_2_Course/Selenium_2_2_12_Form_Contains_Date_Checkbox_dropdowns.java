package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Selenium_2_2_12_Form_Contains_Date_Checkbox_dropdowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://fs3.formsite.com/6r2bHB/uuiil8lpym/index.html"); //Travel 1 My_Formm
        Thread.sleep(3000);
        // driver.get("https://fs3.formsite.com/6r2bHB/oxdt9xzu1u/index.html"); //Travel 2 My_Formm
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.findElement(By.name("RESULT_TextField-1")).sendKeys("Henrick");
        driver.findElement(By.name("RESULT_TextField-2")).sendKeys("hero@maiil.ru");
        driver.findElement(By.name("RESULT_TextField-3")).sendKeys("+37410551021");

        List<WebElement> listChoice = driver.findElements(By.xpath("//*[@id=\"q4\"]/table/tbody/tr"));
        for (WebElement choice : listChoice) {
            if (choice.getText().equals("Text")) {
                choice.click();
                break;
            }
        }

        driver.findElement(By.xpath("//*[@id=\"q14\"]/span")).click();
        String month = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span")).getText();
        while (!month.equals("November")) {
            driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
            month = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span")).getText();
        }

        WebElement allCategories = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select"));
        Select categories = new Select(allCategories);
        List<WebElement> elements = categories.getOptions();
        for (WebElement element : elements) {
            if (element.getText().equals("1991")) {
                element.click();
                break;
            }
        }
        ////*[@id="ui-datepicker-div"]/table/tbody/tr[5]/td[2]
        int rowNum = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr")).size();
        int collNum = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td")).size();
        System.out.println(rowNum + "   " + collNum);
        List<WebElement> days = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a"));
        for (WebElement day : days) {
            if (day.getText().equals("29")) {
                day.click();
                break;
            }
        }

        driver.findElement(By.name("RESULT_TextField-6")).sendKeys("Armenia");
        driver.findElement(By.name("RESULT_TextField-7")).sendKeys("Yerevan argishti 17/7");
        driver.findElement(By.name("RESULT_TextField-8")).sendKeys("USA");

        WebElement drop_2 = driver.findElement(By.xpath("//*[@id=\"RESULT_RadioButton-9\"]"));
        Select drop = new Select(drop_2);
        drop.selectByVisibleText("California");
//        List<WebElement> allOptions = drop.getOptions();
//        for (WebElement option : allOptions) {
//            if (option.getText().equals("California")) {
//                option.click();
//                break;
//            }
//        }
        driver.findElement(By.name("RESULT_TextField-10")).sendKeys("0075");

        List<WebElement> needs = driver.findElements(By.xpath("//*[@id=\"q17\"]/table/tbody/tr/td/label"));
        for (WebElement need : needs) {
            if (need.getText().equals("Economy car") || need.getText().equals("Pet friendly") || need.getText().equals("Multiple beds")) {
                need.click();
            }
        }
        //driver.findElement(By.xpath("//*[@id=\"RESULT_FileUpload-12\"]")).click();

        //Thank you!


    }
}
