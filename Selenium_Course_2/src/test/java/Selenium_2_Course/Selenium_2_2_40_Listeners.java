package Selenium_2_Course;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Selenium_2_2_40_Listeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Start");
    }
}
