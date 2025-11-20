package MySeleniumPackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySeleniumClass1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement abbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("A/B Testing")));
		abbutton.click();
		String whparent=driver.getWindowHandle();
		System.out.println(whparent);
		System.out.println();
		WebElement esbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Elemental Selenium")));
		esbutton.click();
		Thread.sleep(3000);
		Set<String> windhandles=driver.getWindowHandles();
		System.out.println(windhandles);
		List<String> whandles=new ArrayList<String>(windhandles);
		for (int i=0; i<whandles.size(); i++) {
			if(whandles.get(i)!=whparent) {
				driver.switchTo().window(whparent);
			}
		}
		System.out.println("Parent window reached...");
		System.out.println("Trying merge conflict of Github");
	}

}
