package SeepTestCases;

import SeepClaim.SeepHomePageObjects;
import com.Annectos.Webdriver.Common.Staticprovider;
import com.Annectos.Webdriver.Common.Testbase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: praveen
 * Date: 6/24/14
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class SeepHomePageCases extends Testbase {

    @Test(dataProviderClass = Staticprovider.class,dataProvider="SeepData")
    public void it_should_dispaly_all_the_menus(String email, String Password) throws Exception {


        if(threadDriver!=null)
        {
            findRemoteip(threadDriver.get());
        }
        SeepHomePageObjects seepHomePageObjects= PageFactory.initElements(getDriver(), SeepClaim.SeepHomePageObjects.class);
        SeepClaim.LoginPageObjects seepLoginpgobj=PageFactory.initElements(getDriver(),SeepClaim.LoginPageObjects.class);
        seepLoginpgobj.OpenURl();
        seepLoginpgobj.Login_with_both_Email_and_Password(email,Password);
        seepHomePageObjects.checkAllMenus();


    }
}
