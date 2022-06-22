//import io.qameta.allure.Epic;
//import io.qameta.allure.Feature;
//import io.qameta.allure.Severity;
//import io.qameta.allure.SeverityLevel;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import pageObjects.HomePage;
//
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class LinkTest extends BaseClass {
//    @Test(dataProvider = "linkData", description = "Home Page link test")
//    @Severity(SeverityLevel.BLOCKER)
//    @Epic("LinksTest")
//    @Feature("LinkTest")
//    public void linkTest(String url) throws IOException {
//        if (url.isEmpty() || url == null) {
//            Assert.fail("This is empty link --->" + url);
//        }
//        else {
//            try {
//                URL Url = new URL(url);
//                HttpURLConnection connection = (HttpURLConnection) Url.openConnection();
//                connection.connect();
//                int cod = connection.getResponseCode();
//                if (cod >= 400) {
//                    Assert.fail("This is broken link: ---->" + url);
//                } else {
//                    Assert.assertTrue(true, "This is valid link: ---->" + url);
//                }
//            } catch (Exception e) {
//                Assert.fail("We have Exception on link: ----> " + url + " Exception is: ----> " + e);
//            }
//        }
//    }
//
//    @DataProvider(name = "linkData")
//    public Object[][] getData() {
//        int i = 0;
//        HomePage hp = new HomePage(driver);
//        int linkSize = hp.links.size();
//        System.out.println("Link are --->" + linkSize);
//        String[][] data = new String[linkSize][1];
//
//        for (WebElement link : hp.links) {
//            String url = link.getAttribute("href");
//            data[i][0] = url;
//            i++;
//        }
//        return data;
//    }
//}
//
//
