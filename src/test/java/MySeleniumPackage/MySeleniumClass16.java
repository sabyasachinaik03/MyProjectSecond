package MySeleniumPackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySeleniumClass16 {

	public static void main(String[] args) throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/status_codes");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> stcodes=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("a")));
		int brokenLinks=0;
		for (WebElement elm: stcodes) {
			System.out.println(elm.getText());
			String hrefAttValue=elm.getAttribute("href");
			if (hrefAttValue==null || hrefAttValue.isEmpty()){
				System.out.println("Can't check links as links are not clickable");
			}
			try {
				URL url=new URL(hrefAttValue);
				HttpURLConnection htc=(HttpURLConnection)url.openConnection();
				htc.connect();
				if (htc.getResponseCode()>=400) {
					brokenLinks++;
					System.out.println(hrefAttValue+"=====>Broken Link");
				}else {
					System.out.println(hrefAttValue+"=====>Not a Broken Link");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Number of broken links: "+brokenLinks);
	}

}






