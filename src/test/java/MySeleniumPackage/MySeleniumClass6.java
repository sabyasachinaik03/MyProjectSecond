package MySeleniumPackage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySeleniumClass6 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("JavaScript Alerts")));
		ele1.click();
		WebElement ele2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='jsAlert()']")));
		ele2.click();
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(3000);
		alert.accept();
		Thread.sleep(6000);
		WebElement result=driver.findElement(By.xpath("//div[@id='page-footer']/preceding::*[1]"));
		String str=result.getText();
		if ((result.getText()).equals(str)) {
			System.out.println("Alert has been clicked");
		}else {
			System.out.println("Alert has not been clicked");
		}
		WebElement ele5=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='jsPrompt()']")));
		ele5.click();
		Alert alertprompt=wait.until(ExpectedConditions.alertIsPresent());
		alertprompt.sendKeys("Sachin typed in the alert");
		alertprompt.accept();
	}

}
