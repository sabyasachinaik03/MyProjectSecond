package MyTestNGPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestNGClass16 implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("==> Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("==> Test Suite Finished: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("--> Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("--> Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("--> Test Failed: " + result.getName());
        System.out.println("Reason: " + result.getThrowable());

        try {
            TakesScreenshot ts = (TakesScreenshot) MyTestNGClass15.driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("test-output/screenshot_" + result.getName() + ".png");
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("--> Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("--> Test Failed but within success percentage: " + result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("--> Test Failed due to timeout: " + result.getName());
    }
}