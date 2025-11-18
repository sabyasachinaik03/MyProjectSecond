package MyTestNGPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyTestNGClass17 {
    WebDriver driver;
    WebDriverWait wait;
    MyTestNGClass17(WebDriver driver){
    	this.driver=driver;
    	this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    By login=By.xpath("//*[@id='loop-container']/div/article/div[2]/div[1]/div[1]/p/a");
    By username=By.xpath("//*[@id='username']");
    By pwd=By.xpath("//*[@id='password']");
    By submit=By.xpath("//*[@id='submit']");
    By logout=By.xpath("//*[@id='loop-container']/div/article/div[2]/div/div/div/a");
    public void clickLogin() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(login)).click();
    }
    public void enterUsername(String username_data) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(username_data);
    }
    public void enterPassword(String pwd_data) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(pwd)).sendKeys(pwd_data);
    }
    public void clickSubmit() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(submit)).click();
    }
    public void clickLogout() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(logout)).click();
    }
}