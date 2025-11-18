package MyTestNGPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyTestNGClass8 {
	
  WebDriver driver;
  WebDriverWait wait;
  
  @BeforeTest
  public void bt() throws InterruptedException {
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 wait=new WebDriverWait(driver, Duration.ofSeconds(10));
     driver.get("https://practicetestautomation.com/practice/");
     Thread.sleep(3000);
  }
  @BeforeMethod
  public void login() throws InterruptedException {
	  WebElement login=wait.until(ExpectedConditions.visibilityOfElementLocated
			  (By.xpath("//*[@id='loop-container']/div/article/div[2]/div[1]/div[1]/p/a")));
	  login.click();
	  Thread.sleep(3000);
  }
  @Test
  @Parameters({"puname","ppass"})
  public void function(String puname, String ppass) throws InterruptedException {
	  WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));
	  username.sendKeys(puname);
	  Thread.sleep(3000);
	  WebElement pwd=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
	  pwd.sendKeys(ppass);
	  Thread.sleep(3000);
	  WebElement submit=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submit']")));
	  submit.click();
	  Thread.sleep(3000);
  }
  @AfterMethod
  public void logout() throws InterruptedException {
	  WebElement logout=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loop-container']/div/article/div[2]/div/div/div/a")));
	  logout.click();
	  Thread.sleep(3000);
  }	  
  @AfterTest
  public void at() {
	  driver.close();
  }
}
