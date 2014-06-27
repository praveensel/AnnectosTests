package trash;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class sri {

    WebDriver driver;
    String baseUrl = "172.31.5.22:8080";


    @Test
    public void lanuchBrowser() throws InterruptedException {

        driver = new FirefoxDriver();
        driver.get(baseUrl + "/login/login.html#/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }


}