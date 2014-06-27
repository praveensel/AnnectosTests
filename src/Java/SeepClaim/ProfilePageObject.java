package SeepClaim;

/**
 * Created with IntelliJ IDEA.
 * User: praveen
 * Date: 6/16/14
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePageObject {

    @FindBy(css = "/html/body/div[2]/div/div[2]/div/div[1]/p[1]/input")
    public WebElement firstName1;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[1]/p[2]/input")
    public WebElement email;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[1]/p[3]/label[2]/input")
    public WebElement gender1;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[1]/p[3]/label[3]/input")
    public WebElement gender2;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[1]/p[4]/input")
    public WebElement companyFoundedDate;

    @FindBy(xpath = "//input[@type='button' and @value='Save'][1]")
    public WebElement save1;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/p[1]/input")
    public WebElement lastName1;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/p[2]/input")
    public WebElement lastName2;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/p[3]/input")
    public WebElement dateOfBirth;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/p[4]/input")
    public WebElement education;

    @FindBy(xpath = "/html/body/div[2]/div/div[4]/div[1]/div[2]/input")
    public WebElement pleaseAddName1;

    @FindBy(xpath = "/html/body/div[2]/div/div[4]/div[2]/div/p[1]/input")
    public WebElement firstName2;

    @FindBy(xpath = "/html/body/div[2]/div/div[4]/div[2]/div/p[2]/input")
    public WebElement lastName3;

    @FindBy(xpath = "/html/body/div[2]/div/div[4]/div[2]/div/p[3]/textarea")
    public WebElement pleaseAddName2;

    @FindBy(xpath = "/html/body/div[2]/div/div[4]/div[2]/div/p[4]/input")
    public WebElement landmark;

    @FindBy(xpath = "/html/body/div[2]/div/div[4]/div[2]/div/p[5]/input")
    public WebElement city;

    @FindBy(xpath = "/html/body/div[2]/div/div[4]/div[2]/div/p[6]/select")
    public WebElement pleaseAddName3;

    @FindBy(xpath = "/html/body/div[2]/div/div[4]/div[2]/div/p[8]/input")
    public WebElement pincode;

    @FindBy(xpath = "/html/body/div[2]/div/div[4]/div[2]/div/p[9]/input")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[@type='button' and @value='Save'][2]")
    public WebElement save2;

}
