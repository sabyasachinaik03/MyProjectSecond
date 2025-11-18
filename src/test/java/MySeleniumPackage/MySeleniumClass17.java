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

public class MySeleniumClass17 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String baseUrl = "https://the-internet.herokuapp.com/";
        driver.get(baseUrl + "status_codes");

        int brokenLinks = 0;

        // Get the list of all <a> tags
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());

        for (int i = 0; i < links.size(); i++) {

            // Re-locate the link each time to avoid stale element exception
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            WebElement link = allLinks.get(i);
            String linkText = link.getText();
            String hrefValue = link.getAttribute("href");

            System.out.println("\nChecking link: " + linkText);

            // Skip empty or null href
            if (hrefValue == null || hrefValue.isEmpty()) {
                System.out.println("Skipping — no href attribute found.");
                continue;
            }

            // Handle relative URLs
            if (!hrefValue.startsWith("http")) {
                hrefValue = baseUrl + hrefValue;
            }

            try {
                // Check using HttpURLConnection
                HttpURLConnection connection = (HttpURLConnection) new URL(hrefValue).openConnection();
                connection.connect();
                int statusCode = connection.getResponseCode();

                if (statusCode >= 400) {
                    brokenLinks++;
                    System.out.println(hrefValue + " ====> Broken Link (" + statusCode + ")");
                } else {
                    System.out.println(hrefValue + " ====> Valid Link (" + statusCode + ")");
                }

            } catch (IOException e) {
                System.out.println("Exception for link: " + hrefValue);
                e.printStackTrace();
            }
        }

        System.out.println("\n==============================");
        System.out.println("Total broken links: " + brokenLinks);
        System.out.println("==============================");

        driver.quit();
    }
}