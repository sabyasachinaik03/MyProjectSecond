package MyTestNGPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyTestNGClass18 {
    WebDriver driver;
    WebDriverWait wait;
    MyTestNGClass18(WebDriver driver){
    	this.driver=driver;
    	this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    	PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//*[@id='loop-container']/div/article/div[2]/div[1]/div[1]/p/a")
    WebElement login;
    @FindBy(xpath="//*[@id='username']")
    WebElement username;
    @FindBy(xpath="//*[@id='password']")
    WebElement pwd;
    @FindBy(xpath="//*[@id='submit']")
    WebElement submit;
    @FindBy(xpath="//*[@id='loop-container']/div/article/div[2]/div/div/div/a")
    WebElement logout;
    public void clickLogin() {
    	wait.until(ExpectedConditions.visibilityOf(login)).click();
    }
    public void enterUsername(String username_data) {
    	wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(username_data);
    }
    public void enterPassword(String pwd_data) {
    	wait.until(ExpectedConditions.visibilityOf(pwd)).sendKeys(pwd_data);
    }
    public void clickSubmit() {
    	wait.until(ExpectedConditions.visibilityOf(submit)).click();
    }
    public void clickLogout() {
    	wait.until(ExpectedConditions.visibilityOf(logout)).click();
    }
}