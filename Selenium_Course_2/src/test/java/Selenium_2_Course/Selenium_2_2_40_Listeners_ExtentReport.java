package Selenium_2_Course;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium_2_2_40_Listeners_ExtentReport {
    @Test
    public void test1(){
        Assert.assertEquals("Gor","Gor");
        System.out.println("my test that need to pass");
    }

    @Test
    public void test2(){
        System.out.println("my test that need to be failed");
        Assert.assertEquals("Gor","Goo");
    }
}
