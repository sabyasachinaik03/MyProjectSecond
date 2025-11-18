package MyTestNGPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyTestNGClass19 {

    public WebDriver driver;
    public WebDriverWait wait;
    public ExtentSparkReporter spark;
    public ExtentReports extent;
    public ExtentTest test;
    public MyTestNGClass18 mtc;

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
        mtc=new MyTestNGClass18(driver);
        mtc.clickLogin();
    }

    @Test
    public void function1() throws InterruptedException {
        test = extent.createTest("Test1");

        mtc.enterUsername("student");
        Thread.sleep(1000);

        mtc.enterPassword("Password123");
        Thread.sleep(1000);

        mtc.clickSubmit();
        Thread.sleep(1000);
        
        test.pass("Your function1 passed");
        
        mtc.clickLogout();
    }

    @Test
    public void function2() throws InterruptedException {
        test = extent.createTest("Test2");

        mtc.enterUsername("sachin");
        Thread.sleep(1000);

        mtc.enterPassword("virat");
        Thread.sleep(1000);

        mtc.clickSubmit();
        Thread.sleep(1000);
        
        test.pass("Your function2 passed");
        
        mtc.clickLogout();
    }

    @AfterTest
    public void at() {
        driver.close();
        extent.flush();
    }
}