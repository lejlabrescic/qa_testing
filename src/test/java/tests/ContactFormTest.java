package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.cdimascio.dotenv.Dotenv;
import pages.ContactPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactFormTest {
    WebDriver driver;
    Dotenv dotenv = Dotenv.configure().directory("src").load();
    String baseUrl = dotenv.get("BASE_URL");
    String password = dotenv.get("PASSWORD");

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
                "SN-987654",
                "https://product-url.com"
        );

        contactPage.uploadDocument("../../assets/test.jpg");
        contactPage.submitForm();
        Thread.sleep(5000); //added for 
        String successText = contactPage.verifySuccessText();
        assertEquals( "Thanks for getting in touch!", successText);

    }

    @Test
    public void testContactFormSubmissionFromCSV() {

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
