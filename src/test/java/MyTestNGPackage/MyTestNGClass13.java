package MyTestNGPackage;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;

@Listeners({AllureTestNg.class})
public class MyTestNGClass13 {

    WebDriver driver;
    WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(MyTestNGClass13.class);

    @BeforeTest
    @Step("Setup WebDriver and open login page")
    public void bt() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://practicetestautomation.com/practice/");
        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='loop-container']/div/article/div[2]/div[1]/div[1]/p/a")));
        login.click();
        logger.info("Navigated to login page");
    }

    // --------------------- TESTS ---------------------

    @Test(description = "Login with valid credentials and logout")
    @Description("This test checks login functionality with valid credentials")
    @Story("Login Feature")
    public void function1() throws IOException {
        enterCredentials("student", "Password123");
        submitAndLogout();
    }

    @Test(description = "Login with invalid credentials and handle failure")
    @Description("This test checks login functionality with invalid credentials")
    @Story("Login Feature")
    public void function2() throws IOException {
        enterCredentials("sachin", "virat");
        attemptLogoutWithScreenshot();
    }

    @AfterTest
    @Step("Close the browser")
    public void at() {
        driver.quit();
        logger.info("Browser closed");
    }

    // --------------------- STEPS ---------------------

    @Step("Enter username: {0} and password: {1}")
    public void enterCredentials(String usernameStr, String passwordStr) throws IOException {
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));
        username.sendKeys(usernameStr);
        logger.info("Username entered");

        WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
        pwd.sendKeys(passwordStr);
        logger.info("Password entered");

        takeScreenshot("credentials_entered.png");
    }

    @Step("Click submit and logout")
    public void submitAndLogout() throws IOException {
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submit']")));
        submit.click();
        logger.info("Submit clicked");

        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='loop-container']/div/article/div[2]/div/div/div/a")));
        logout.click();
        logger.info("Logout clicked");

        takeScreenshot("logout_success.png");
    }

    @Step("Attempt logout and attach screenshot on failure")
    public void attemptLogoutWithScreenshot() throws IOException {
        try {
            WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submit']")));
            submit.click();
            logger.info("Submit clicked");

            WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='loop-container']/div/article/div[2]/div/div/div/a")));
            logout.click();
            logger.info("Logout clicked");

            takeScreenshot("logout_attempt.png");

        } catch (Exception e) {
            WebElement warning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='error']")));
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
            attachScreenshot("login_failed.png", warning);
            logger.error("Logout failed due to invalid credentials");
            throw e;  // rethrow after screenshot so Allure shows it
        }
    }

    // --------------------- SCREENSHOTS ---------------------

    @Attachment(value = "{0}", type = "image/png")
    public byte[] takeScreenshot(String fileName) throws IOException {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] attachScreenshot(String fileName, WebElement element) throws IOException {
        return element.getScreenshotAs(OutputType.BYTES);
    }
}