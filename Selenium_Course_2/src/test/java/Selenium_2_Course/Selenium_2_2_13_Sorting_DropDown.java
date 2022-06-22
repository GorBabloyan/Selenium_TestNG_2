package Selenium_2_Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Selenium_2_2_13_Sorting_DropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://fs3.formsite.com/6r2bHB/uuiil8lpym/index.html");

        WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"RESULT_RadioButton-9\"]"));
        Select allOptions = new Select(dropDown);
        List<WebElement> options = allOptions.getOptions();

        ArrayList<String> original = new ArrayList<String>();
        ArrayList<String> temp = new ArrayList<String>();

        for (WebElement option : options){
            original.add(option.getText());
            temp.add(option.getText());
        }
        //temp.add(1,"zzzz");
        System.out.println(temp);


        Collections.sort(temp);

        if (original.equals(temp)){
            System.out.println("List is SORTED");
        }
        else{
            System.out.println("List Not Sorted");
        }
    }
}
