package MySeleniumPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySeleniumClass10 {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice/");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement enter=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loop-container']/div/article/div[2]/div[1]/div[1]/p/a")));
		enter.click();
		WebElement ele1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));
		FileReader flr=new FileReader("C:\\Users\\sabya\\Documents\\MyText.txt");
		BufferedReader br=new BufferedReader(flr);
		String startline;
		while((startline=br.readLine()) != null) {
			ele1.sendKeys(startline);
		}
		br.close();
	}

}
