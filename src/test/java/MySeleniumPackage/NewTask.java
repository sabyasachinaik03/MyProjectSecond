package MySeleniumPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewTask {

	public static void main(String[] args) throws InterruptedException {
         WebDriver driver=new ChromeDriver();
         driver.get("https://emilo-task.vercel.app/");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
         WebElement email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/form/input[1]")));
         email.sendKeys("sac.naik@gmail.com");
         Thread.sleep(1000);
         WebElement pwd=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/form/input[2]")));
	     pwd.sendKeys("Sac@1Path");
	     Thread.sleep(1000);
	     WebElement login=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/div[2]/form/button")));
	     login.click();
	     Thread.sleep(1000);
	     WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/main/section/section/div[1]/div[1]/textarea")));
	     text.sendKeys("Feeling Ecstatic today");
	     Thread.sleep(1000);
	     WebElement pic=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div/main/section/section/div[1]/div[2]/div[1]/input")));
	     pic.sendKeys("C:\\Users\\sabya\\Downloads\\happy.jpg");
	     Thread.sleep(1000);
	}

}
