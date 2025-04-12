package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.cdimascio.dotenv.Dotenv;
import pages.ContactPage;
import pages.LoginPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContactFormTest {
    WebDriver driver;
    Dotenv dotenv = Dotenv.configure().directory("src").load();
    String baseUrl = dotenv.get("BASE_URL");
    String password = dotenv.get("PASSWORD");
    String jpgPath = dotenv.get("JPG_PATH");
    String gifPath = dotenv.get("GIF_PATH");
    String  csvPath = dotenv.get("CSV_PATH");

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(password);
    }

    @Test
    public void testContactFormSubmission() throws InterruptedException {
        ContactPage contactPage = new ContactPage(driver);
        contactPage.navigateToContactForm();

        contactPage.fillContactForm(
                "Amazon",
                "Keks",
                "keks@gmail.com",
                "123456",
                "61123456",
                "SN-12345",
                "https://skateboard.com"
        );

        contactPage.uploadDocument(jpgPath);
        Thread.sleep(3000);
        contactPage.submitForm();
        Thread.sleep(5000); //added for security purpose
        String successText = contactPage.verifySuccessText();
        assertEquals( "Thanks for getting in touch!", successText);

    }



    @Test
    public void testGIFSupport() throws InterruptedException {
            ContactPage contactPage = new ContactPage(driver);
            contactPage.navigateToContactForm();

            contactPage.fillContactForm(
                    "Amazon",
                    "Keks",
                    "keks@gmail.com",
                    "123456",
                    "61123456",
                    "SN-12345",
                    "https://skateboard.com"
            );
            assertEquals("Supported format: JPG, JPEG, PNG, GIF, SVG.", contactPage.getSupportedTypes());
            contactPage.uploadDocument(gifPath);
            Thread.sleep(3000);
            contactPage.submitForm();
            Thread.sleep(6000);
            String errorMessageText = contactPage.verifyErrorMessage();
            assertFalse(errorMessageText.contains("gif"));

        }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

