package MySeleniumPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySeleniumClass4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dropdown")));
		ele2.click();
		WebElement ele1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='dropdown']")));
		ele1.click();
		Select st=new Select(ele1);
		List<WebElement> wel=st.getOptions();
		for (WebElement webel: wel) {
			System.out.println(webel.getText()+" clicked");
			webel.click();
			Thread.sleep(3000);
			System.out.println(webel.isSelected());
		}
	}

}
