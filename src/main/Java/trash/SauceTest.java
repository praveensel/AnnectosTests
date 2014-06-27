package trash;


import io.appium.java_client.AppiumDriver;
import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class SauceTest  {

    private SelendroidDriver driver;

    private List<Integer> values;

    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 10;

    private String sessionId;



    @BeforeClass
    public void setUp() throws Exception {
        String sauceUserName = "praveenk82";
        String sauceAccessKey = "3fb2157e-53e3-4c5d-8cf1-0b8131a08d74";
        //AppiumDriver wait = new AppiumDriver();
        DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability("platform", "Linux");
       capabilities.setCapability("version", "4.3");
        capabilities.setCapability(SelendroidCapabilities.EMULATOR, true);
     // capabilities.setCapability("deviceName", "AVD_for_Nexus_4");
      //capabilities.setCapability("device-orientation", "portrait");
        //capabilities.setCapability("emulator","false");
      //  capabilities.setCapability("app", "http://appium.s3.amazonaws.com/TestApp6.0.app.zip");
     //driver = new SelendroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
       driver = new SelendroidDriver(new URL(MessageFormat.format("http://{0}:{1}@ondemand.saucelabs.com:80/wd/hub", sauceUserName, sauceAccessKey)),
                capabilities);
      //  this.sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
      //  values = new ArrayList<Integer>();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }



    @Test
    public void testUIComputation() throws Exception {

        // populate text fields with values
        driver.get("http://xolo-eng.annectos.net");
        driver.findElement(By.xpath("//input[@type='text']")).clear();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("44");
        driver.findElement(By.xpath("//input[@type='password']")).clear();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("welcome");
        driver.findElement(By.linkText("Sign In")).click();
        WebElement elmSiginmsg= driver.findElement(By.xpath("//div[3]/button"));

        Thread.sleep(1000);
        String Saledat= (driver.findElement(By.cssSelector("b.ng-binding")).getText());
        if(!Saledat.equalsIgnoreCase("500000"))
        {
            System.out.println("Sale data not found for "+"\n");
            WebElement signout=driver.findElement(By.xpath("//button[2]"));
            signout.click();

        }  else {
            WebElement elm=  driver.findElement(By.xpath("//div[@class='card']//button[.='Enter new Sale']"));
            Thread.sleep(1000);
            if (!driver.findElement(By.xpath("//div[@class='view']/ion-side-menu-content/ion-view/ion-nav-view/ion-nav-view/ion-content/div[1]/ion-scroll/div[1]/div/form/div[1]/select//option[2]")).isSelected()) {
                driver.findElement(By.xpath("//div[@class='view']/ion-side-menu-content/ion-view/ion-nav-view/ion-nav-view/ion-content/div[1]/ion-scroll/div[1]/div/form/div[1]/select//option[2]")).click();
            }
            if (!driver.findElement(By.xpath("//div[@class='view']/ion-side-menu-content/ion-view/ion-nav-view/ion-nav-view/ion-content/div[1]/ion-scroll/div[1]/div/form/div[2]/select//option[3]")).isSelected()) {
                driver.findElement(By.xpath("//div[@class='view']/ion-side-menu-content/ion-view/ion-nav-view/ion-nav-view/ion-content/div[1]/ion-scroll/div[1]/div/form/div[2]/select//option[3]")).click();
            }
            WebElement signout=driver.findElement(By.xpath("//button[2]"));
            signout.click();
    }



} }