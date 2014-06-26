package trash;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import com.Annectos.Webdriver.Common.Properties;
import com.Annectos.Webdriver.Common.Staticprovider;
import com.Annectos.Webdriver.Helper.Logger;
import org.testng.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class xolo {
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
        baseUrl = "http://xolo-eng.annectos.net/#/login/login";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(dataProviderClass = xolo.class, dataProvider = "xolologin")
    public void Xolo_mobile_login_test_driven(String Uname,String Pwd) throws Exception {
        driver.get(baseUrl + "/#/login/login");
        driver.manage().window().maximize();
        //driver.findElement(By.cssSelector("Input[ng-model=\"user_credential.user_id\"]")).clear();
        //driver.findElement(By.cssSelector("input.ng-valid.ng-dirty")).sendKeys("44");
        driver.findElement(By.xpath("//input[@type='text']")).clear();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Uname);
        driver.findElement(By.xpath("//input[@type='password']")).clear();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Pwd);
        driver.findElement(By.linkText("Sign In")).click();
        WebElement elmSiginmsg= driver.findElement(By.xpath("//div[3]/button"));
        waitforElementtoLoad(elmSiginmsg);
        Thread.sleep(1000);
        String Saledat= (driver.findElement(By.cssSelector("b.ng-binding")).getText());
        if(!Saledat.equalsIgnoreCase("500000"))
        {
            System.out.println("Sale data not found for "+Uname+"\n");
            WebElement signout=driver.findElement(By.xpath("//button[2]"));
            signout.click();

        }  else {
        WebElement elm=  driver.findElement(By.xpath("//div[@class='card']//button[.='Enter new Sale']"));
        waitforElementtoLoad(elm);
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

    }
    public void waitforElementtoLoad(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

    }

    @DataProvider(name = "xolologin")
    public static Object[][] spanloginprovider() {

        return new Object[][]{


                {	"44"	,	"welcome"	}	,
                {	"7204177856"	,	"1E7C5E04BD86B3"	}	,
                {	"7204437822"	,	"687D7FD41E59C7"	}	,
                {	"7208271942"	,	"DC838284B414AB"	}	,
                {	"7208687331"	,	"300E435CAF4E27"	}	,
                {	"7208998962"	,	"FA35501B6FD9D5"	}	,
                {	"7259908773"	,	"70F36D7FA43C9A"	}	,
                {	"7276705063"	,	"77B9AB0AB57BC9"	}	,
                {	"7299614693"	,	"3ECD6BB55BD08F"	}	,
                {	"7303975970"	,	"D8C42BEC8FA0EC"	}	,
                {	"7350955595"	,	"32F3EFEB70F510"	}	,
                {	"7359535536"	,	"FDAF69F15E3902"	}	,
                {	"7383136887"	,	"72C202D7ACAC77"	}	,
                {	"7383653132"	,	"1B2135A5B58CDF"	}	,
                {	"7389444474"	,	"242B6E16E25416"	}	,
                {	"7396850460"	,	"AC4B3431A7EC77"	}	,
                {	"7401218922"	,	"433A92B1D9E2A9"	}	,
                {	"7405031643"	,	"66910FD2A1ABBF"	}	,
                {	"7406606988"	,	"ADBDCD0F8F9C20"	}	,
                {	"7567104619"	,	"7651CFB6F51746"	}	,
                {	"7567834041"	,	"6ECFF766301D54"	}	,
                {	"7600991718"	,	"1D60F50C2D2DB1"	}	,
                {	"7666541756"	,	"D157AF48053ADC"	}	,
                {	"7666571885"	,	"A047CBA12278E3"	}	,
                {	"7676088903"	,	"479692A74956A4"	}	,
                {	"7676111663"	,	"E0609C823AD5A5"	}	,
                {	"7708311557"	,	"5C70D8653E3D9E"	}	,
                {	"7708345958"	,	"0591BC9DD1CB68"	}	,
                {	"7710034358"	,	"193681278FBF36"	}	,
                {	"7715869916"	,	"6AB99F1032F6CD"	}	,
                {	"7738163332"	,	"6A7025D158EABC"	}	,
                {	"7738281143"	,	"1D602348CFAE5A"	}	,
                {	"7738519837"	,	"E94D7FD299FEB8"	}	,
                {	"7760092944"	,	"6E0CF12518FFC7"	}	,
                {	"7760908568"	,	"0F738922DCDFE4"	}	,
                {	"7795578238"	,	"6D70853F58CD2F"	}	,
                {	"7798309877"	,	"64A208618A4BCE"	}	,
                {	"7798789022"	,	"C2E45A415C8832"	}	,
                {	"7802070509"	,	"F8DDBAA054E194"	}	,
                {	"7878039395"	,	"689020ECDB51AC"	}	,
                {	"8000122443"	,	"FBB1061D924061"	}	,
                {	"8012521443"	,	"6475E171A7AAA4"	}	,
                {	"8013296641"	,	"5971426E338974"	}	,
                {	"8019625752"	,	"B7529A63E522EC"	}	,
                {	"8019686863"	,	"F1D8E508A9A1A7"	}	,
                {	"8050385855"	,	"09E77F5FF50788"	}	,
                {	"8050746164"	,	"4AD734289022E2"	}	,
                {	"8050919033"	,	"DAF6C817C479C5"	}	,
                {	"8050973534"	,	"BF17B4BED8970E"	}	,
                {	"8056506663"	,	"94397A10FF1C70"	}	,
                {	"8082419265"	,	"CDE731E35E24FB"	}	,
                {	"8082756148"	,	"524D4D98B9E895"	}	,
                {	"8088339492"	,	"B4E909BBD25262"	}	,
                {	"8096826292"	,	"260E8E117F32E3"	}	,
                {	"8097977746"	,	"8CEBDFE9E4FB83"	}	,
                {	"8103780519"	,	"4B6701ABB3DB15"	}	,
                {	"8108044422"	,	"7F996429DD97B7"	}	,
                {	"8108144404"	,	"0EC73F5D27A00F"	}	,
                {	"8108144406"	,	"106042C23DAC85"	}	,
                {	"8108144407"	,	"1D63A7DA87BCAF"	}	,
                {	"8108144414"	,	"E0FDC24121B129"	}	,
                {	"8108144421"	,	"EA6F3D65F1EC92"	}	,
                {	"8108538453"	,	"F4AD3D4434BB18"	}	,
                {	"8108807868"	,	"D1EABA0E509047"	}	,
                {	"8121108144"	,	"2491940802913E"	}	,
                {	"8122907614"	,	"9F295DF444B8E5"	}	,
                {	"8140406279"	,	"AAD4EDB19C6ED3"	}	,
                {	"8197319235"	,	"26BED53D04F375"	}	,
                {	"8237777045"	,	"118C6D0F49D00E"	}	,
                {	"8291131060"	,	"97A60244F27BBD"	}	,
                {	"8341380656"	,	"033CE6962F1563"	}	,
                {	"8380809161"	,	"72A35DEA87FABF"	}	,
                {	"8401266591"	,	"6F9A152B924F8E"	}	,
                {	"8421898958"	,	"AD3EFCE088EC6C"	}	,
                {	"8425015031"	,	"7FEB82FAB40664"	}	,
                {	"8425800101"	,	"F15CAC29BFF475"	}	,
                {	"8433700700"	,	"7F8F1866F06B1C"	}	,
                {	"8454060006"	,	"F22026229513E1"	}	,
                {	"8460630468"	,	"7E4043C1A92061"	}	,
                {	"8482992143"	,	"CEDF8D3EDE80FF"	}	,
                {	"8488894295"	,	"ACEDA93BDE5849"	}	,
                {	"8552839699"	,	"4033B010E2F7BA"	}	,
                {	"8553188828"	,	"322BB0C4FBD1C3"	}	,
                {	"8554047737"	,	"E9E9B37E7FAD32"	}	,
                {	"8608399511"	,	"FE2CD15CDD8367"	}	,
                {	"8652227766"	,	"B7A221104CF95A"	}	,
                {	"8652227769"	,	"F9E3D2F109EAD3"	}	,
                {	"8652292229"	,	"187850730257BD"	}	,
                {	"8655026616"	,	"1D5DEB75903547"	}	,
                {	"8655259487"	,	"3FD25E8283B993"	}	,
                {	"8655309315"	,	"77EB379D57136F"	}	,
                {	"8655336297"	,	"77D15E33D47AC4"	}	,
                {	"8655722964"	,	"F188CD18784FDC"	}	,
                {	"8686057508"	,	"91E8C566E9B23B"	}	,
                {	"8686564793"	,	"246B9A7A1351EF"	}	,
                {	"8691801111"	,	"F16A6A0441056E"	}	,
                {	"8698937693"	,	"6EF04ED4FFD22B"	}	,
                {	"8712146303"	,	"7FD83F7363E68B"	}	,
                {	"8722701986"	,	"26E01354F1DA33"	}	,
                {	"8732962559"	,	"55D4A94711E65F"	}	,
                {	"8754049447"	,	"A1AFEB9AFAF8AA"	}	,
                {	"8754479978"	,	"BEF71F7BB4C38E"	}	,
                {	"8801168482"	,	"5C8292AD4B371E"	}	,
                {	"8801760000"	,	"3AD714A9BB4323"	}	,
                {	"8807501826"	,	"AA494D2751BBC1"	}	,
                {	"8807788192"	,	"77A9667ED109D3"	}	,
                {	"8866062887"	,	"E44BD2BE69B4B6"	}	,
                {	"8866256131"	,	"CDE7CBABD7C454"	}	,
                {	"8866307898"	,	"74D477DEA5F3F9"	}	,
                {	"8867788143"	,	"A13CDDF0055272"	}	,
                {	"8870506113"	,	"E2E39124068F20"	}	,
                {	"8870881964"	,	"F79297706F87CB"	}	,
                {	"8871521664"	,	"4CA4D7905B5983"	}	,
                {	"8878765222"	,	"7EC38C5E3CA351"	}	,
                {	"8879211180"	,	"C0064A7F3AED49"	}	,
                {	"8879327314"	,	"B79E2E565A6CA5"	}	,
                {	"8892148783"	,	"5E5B2405113AEF"	}	,
                {	"8892572307"	,	"1A63B75E664548"	}	,
                {	"8898033131"	,	"AB1DA5CD8C81B8"	}	,
                {	"8898182600"	,	"4A47C83DFFEAE3"	}	,
                {	"8898600105"	,	"43E0498BAB4787"	}	,
                {	"8898670999"	,	"696CDD78BC1FC5"	}	,
                {	"8904166691"	,	"7C6EAB228F71DE"	}	,
                {	"8939250565"	,	"B1C56587760DFC"	}	,
                {	"8939828000"	,	"3574D79E5AA0B3"	}	,
                {	"8940461234"	,	"6BDC3524B7B066"	}	,
                {	"8943340528"	,	"B6A9EBFB0F1D91"	}	,
                {	"8956666606"	,	"43FDCFE69A5492"	}	,
                {	"8976178255"	,	"55F13C0B27655F"	}	,
                {	"8980551444"	,	"A8D503E19C9806"	}	,
                {	"8983110021"	,	"92862D342BDBCB"	}	,
                {	"9003148473"	,	"E14F6269860E5F"	}	,
                {	"9003222916"	,	"D3A4A69060AAFD"	}	,
                {	"9003510105"	,	"A822D95E1D85DA"	}	,
                {	"9003530300"	,	"1734C987C43B84"	}	,
                {	"9004466646"	,	"A5555DC574FA1D"	}	,
                {	"9004478675"	,	"AC0D74E37D0853"	}	,
                {	"9004551069"	,	"E88E07C2EB263D"	}	,
                {	"9004614641"	,	"5C7757F117F3C2"	}	,
                {	"9004839452"	,	"4F982EEC5CDEEB"	}	,
                {	"9008660992"	,	"0371894F919D9D"	}	,
                {	"9008715739"	,	"B2CB98C9B18294"	}	,
                {	"9010704739"	,	"D69BCAB3B76394"	}	,
                {	"9021124214"	,	"B574078D7E5622"	}	,
                {	"9022331484"	,	"B6DE379583651D"	}	,
                {	"9022990053"	,	"0FBE87D8DBB0F6"	}	,
                {	"9028225805"	,	"CF9E546188494E"	}	,
                {	"9028533886"	,	"A3BF861E618FDA"	}	,
                {	"9028920243"	,	"8A118F1453EA48"	}	,
                {	"9028949494"	,	"A6244B49E31526"	}	,
                {	"9029260460"	,	"99FFAA2FCDCE9F"	}	,
                {	"9029424572"	,	"6A83DD37CB3302"	}	,
                {	"9029493734"	,	"E864E131905A25"	}	,
                {	"9030394399"	,	"0116648E17C2D4"	}	,
                {	"9030999512"	,	"7CA8063AD79F30"	}	,
                {	"9033877476"	,	"46CA4B8A182A5C"	}	,
                {	"9033995200"	,	"5A0FD1189658F9"	}	,
                {	"9035009497"	,	"3F0BA75E8BC6B1"	}	,
                {	"9035541790"	,	"F2942C179F2F23"	}	,
                {	"9035566381"	,	"535565190AE742"	}	,
                {	"9036169446"	,	"EB5F42C1ECE773"	}	,
                {	"9036429885"	,	"94D9DC7886F21A"	}	,
                {	"9036591236"	,	"79685650EB0233"	}	,
                {	"9039399086"	,	"A7EDBDF1E723BC"	}	,
                {	"9049167763"	,	"C52C99E7B32076"	}	,
                {	"9052200333"	,	"227204D66ACD22"	}	,
                {	"9060004200"	,	"114EA1F902B79F"	}	,
                {	"9088079677"	,	"E9B844B1CBE4BB"	}	,
                {	"9092342842"	,	"8FAAC296FAC699"	}	,
                {	"9092588540"	,	"A526DA63B86219"	}	,
                {	"9094377964"	,	"520FDF494758DC"	}	,
                {	"9095458459"	,	"8BFA03F4942CCB"	}	,
                {	"9095999050"	,	"911BAA072105A1"	}	,
                {	"9099096719"	,	"07EF25306B2114"	}	,
                {	"9099303999"	,	"254E30AF5A9B5F"	}	,
                {	"9099444368"	,	"3BB32EC8A1DE79"	}	,
                {	"9099852609"	,	"63E1A437C869FF"	}	,
                {	"9164085999"	,	"D017500E89A9D4"	}	,
                {	"9167562127"	,	"70AF3985306F0F"	}	,
                {	"9167929418"	,	"AFC285B172D052"	}	,
                {	"9173206010"	,	"1E320925AC515D"	}	,
                {	"9173575733"	,	"04812D37F72540"	}	,
                {	"9173582630"	,	"4773F909F8E4AA"	}	,
                {	"9175100841"	,	"56BD7B5BEC727B"	}	,
                {	"9175762983"	,	"E43F6A50BADE39"	}	,
                {	"9176365380"	,	"776F62DB938788"	}	,
                {	"9179105646"	,	"02BF3484FAA11F"	}	,
                {	"9221137988"	,	"148254AB838F71"	}	,
                {	"9321615346"	,	"20C5FF663D7ABB"	}	,
                {	"9323009950"	,	"020C56E5DF481B"	}	,
                {	"9323360969"	,	"F6E3BE1D90239C"	}	,
                {	"9324440355"	,	"F4A52AD084F449"	}	,
                {	"9370173315"	,	"F11A41F6D90148"	}	,
                {	"9375333366"	,	"A5D2ACF5FE9689"	}	,
                {	"9408346732"	,	"7311502D206D04"	}	,
                {	"9425709975"	,	"01DD2501F4FD35"	}	,
                {	"9429329100"	,	"D651C219B934A2"	}	,
                {	"9443290653"	,	"C6A1857BB1D803"	}	,
                {	"9487902905"	,	"950269A3B70134"	}	,
                {	"9497868913"	,	"98A2FE58650160"	}	,
                {	"9500630999"	,	"3588CF5119C9E4"	}	,
                {	"9500845714"	,	"B90B9CBCC478DD"	}	,
                {	"9502330909"	,	"FB0C8AA0E8175A"	}	,
                {	"9524818566"	,	"01287CF6F13923"	}	,
                {	"9526742163"	,	"6250DA9226B17F"	}	,
                {	"9535373780"	,	"884C4786529695"	}	,
                {	"9551161494"	,	"49FC9EC51AD629"	}	,
                {	"9551310564"	,	"6BE55E1EBB89EC"	}	,
                {	"9551525515"	,	"FDD8C0424D3577"	}	,
                {	"9551873032"	,	"C542EA22341007"	}	,
                {	"9552999712"	,	"DA2BD30B0B04A3"	}	,
                {	"9558571316"	,	"DCA8C6770AE007"	}	,
                {	"9561610109"	,	"2F5F2955702B3E"	}	,
                {	"9566404989"	,	"3F3F102723FE93"	}	,
                {	"9578358448"	,	"5D3B6EF2CC47A1"	}	,
                {	"9589838619"	,	"F486943F7EEFF0"	}	,
                {	"9594171717"	,	"42DDBE5AD1C2B2"	}	,
                {	"9594598095"	,	"9DE132DA609DA0"	}	,
                {	"9597503400"	,	"2512B64F14A599"	}	,
                {	"9597733911"	,	"E2833CB55E0D87"	}	,
                {	"9600837307"	,	"8EC063D8168EE8"	}	,
                {	"9611669015"	,	"4CA753529F92E3"	}	,
                {	"9611987993"	,	"6FA4CBD0BDC673"	}	,
                {	"9618089720"	,	"556643E23BF921"	}	,
                {	"9619013555"	,	"5779DE8234B4A5"	}	,
                {	"9619372787"	,	"45480F956AB466"	}	,
                {	"9619380961"	,	"03E03724CE2ED6"	}	,
                {	"9619500887"	,	"619136B9FA5C7C"	}	,
                {	"9619878022"	,	"B350B904B92ACE"	}	,
                {	"9620073793"	,	"88877A368B2FC5"	}	,
                {	"9620990079"	,	"C594197EC82070"	}	,
                {	"9624865703"	,	"172AE0F908FC34"	}	,
                {	"9629485903"	,	"044D9305FB19FD"	}	,
                {	"9629854590"	,	"62A18898D84981"	}	,
                {	"9629978325"	,	"85B0D128F0F5F2"	}	,
                {	"9632102419"	,	"1D5CC3174E24BF"	}	,
                {	"9632613244"	,	"4E28E231CE4870"	}	,
                {	"9632940114"	,	"D92F4A36A9A674"	}	,
                {	"9652976268"	,	"8A417A4AC03F0B"	}	,
                {	"9663078225"	,	"82553F1D3ABA4E"	}	,
                {	"9664226663"	,	"195904C9DE2D32"	}	,
                {	"9664661466"	,	"D9371F7792D5B6"	}	,
                {	"9665345665"	,	"05ED17FA851F79"	}	,
                {	"9665707041"	,	"718F242711307E"	}	,
                {	"9666193636"	,	"8F578116813D45"	}	,
                {	"9666923323"	,	"26FFC3C10E15E2"	}	,
                {	"9677376499"	,	"37C1D87107970F"	}	,
                {	"9685405131"	,	"24CFDB99D6452F"	}	,
                {	"9699835564"	,	"F73CFDE47AEA7C"	}	,
                {	"9700772888"	,	"3169489571201"	}	,
                {	"9700847888"	,	"326DF741389A2D"	}	,
                {	"9700883860"	,	"BB0CA2283571D7"	}	,
                {	"9701538712"	,	"DF4ED124D48D75"	}	,
                {	"9701563156"	,	"32405973EFCD92"	}	,
                {	"9712614004"	,	"E66F69DFCC948D"	}	,
                {	"9713141501"	,	"2B317C40B81543"	}	,
                {	"9713729902"	,	"02FBD10ED47E1E"	}	,
                {	"9720308892"	,	"5C5AA88F9D2F0B"	}	,
                {	"9723455230"	,	"22863280F7B1A6"	}	,
                {	"9724760001"	,	"EB89B9ABD0F646"	}	,
                {	"9724813993"	,	"FD93827878342D"	}	,
                {	"9725104296"	,	"437AD231AF7887"	}	,
                {	"9726881778"	,	"6E4E7F25B27738"	}	,
                {	"9727082885"	,	"DCA7BF054C1CF4"	}	,
                {	"9727384499"	,	"3E2BA3A9453611"	}	,
                {	"9730923433"	,	"D08B1AA6E520B8"	}	,
                {	"9731004831"	,	"84A374C9ED914A"	}	,
                {	"9731577034"	,	"EE1636057BBA77"	}	,
                {	"9738441220"	,	"0814CEE561A5BD"	}	,
                {	"9738641008"	,	"71C3E86EA57D73"	}	,
                {	"9739482817"	,	"171D88CA415534"	}	,
                {	"9739515029"	,	"A73181902BA62A"	}	,
                {	"9740440888"	,	"8402941015B4FF"	}	,
                {	"9741000789"	,	"1DEB9CC47CB7E9"	}	,
                {	"9742917464"	,	"A265E2EB8E2738"	}	,
                {	"9743201330"	,	"BFE11FCB283B90"	}	,
                {	"9746191818"	,	"4847FDDF9C1EF3"	}	,
                {	"9746484788"	,	"0EFF36AE172C06"	}	,
                {	"9746949821"	,	"DE4E4EF687AC49"	}	,
                {	"9762247070"	,	"09F36CD3497A22"	}	,
                {	"9762545538"	,	"C441B9983052BF"	}	,
                {	"9764072020"	,	"AACEC3ABF7E543"	}	,
                {	"9765655454"	,	"BFF17E720340C8"	}	,
                {	"9765997848"	,	"B8483C625B1DB5"	}	,
                {	"9766622290"	,	"394C58F67F1060"	}	,
                {	"9766779111"	,	"EDBF64FF815D36"	}	,
                {	"9766992674"	,	"8CF774F00E6419"	}	,
                {	"9767676761"	,	"2FE5FA0D525969"	}	,
                {	"9767925925"	,	"E2637E2BC3A8A8"	}	,
                {	"9768529921"	,	"88F27B543CF4B6"	}	,
                {	"9768911921"	,	"7417D692D07EF8"	}	,
                {	"9769248606"	,	"BDD912875DDFF7"	}	,
                {	"9769515251"	,	"61DDCB5F5641BC"	}	,
                {	"9769727373"	,	"51B0BCC7D1B49B"	}	,
                {	"9769888262"	,	"E0182B512FDE12"	}	,
                {	"9769980540"	,	"FE8E037204E0C8"	}	,
                {	"9773131213"	,	"730F30EFAC103D"	}	,
                {	"9773686020"	,	"36FF463460C7FA"	}	,
                {	"9773772523"	,	"F50B681B2DD8D8"	}	,
                {	"9786303488"	,	"59B72C73AC3C81"	}	,
                {	"9786990283"	,	"DC38E4ECC2A783"	}	,
                {	"9788692277"	,	"AA77DA4415372B"	}	,
                {	"9789182865"	,	"44D40FA0B19330"	}	,
                {	"9789700010"	,	"02D91EE8241609"	}	,
                {	"9790714951"	,	"76E3BD4C34DF1B"	}	,
                {	"9804661674"	,	"E90A83BE6972E4"	}	,
                {	"9809044131"	,	"D5F1687B903B2B"	}	,
                {	"9819131532"	,	"7358750F031C69"	}	,
                {	"9819152420"	,	"7C9E18382FA42D"	}	,
                {	"9819333198"	,	"7FD6315D88CE6C"	}	,
                {	"9819333337"	,	"29A1DC694E75B3"	}	,
                {	"9819334568"	,	"9C3441613804FD"	}	,
                {	"9819334570"	,	"204B50BC583AB9"	}	,
                {	"9819388818"	,	"796DCCA3A99DE8"	}	,
                {	"9819709892"	,	"E401AF7B0A935F"	}	,
                {	"9819874901"	,	"10D31E050B1582"	}	,
                {	"9820553444"	,	"C3948175380C1C"	}	,
                {	"9820689311"	,	"D98405C14A9808"	}	,
                {	"9820885340"	,	"3D72AA81EF1201"	}	,
                {	"9820902102"	,	"C56A1A45347BDC"	}	,
                {	"9820942313"	,	"6020AE9C516250"	}	,
                {	"9821110800"	,	"8C11D1AA76B803"	}	,
                {	"9821137110"	,	"4CBD70BDE0E8A3"	}	,
                {	"9821868215"	,	"EAD45D930A1B0E"	}	,
                {	"9822273381"	,	"25FFFC020867D0"	}	,
                {	"9822557795"	,	"E7D5557454A46D"	}	,
                {	"9822898789"	,	"68F29AC8A76E91"	}	,
                {	"9823414288"	,	"CB8F9021DBC1E6"	}	,
                {	"9823884393"	,	"3CE8CB12FC4742"	}	,
                {	"9824481910"	,	"C7126D2D499C03"	}	,
                {	"9824785785"	,	"78891B4EE24F93"	}	,
                {	"9825069786"	,	"7A37AA049F7B11"	}	,
                {	"9826159753"	,	"C60EDAFDC81E5B"	}	,
                {	"9827988141"	,	"3AE466B661A1A9"	}	,
                {	"9833001186"	,	"017B1FB1BD7CEF"	}	,
                {	"9833424359"	,	"861D67FED6A64C"	}	,
                {	"9833469968"	,	"38930539D2A422"	}	,
                {	"9833652284"	,	"5ECB86E5C38952"	}	,
                {	"9833662098"	,	"40639957EACD15"	}	,
                {	"9833770120"	,	"CDACEF91B07813"	}	,
                {	"9833950666"	,	"6366E77A1F0BD5"	}	,
                {	"9836989030"	,	"C18E3FD1FD0C35"	}	,
                {	"9840276999"	,	"88B66332F7BBF6"	}	,
                {	"9840465659"	,	"9F8BCD75F6BB06"	}	,
                {	"9840652201"	,	"1BDBA98477B5C0"	}	,
                {	"9840738913"	,	"2B61D773919E54"	}	,
                {	"9843561673"	,	"3B6C7809116A10"	}	,
                {	"9844154154"	,	"263D305C1D8C57"	}	,
                {	"9845064394"	,	"E77DF51653A7B2"	}	,
                {	"9845427989"	,	"5B870AEC640A48"	}	,
                {	"9845675386"	,	"FB41E3C0796BE3"	}	,
                {	"9845687414"	,	"62BC2B9701A82A"	}	,
                {	"9846949355"	,	"6F0340A19D5BC8"	}	,
                {	"9847220182"	,	"88D775AD59BD17"	}	,
                {	"9849666082"	,	"FFAEC8F4C0BD8C"	}	,
                {	"9860029999"	,	"032C9A848AAD08"	}	,
                {	"9860721448"	,	"FDDA90D6C52E47"	}	,
                {	"9867000581"	,	"37C3B0E704F44C"	}	,
                {	"9867048865"	,	"D270767DFF1988"	}	,
                {	"9867054337"	,	"D4B377BEC7CB35"	}	,
                {	"9867089189"	,	"E0CE2104750DD4"	}	,
                {	"9867130185"	,	"C3992EA3DEA069"	}	,
                {	"9867222305"	,	"45FFF817FBE7BB"	}	,
                {	"9867420590"	,	"940D09A9BB5964"	}	,
                {	"9867630090"	,	"46ABEF96409635"	}	,
                {	"9867999950"	,	"458CB375CE09CD"	}	,
                {	"9869009902"	,	"0B9424A5D2275D"	}	,
                {	"9870408673"	,	"732269B98CA502"	}	,
                {	"9870887823"	,	"2C5677764626BE"	}	,
                {	"9879153470"	,	"332256F8C796F3"	}	,
                {	"9879174743"	,	"36E071ECCDC568"	}	,
                {	"9879565611"	,	"54BF6C168FC12B"	}	,
                {	"9879565800"	,	"DA0A4AE4CCC592"	}	,
                {	"9879599557"	,	"B5813BB3FFC7F5"	}	,
                {	"9880717922"	,	"01BAE7B5F5F3E7"	}	,
                {	"9880975678"	,	"87DAE76487209C"	}	,
                {	"9884558484"	,	"BDD5C59D631231"	}	,
                {	"9884578330"	,	"977406FBED2BF5"	}	,
                {	"9884791187"	,	"89082D97494C7C"	}	,
                {	"9884847861"	,	"40494B3F0709DA"	}	,
                {	"9885274573"	,	"1CE67434108BCA"	}	,
                {	"9885363786"	,	"B1A589DA3A43D5"	}	,
                {	"9886112409"	,	"2837911F81BFC5"	}	,
                {	"9886275175"	,	"BA21A05EADD731"	}	,
                {	"9886429745"	,	"DE2222156EB448"	}	,
                {	"9886441528"	,	"EBA6C60C7DF171"	}	,
                {	"9886635746"	,	"ADCF77746136D8"	}	,
                {	"9886878335"	,	"24CF0B783E7039"	}	,
                {	"9890089400"	,	"4FC1E225043B4F"	}	,
                {	"9890542509"	,	"7E264E0EEC8BC9"	}	,
                {	"9892040898"	,	"E2E0271BB468F4"	}	,
                {	"9892139046"	,	"EFE2DF7574F9C8"	}	,
                {	"9892351210"	,	"53391D2FDF1F7E"	}	,
                {	"9892413453"	,	"2153D55D69DECD"	}	,
                {	"9892467564"	,	"BA05C58DD025CC"	}	,
                {	"9892573755"	,	"5FF33339501A16"	}	,
                {	"9892644957"	,	"7C1D11197C336E"	}	,
                {	"9892765718"	,	"1A3A7C18B38B75"	}	,
                {	"9892804810"	,	"16421FD29AC97C"	}	,
                {	"9894833448"	,	"9F81EE802A35DA"	}	,
                {	"9894881142"	,	"EE62C2CB4BB482"	}	,
                {	"9894939750"	,	"7035F23FF7DF9A"	}	,
                {	"9898050044"	,	"8FF313ACB38F02"	}	,
                {	"9900998545"	,	"28F9BBB22CF7EE"	}	,
                {	"9901026776"	,	"6D69EA2A993FC0"	}	,
                {	"9902047890"	,	"787AD387CF401D"	}	,
                {	"9904782620"	,	"C85AE6946C554C"	}	,
                {	"9907049267"	,	"E24FC0DE2E4E77"	}	,
                {	"9909212128"	,	"740244FF2E036C"	}	,
                {	"9909881862"	,	"CC56C03E3DEFE2"	}	,
                {	"9909919928"	,	"E32584DB728855"	}	,
                {	"9909975464"	,	"383C17F81B5585"	}	,
                {	"9909989499"	,	"C813F364AFE112"	}	,
                {	"9909999088"	,	"C30646BE8F5763"	}	,
                {	"9912045079"	,	"BD84BF210554F3"	}	,
                {	"9913040906"	,	"27654252D3D340"	}	,
                {	"9913919104"	,	"0B716AB475617B"	}	,
                {	"9916977717"	,	"A6242CEAC231AD"	}	,
                {	"9920111702"	,	"E96B8EAD95FC55"	}	,
                {	"9921219183"	,	"ADEA0E15726A0A"	}	,
                {	"9922866577"	,	"15921CD334DD7D"	}	,
                {	"9923255446"	,	"6344CA8464257E"	}	,
                {	"9923928609"	,	"6BE7F14E2730F9"	}	,
                {	"9924570912"	,	"47EE23F59F4681"	}	,
                {	"9925113237"	,	"0D10BA292F8991"	}	,
                {	"9925753552"	,	"090A30BCB1651E"	}	,
                {	"9930910290"	,	"C8A0CC2EDAC1EE"	}	,
                {	"9940098446"	,	"5A45E3C3CDE334"	}	,
                {	"9940289907"	,	"3837E71FE3B488"	}	,
                {	"9941509515"	,	"E00934E5577C13"	}	,
                {	"9944552641"	,	"5BECFBD93BECB9"	}	,
                {	"9945410342"	,	"A7BF9350237CD2"	}	,
                {	"9952904723"	,	"4E516EA47FF779"	}	,
                {	"9960117221"	,	"BCAEFCBED511F3"	}	,
                {	"9960304333"	,	"2159A1731D807A"	}	,
                {	"9962470233"	,	"D7BC889CD75967"	}	,
                {	"9963838736"	,	"C7791C80E91C9F"	}	,
                {	"9964021124"	,	"8CE1D9FBDE1559"	}	,
                {	"9964621551"	,	"B1174203656D2C"	}	,
                {	"9966022336"	,	"CAF3627F6C9AD5"	}	,
                {	"9966664737"	,	"706EBA986AFF05"	}	,
                {	"9966834348"	,	"8C9134332A1665"	}	,
                {	"9967050743"	,	"3AAB517995B3D7"	}	,
                {	"9967077761"	,	"FD99CD2C2AA53B"	}	,
                {	"9967111666"	,	"352FDA0454B146"	}	,
                {	"9967202444"	,	"27253FE33B995F"	}	,
                {	"9967271051"	,	"D495A3787EE121"	}	,
                {	"9967447700"	,	"93C855E08053F4"	}	,
                {	"9969955188"	,	"7CD3670B5BC3BC"	}	,
                {	"9972344862"	,	"52B82EA0753990"	}	,
                {	"9975740861"	,	"D071DCC20E4722"	}	,
                {	"9975835188"	,	"4C4B7BFA0D70A0"	}	,
                {	"9975857642"	,	"D5773AEB500E2F"	}	,
                {	"9978888086"	,	"AF28D740360AD3"	}	,
                {	"9979033471"	,	"2C960A69D012EE"	}	,
                {	"9979462365"	,	"8BD7C4D0352C4B"	}	,
                {	"9979954654"	,	"CC11ACB30B6524"	}	,
                {	"9980806615"	,	"5933E2FCBE8779"	}	,
                {	"9986015269"	,	"0CF879B745CE8E"	}	,
                {	"9986355303"	,	"95E1CA457C3840"	}	,
                {	"9986381985"	,	"4B8642011CD321"	}	,
                {	"9986610822"	,	"7A42D5B1F5EABB"	}	,
                {	"9986787433"	,	"7D5F9B0529F616"	}	,
                {	"9987319383"	,	"56BC94883A43CA"	}	,
                {	"9987372029"	,	"F326BA22594271"	}	,
                {	"9994427820"	,	"5C0F8B1DD2B760"	}	,
                {	"9994524555"	,	"33979A0B88D264"	}	,
                {	"9994893726"	,	"22F15C82F842D0"	}	,
                {	"9995509595"	,	"E0F4397B34EF6E"	}	,
                {	"rahul.guha@gmail.com"	,	"rahul123"	}	,
                {	"vu60@annectos.in.test-google-a.com"	,	"welcome"	}	,
                {	"xolo@annectos.in"	,	"annectos123"	}	,

        };

    }

    @AfterMethod
    public void tearDown() throws Exception {
        //driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
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
