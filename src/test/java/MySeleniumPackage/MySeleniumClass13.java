package MySeleniumPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySeleniumClass13 {

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice/");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement enter=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loop-container']/div/article/div[2]/div[1]/div[1]/p/a")));
		enter.click();
		FileInputStream fis=new FileInputStream("C:\\Users\\sabya\\Documents\\Sachinprop.properties");
		Properties p=new Properties();
		p.load(fis);
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("username"));
		System.out.println(p.getProperty("password"));
	}

}
