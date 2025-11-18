package MySeleniumPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySeleniumClass7 {

	public static void main(String[] args) {

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Create WebDriverWait (explicit wait)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Open the actual website
            driver.get("https://the-internet.herokuapp.com/upload");

            // Wait until the file input is visible
            WebElement uploadInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("file-upload"))
            );

            // Provide the full file path
            uploadInput.sendKeys("C:\\Users\\sabya\\Documents\\Postman1.txt");

            // Wait until the upload button is clickable
            WebElement uploadButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("file-submit"))
            );
            uploadButton.click();

            // Wait for the success message to appear
            WebElement successMsg = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.tagName("h3"))
            );

            System.out.println("Upload Message: " + successMsg.getText());

        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        }
	}  
        
}
