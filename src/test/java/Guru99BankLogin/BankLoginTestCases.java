package Guru99BankLogin;

import BankPages.AccountPage;
import BankPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankLoginTestCases {
    public WebDriver driver;
    public LoginPage loginPage;
    public AccountPage accountPage;

    @Description("Validating the GGuru99 Bank page title")
    @Test
    public void checkPageTitle() {
        Assert.assertTrue(loginPage.getHomePageTitle().contains("Guru99 Bank"));
    }

    @Description("Validating GGuru99 Bank Login")
    @Test
    public void loginToBankAccount() {
        loginPage.loginToAccount();
        Assert.assertEquals(accountPage.getBankText(), "Guru99 Bank");

    }

    @Description("Validating Guru99 Bank login With Invalid User Popup Message")
    @Test
    public void loginToBankWithInvalidUser() {
        Assert.assertEquals("User or Password is not valid", loginPage.loginWithInvalidUser());

    }

    @Description("Validating Guru99 Bank login With Invalid Password Popup Message")
    @Test
    public void loginToBankWithInvalidPassword() {
        Assert.assertEquals("User or Password is not valid", loginPage.loginWithInvalidPassword());

    }

    @Description("Validating Guru99 Bank login With Invalid User And Password Popup Message")
    @Test
    public void loginToBankWithInvalidUserAndPassword() {
        Assert.assertEquals("User or Password is not valid", loginPage.loginWithInvalidUserAndPassword());

    }


    @Description("Validating Guru99 Bank LogOut Popup Confirmation Message ")
    @Test
    public void logOutFromAccountPopupConfirmation() {
        loginPage.loginToAccount();
        Assert.assertTrue(accountPage.logOutConfirmation().contains("Succesfully"));

    }


    @BeforeClass
    public void BrowserSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        loginPage.navigateToBank();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
