package MyTestNGPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestNGClass10 {
	
  WebDriver driver;
  WebDriverWait wait;
  
  @BeforeTest
  public void bt() throws InterruptedException {
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 wait=new WebDriverWait(driver, Duration.ofSeconds(10));
     driver.get("https://practicetestautomation.com/practice/");
     Thread.sleep(1000);
     WebElement login=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loop-container']/div/article/div[2]/div[1]/div[1]/p/a")));
	 login.click();
  }
  
  @Test
  public void function1() throws InterruptedException, IOException {
	  WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));
	  username.sendKeys("student");
	  Thread.sleep(1000);
	  WebElement pwd=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
	  pwd.sendKeys("Password123");
	  Thread.sleep(1000);
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File src=ts.getScreenshotAs(OutputType.FILE);
	  File dest=new File("test-output/screenshot1.png");
	  FileUtils.copyFile(src, dest);
	  WebElement submit=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submit']")));
	  submit.click();
	  Thread.sleep(1000);
	  WebElement logout=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loop-container']/div/article/div[2]/div/div/div/a")));
	  logout.click();
	  Thread.sleep(1000);
  }

  @Test
  public void function2() throws InterruptedException, IOException {
	   WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));
	   username.sendKeys("sachin");
	   Thread.sleep(1000);
	   WebElement pwd=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
	   pwd.sendKeys("virat");
	   Thread.sleep(1000);
	   WebElement submit=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submit']")));
	   submit.click();
	   Thread.sleep(1000);
	   try {
		  WebElement logout=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loop-container']/div/article/div[2]/div/div/div/a")));
		  logout.click();
		  Thread.sleep(1000);
	   }catch (Exception e) {
		  TakesScreenshot ts=(TakesScreenshot)driver;
		  File src=ts.getScreenshotAs(OutputType.FILE);
		  File dest=new File("test-output/screenshot2.png");
		  FileUtils.copyFile(src, dest);
		  System.out.println(e.getMessage()+" Tried to find logout but couldn't as the credentials tried to login are invalid");
	   }
   }
  
   @AfterTest
   public void at() {
	    driver.close();
   }
  
}
