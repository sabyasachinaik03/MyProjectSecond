package MySeleniumPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySeleniumClass3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Checkboxes")));
		ele1.click();
		WebElement ele2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://github.com/tourdedave/the-internet']/following-sibling::div/child::*/child::*[2]/child::*[1]")));
		ele2.click();
		Thread.sleep(3000);
		System.out.println(ele2.isEnabled());
		List<WebElement> ele3=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href='https://github.com/tourdedave/the-internet']/following-sibling::div/child::*/child::*[2]/child::input")));
		for(WebElement wel:ele3) {
			wel.click();
			Thread.sleep(3000);
		}
		
	}

}
