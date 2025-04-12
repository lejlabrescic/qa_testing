<p align="center">
  <img src="https://media.tenor.com/cI3eAVLXj48AAAAC/hello-world.gif" />


# 🔗 Contact Form Automation Testing (Shopify Application)
Contact form on [the following platform](https://qa-test-pc.myshopify.com/pages) is being tested. This project automates the testing of a web application's contact form. The tests cover both expected user behavior (positive scenario) and edge cases (negative scenario). The primary goal is to make sure that user interactions with the form work correctly, and to detect any discrepancies between expected and actual system behavior.

The automation is built using **Selenium WebDriver and Java**. Tests are structured using the **Page Object Model (POM)** for better readability and maintainability. **JUnit** is used as the test framework, and Maven handles project builds and dependency management. Environment variables are managed through the use of the **dotenv-java** library to allow for secure test environments.

## Test suite

The current test suite includes:

-  _A functional smoke test_ that confirms successful submission of the contact form using valid input.
-  _A negative regression test_ that verifies .gif file uploads are not accepted, despite the UI suggesting they should be supported.

Test number | Test name |Test expectations  | Test status | Test type |
--- | --- | --- | --- |--- |
1 | testContactFormSubmission | User should be able to send an inquiry via the contact form. | PASS | Functional Test (Smoke, Positive)  |
2 | testGIFSupport | User is not able to attach "the picture" of type .git, as stated on the form. | PASS  | Negative Test (Regression, Exploratory) |

## Instructions to run the project
#### 1. Prerequisites
Make sure the following are installed on your system:

- A Java-compatible development environment. This project was developed using JetBrains Aqua, but any IDE that supports Java and Maven (e.g., IntelliJ IDEA, Eclipse, VS Code) can be used.
- JDK 11 or higher,
- Maven 3.6 or higher,
- Google Chrome (latest version).

**Note**: You do not need to manually download or configure ChromeDriver. This project uses WebDriverManager, which automatically handles driver resolution and setup at runtime via the dependency defined in the pom.xml.

#### 2. Clone the repository
```bash
  git clone https://github.com/lejlabrescic/qa_testing
```
#### 3. Open folder in the environment 

#### 4. Setting up the environment variables 
To run this project, you will need to add the following environment variables to your .env file (project structure shown below): 

- `PASSWORD`

- `BASE_URL` 
- `JPG_PATH` --> "path to your project" + "src/assets/test.jpg"
- `GIF_PATH` --> --> "path to your project" + "src/assets/giphy.gif"


In the test code, environment variables are loaded as follows:

```bash
  Dotenv dotenv = Dotenv.load();
  String baseUrl = dotenv.get("BASE_URL");
```

**Project structure:**
```plaintext
qa_testing/
├── src/
│   ├── assets/                
│   ├── main/
│   └── test/
│       └── java/
│           ├── pages/         
│           └── tests/         
├── .env                       
├── pom.xml

```
#### 5. Install dependencies 

```bash
   mvn clean install

```
#### 6. Run tests 

To run tests, you can either click on the _"Run"_ icon, or simply enter the following command: 
```bash
   mvn test

```
A Chrome window will automatically pop up, showing that it is controlled by the automated software. Test report will be shown in the console after tests finish, but they can be found on the following path too:  `target/surefire-reports/` . 
