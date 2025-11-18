package MySeleniumPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.SearchContext;

public class MySeleniumClass18 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/shadowdom");
		SearchContext shadow=driver.findElement(By.cssSelector("my-paragraph")).getShadowRoot();
		WebElement wel=wait.until(ExpectedConditions.visibilityOf(shadow.findElement(By.cssSelector("p > slot"))));
		System.out.println(wel.getAttribute("name"));
		driver.quit();
	}

}
