package MyTestNGPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class MyTestNGClass6 {
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
  @AfterTest
  public void at() {
	  driver.close();
  }
}
