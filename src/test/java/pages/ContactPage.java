package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {
    WebDriver driver;

    // Contact link on homepage
    By contactLink = By.xpath("//*[@id=\"shopify-section-sections--16750295384234__header\"]/sticky-header/header/nav/ul/li[3]/a");

    // Form elements
    By purchaseChannel = By.tagName("select");
    By nameField = By.xpath("//*[@id=\"0-name-1\"]");
    By emailField = By.xpath("//*[@id=\"0-email-1\"]");
    By orderNumberField = By.xpath("//*[@id=\"0-text-1\"]");
    By phoneField = By.xpath("//*[@id=\"0-phone-1\"]");
    By serialNumberField = By.xpath("//*[@id=\"0-text-2\"]");
    By uploadFileInput = By.xpath("//*[@id=\"globo-formbuilder-81469\"]/div/div/div/form/div[2]/div/div[1]/div/div[7]/div/div/div/div[1]/button");
    By productUrlField = By.xpath("//*[@id=\"0-url-1\"]");
    By submitButton = By.xpath("//*[@id=\"globo-formbuilder-81469\"]/div/div/div/form/div[2]/div/div[4]/button[2]");
    By successTextElement = By.xpath("//*[@id=\"globo-formbuilder-81469\"]/div/div/div/form/div[2]/div/div[3]/div[1]");
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

    public void uploadDocument(String filePath) {
        driver.findElement(uploadFileInput).sendKeys(filePath);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }
    public String verifySuccessText() {

        return driver.findElement(successTextElement).getText();
    }
}
