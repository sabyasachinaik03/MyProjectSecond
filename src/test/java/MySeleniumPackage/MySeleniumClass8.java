package MySeleniumPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySeleniumClass8 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice/");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement enter=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loop-container']/div/article/div[2]/div[1]/div[1]/p/a")));
		enter.click();
		WebElement ele1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));
		WebElement ele2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
		Actions act=new Actions(driver);
		act.moveToElement(ele1).click().sendKeys("Sachin").keyDown(Keys.LEFT_CONTROL).sendKeys("a").sendKeys("c").
		keyUp(Keys.LEFT_CONTROL).build().perform();
		Thread.sleep(2000);
		act.moveToElement(ele2).click().keyDown(Keys.LEFT_CONTROL).sendKeys("v").build().perform();
	}

}
