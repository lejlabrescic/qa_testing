package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.cdimascio.dotenv.Dotenv;
import pages.ContactPage;
import pages.LoginPage;

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
    public void testContactFormSubmission() {
        ContactPage contactPage = new ContactPage(driver);
        contactPage.navigateToContactForm();

        contactPage.fillContactForm(
                "Amazon",               // Purchase Channel
                "Keks",                   // Name
                "keks@gmail.com",           // Email
                "123456",                     // Order Number
                "61123456",                   // Phone
                "SN-987654",                  // Serial Number
                "https://product-url.com"     // Product URL
        );

        contactPage.uploadDocument("../../assets/test.jpg");
        contactPage.submitForm();

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
