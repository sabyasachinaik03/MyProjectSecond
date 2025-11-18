package MySeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class MySeleniumClass14 {
    public static void main(String[] args) throws Exception {

    	 // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //  Create Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // 1️ Open the website
            driver.get("https://the-internet.herokuapp.com/upload");
            System.out.println("Opened website.");

            // Optional delay just to see page open
            Thread.sleep(2000);

            // 2️ Wait for Choose File button and click it
            WebElement chooseFileButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("file-upload"))
            );
            chooseFileButton.click();
            System.out.println("Clicked on Choose File button. Popup should appear now.");

            // Wait for popup to show
            Thread.sleep(2000);

            // 3️ Use Robot class to handle popup
            uploadFileUsingRobot("C:\\Users\\sabya\\Documents\\Postman1.txt");
            System.out.println("File path entered using Robot.");

            // Wait to let the file name appear beside button
            Thread.sleep(2000);

            // 4️ Wait until Upload button is clickable
            WebElement uploadButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("file-submit"))
            );
            uploadButton.click();
            System.out.println("Clicked on Upload button.");

            // 5️ Wait for success message
            WebElement successMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.tagName("h3"))
            );
            System.out.println("Upload Message: " + successMessage.getText());

            // Optional delay to view final state
            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("Test Failed: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }

    // Helper Method for Robot Upload
    public static void uploadFileUsingRobot(String filePath) throws Exception {
        // Copy the file path to clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Robot robot = new Robot();

        // Small delay before pasting
        Thread.sleep(1000);

        // Paste (Ctrl + V)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Delay before pressing Enter
        Thread.sleep(1000);

        // Press Enter to confirm file
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Small delay for OS processing
        Thread.sleep(1000);
    	
    }    
}