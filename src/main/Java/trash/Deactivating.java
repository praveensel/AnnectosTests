package trash;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Deactivating {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public WebDriverWait wait;
    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\dev\\Selenium\\Automatedtests\\src\\Resources\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(this.driver,30);
        baseUrl = "http://app.qa.annectos.net:8081/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl );
        WebElement username=driver.findElement(By.id("Username"));
        waitforElementtoLoad(username);
        username.sendKeys("super admin");
        WebElement password= driver.findElement(By.id("Password"));
        waitforElementtoLoad(password);

        password.sendKeys("annectos@2013");
        WebElement login= driver.findElement(By.id("LogIn"));
        waitforElementtoLoad(login) ;
    }

    @Test(dataProvider = "testgg")
    public void testUntitled(String Pid) throws Exception {



        WebElement productmgmtlink=driver.findElement(By.linkText("Prod Mgmt."));
        waitforElementtoLoad(productmgmtlink);
        Thread.sleep(6000);
        WebElement Searchbtn= driver.findElement(By.id("btnSearchProd"));
        waitforElementtoLoad1(Searchbtn);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + Searchbtn.getLocation().y + ")");
        Searchbtn.click();
        WebElement Searchtxt=driver.findElement(By.id("txtSrchProdId"));
        waitforElementtoLoad(Searchtxt);
        WebElement productidbox=driver.findElement(By.id("txtSrchProdId"));
        waitforElementtoLoad(productidbox);
        productidbox.sendKeys(Pid);
        WebElement btnProdSrch= driver.findElement(By.id("btnProdSrch"));
        waitforElementtoLoad(btnProdSrch);
        WebElement rdiobtn=driver.findElement(By.id("rbSelLoc"));
        waitforElementtoLoad(rdiobtn);
        Thread.sleep(6000);
        WebElement chkbx=driver.findElement(By.id("chkProdStatus"));
        waitforElementtoLoad1(chkbx);
        if(!chkbx.isSelected())
        {
            chkbx.click();
            WebElement btnSaveProduct=driver.findElement(By.id("btnSaveProduct"));
            waitforElementtoLoad(btnSaveProduct);
            Thread.sleep(6000);
            assertEquals("Record Saved Successfully.", closeAlertAndGetItsText());
        }

    }

    @AfterClass
    public void tearDown() throws Exception {
      driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    @DataProvider  (name = "testgg")
    public static Object[][] productsto()
    {
        return new Object[][]{{"RI01436"},{"RI01436"}} ;
    }
    public void waitforElementtoLoad(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

    }
    public void waitforElementtoLoad1(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        //element.click();

    }
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
