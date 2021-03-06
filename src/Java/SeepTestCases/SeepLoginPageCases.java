package SeepTestCases;

import com.Annectos.Webdriver.Common.Staticprovider;
import com.Annectos.Webdriver.Common.Testbase;
import com.Annectos.Webdriver.PageObjects.HomePageObjects;
import com.Annectos.Webdriver.PageObjects.LoginPageObjects;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: praveen
 * Date: 6/24/14
 * Time: 12:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class SeepLoginPageCases extends Testbase {

    @Test(dataProviderClass = Staticprovider.class, dataProvider = "WiproLoginplusLogProvider")
    public void LoginAndCheckLogo(String email, String Password,String LogoPath) throws Exception {


        if(threadDriver!=null)
        {
            findRemoteip(threadDriver.get());
        }
        LoginPageObjects loginPageObjects = PageFactory.initElements(getDriver(), LoginPageObjects.class);
        HomePageObjects homePageObjects=PageFactory.initElements(getDriver(),HomePageObjects.class);
        loginPageObjects.OpenURl();
        loginPageObjects.assertEmailLabel();
        loginPageObjects.assertPasswordLabel();
        loginPageObjects.login(email,Password);
        homePageObjects.verifyLogo(LogoPath);

    }
}
