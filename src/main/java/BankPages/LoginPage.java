package BankPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    //Locator
    By UserName = By.name("uid");
    By Password = By.name("password");
    By Login_Button = By.name("btnLogin");

    // constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    //Keywords
    public void navigateToBank() {

        driver.navigate().to("http://demo.guru99.com/V4/");
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }


    public void loginToAccount() {
        driver.findElement(UserName).sendKeys("mngr361529");
        driver.findElement(Password).sendKeys("surehAq");
        driver.findElement(Login_Button).click();

    }

    public String loginWithInvalidUser() {
        driver.findElement(UserName).sendKeys("mng");
        driver.findElement(Password).sendKeys("surehAq");
        driver.findElement(Login_Button).click();
        return driver.switchTo().alert().getText();
    }

    public String loginWithInvalidPassword() {
        driver.findElement(UserName).sendKeys("mngr361529");
        driver.findElement(Password).sendKeys("33");
        driver.findElement(Login_Button).click();
        return driver.switchTo().alert().getText();
    }

    public String loginWithInvalidUserAndPassword() {
        driver.findElement(UserName).sendKeys("m235");
        driver.findElement(Password).sendKeys("s1465");
        driver.findElement(Login_Button).click();
        return driver.switchTo().alert().getText();
    }


}
