package BankPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private final WebDriver driver;
    //Locator
    By welcomeTxt = By.xpath("/html/body/div[2]/h2");
    By logOut_button = By.xpath("/html/body/div[3]/div/ul/li[15]/a");

    // constructor
    public AccountPage(WebDriver driver) {

        this.driver = driver;
    }
    //Keywords

    public String getBankText() {
        return driver.findElement(welcomeTxt).getText();

    }

    public String logOutConfirmation() {
        driver.findElement(logOut_button).click();
        return driver.switchTo().alert().getText();
    }

}
