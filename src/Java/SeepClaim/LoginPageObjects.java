package SeepClaim;

/**
 * Created with IntelliJ IDEA.
 * User: praveen
 * Date: 6/24/14
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */

import com.Annectos.Webdriver.Common.CommonMethods;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObjects extends CommonMethods {

    @FindBy(css = "Input[ng-model=\"email_id\"]")
    public WebElement registeredEMail;

    @FindBy(css = "Input[ng-model=\"password\"]")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit' and @value='Submit']")
    public WebElement submit;

    @FindBy(partialLinkText = "Home")
    public  WebElement elmHomeMenu;

    @FindBy(partialLinkText = "PROFILE")
    public  WebElement elmPROFILEMenu;

    @FindBy(partialLinkText = "SEEP")
    public  WebElement elmSEEPMenu;

    @FindBy(partialLinkText = "CLAIM ENTRY")
    public  WebElement elmCLAIMENTRYMenu;

    @FindBy(partialLinkText = "MYCLAIMS")
    public  WebElement elmMYCLAIMSMenu;

    @FindBy(partialLinkText = "REDEMPTION")
    public  WebElement elMREDEMPTIONMenu;

    @FindBy(partialLinkText = "Reward Gallery")
    public  WebElement elmREWARDMenu;

    @FindBy(partialLinkText = "CONTACT")
    public  WebElement elmCONTACTMenu;

    @FindBy(partialLinkText = "SPECIAL")
    public  WebElement elmSPECIALMenu;

    @FindBy(partialLinkText = "CHANGE PASSWORD")
    public  WebElement elmCHNGPWDMenu;

    @FindBy(partialLinkText = "LOGOUT")
    public  WebElement elmLOGOUTMenu;

    public LoginPageObjects(WebDriver adriver) {
        super(adriver);
        driver = adriver;
        wait = new WebDriverWait(driver, timeOut);
        driver.manage().window().maximize();

    }

    public void checkAllMenus()
    {
        waitforElementtoLoad(registeredEMail);
        waitforElementtoLoad(password);
        waitforElementtoLoad(submit);
        waitforElementtoLoad(elmHomeMenu);
        waitforElementtoLoad(elmPROFILEMenu);
        waitforElementtoLoad(elmSEEPMenu);
        waitforElementtoLoad(elmCLAIMENTRYMenu);
        waitforElementtoLoad(elmMYCLAIMSMenu);
        waitforElementtoLoad(elmREWARDMenu);
        waitforElementtoLoad(elmPROFILEMenu);
        waitforElementtoLoad(elmCONTACTMenu);
        waitforElementtoLoad(elmSPECIALMenu);
        waitforElementtoLoad(elmCHNGPWDMenu);
        waitforElementtoLoad(elmLOGOUTMenu);

    }


}