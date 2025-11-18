package MySeleniumPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySeleniumClass9 {

	public static void main(String[] args) throws InterruptedException,AWTException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/upload']")));
		ele1.click();
		WebElement ele2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='file-upload']")));
		ele2.submit();
		Thread.sleep(3000);
		Robot r=new Robot();
		StringSelection ss=new StringSelection("C:\\Users\\sabya\\Documents\\Sachin_Upload");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
	}

}
