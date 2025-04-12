package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By passwordField = By.xpath("//*[@id=\"password\"]");
    By loginButton = By.xpath("/html/body/div/div[2]/div[2]/form/button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String password) {
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
