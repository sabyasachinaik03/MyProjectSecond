package MySeleniumPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySeleniumClass12 {

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice/");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement enter=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loop-container']/div/article/div[2]/div[1]/div[1]/p/a")));
		enter.click();
		FileInputStream fis=new FileInputStream("C:\\Users\\sabya\\Documents\\MyExcel_Selenium.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		int lastrownum=sheet.getLastRowNum();
		for (int r=1; r<=lastrownum; r++) {
			WebElement uname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));
			XSSFCell cell1=sheet.getRow(r).getCell(0);
			uname.sendKeys(cell1.toString());
			Thread.sleep(2000);
			WebElement pwd=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
			XSSFCell cell2=sheet.getRow(r).getCell(1);
			pwd.sendKeys(cell2.toString());
			Thread.sleep(2000);
			WebElement login=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submit']")));
			login.click();
			Thread.sleep(2000);
			try {
				WebElement logout=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loop-container']/div/article/div[2]/div/div/div/a")));
				logout.click();
				Thread.sleep(3000);
			}catch(Exception e) {
				WebElement fl=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='error']")));
				e.printStackTrace();
				System.out.println(fl+" Sachin loves Pratikshya");
			}
		}
		wb.close();
		fis.close();
		driver.close();
	}

}
