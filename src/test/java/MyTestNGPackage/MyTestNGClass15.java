package MyTestNGPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@Listeners(MyTestNGPackage.MyTestNGClass16.class)
public class MyTestNGClass15 {

    public static WebDriver driver; // static for listener access
    public static WebDriverWait wait; // static for listener access
    public static ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeTest
    public void bt() throws InterruptedException {
        spark = new ExtentSparkReporter("test-output/ExtentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://practicetestautomation.com/practice/");
        Thread.sleep(1000);

        WebElement login = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id='loop-container']/div/article/div[2]/div[1]/div[1]/p/a")));
        login.click();
    }

    @Test
    public void function1() throws InterruptedException {
        test = extent.createTest("Test1");

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));
        username.sendKeys("student");
        Thread.sleep(1000);

        WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
        pwd.sendKeys("Password123");
        Thread.sleep(1000);

        test.pass("Your function1 passed");

        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submit']")));
        submit.click();
        Thread.sleep(1000);

        WebElement logout = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id='loop-container']/div/article/div[2]/div/div/div/a")));
        logout.click();
        Thread.sleep(1000);
    }

    @Test
    public void function2() throws InterruptedException {
        test = extent.createTest("Test2");

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));
        username.sendKeys("sachin");
        Thread.sleep(1000);

        WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
        pwd.sendKeys("virat");
        Thread.sleep(1000);

        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submit']")));
        submit.click();
        Thread.sleep(1000);
        
        WebElement logout = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id='loop-container']/div/article/div[2]/div/div/div/a")));
        logout.click();
    }

    @AfterTest
    public void at() {
        driver.close();
        extent.flush();
    }
}