package MyTestNGPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyTestNGClass7 extends MyTestNGClass6{
  @BeforeMethod
  public void login() throws InterruptedException {
	  WebElement login=wait.until(ExpectedConditions.visibilityOfElementLocated
			  (By.xpath("//*[@id='loop-container']/div/article/div[2]/div[1]/div[1]/p/a")));
	  login.click();
	  Thread.sleep(3000);
  }
  @Test
  @Parameters({"puname","ppass"})
  public void function(@Optional("student") String puname, @Optional("Password123") String ppass) throws InterruptedException {
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
}
