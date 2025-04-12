package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.Reader;
import java.time.Duration;
import java.util.ArrayList;

public class ContactPage {
    WebDriver driver;


    By contactLink = By.xpath("//*[@id=\"shopify-section-sections--16750295384234__header\"]/sticky-header/header/nav/ul/li[3]/a");
    By purchaseChannel = By.tagName("select");
    By nameField = By.xpath("//*[@id=\"0-name-1\"]");
    By emailField = By.xpath("//*[@id=\"0-email-1\"]");
    By orderNumberField = By.xpath("//*[@id=\"0-text-1\"]");
    By phoneField = By.xpath("//*[@id=\"0-phone-1\"]");
    By serialNumberField = By.xpath("//*[@id=\"0-text-2\"]");
    By uploadFileInput = By.xpath("//*[@id=\"temp-for-0-file2-1_\"]");
    By productUrlField = By.xpath("//*[@id=\"0-url-1\"]");
    By submitButton = By.xpath("//*[@id=\"globo-formbuilder-81469\"]/div/div/div/form/div[2]/div/div[4]/button[2]");
    By successTextElement = By.xpath("//*[@id=\"globo-formbuilder-81469\"]/div/div/div/form/div[2]/div/div[3]/div[1]");
    By errorMessage = By.xpath("//span[@class='err']");
    By supportedTypes = By.xpath("//div[@class='gfb__dropzone--placeholder--description']");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateToContactForm() {
        driver.findElement(contactLink).click();
    }
    public void fillContactForm(String channel, String name, String email, String orderNumber,
                         String phone, String serialNumber, String productUrl) {
        new Select(driver.findElement(purchaseChannel)).selectByVisibleText(channel);
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(orderNumberField).sendKeys(orderNumber);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(serialNumberField).sendKeys(serialNumber);
        driver.findElement(productUrlField).sendKeys(productUrl);
    }

    public
    void uploadDocument(String filePath) {

        WebElement uploadElement = driver.findElement(uploadFileInput);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display = 'block';", uploadElement);

        uploadElement.sendKeys(filePath);
    }

    public
    void submitForm() {
        driver.findElement(submitButton).click();
    }

    public String verifySuccessText() {

        return driver.findElement(successTextElement).getText();
    }
    public String verifyErrorMessage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageText = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));

        return errorMessageText.getText();

    }
    public String getSupportedTypes() {
        return driver.findElement(supportedTypes).getText();
    }


}
