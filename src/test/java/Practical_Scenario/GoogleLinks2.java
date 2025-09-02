package Practical_Scenario;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLinks2 {

	public static void main(String[] args) throws InterruptedException {
		
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

            // 1. Open Google
            driver.get("https://www.google.com/");

            driver.get("https://www.google.com");
            driver.manage().window().maximize();

            // Accept cookies if prompted (optional)
            // driver.findElement(By.id("L2AGLb")).click();

            // Search "selenium"
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("selenium");
            searchBox.submit();

            // Wait for results to load
            Thread.sleep(2000);

            // XPath to locate all result links
            List<WebElement> links = driver.findElements(By.xpath("//div[@class='yuRUbf']/a"));

            System.out.println("Total search result links: " + links.size());
            for (WebElement link : links) {
                System.out.println(link.getAttribute("href"));
            }
            Thread.sleep(2000);

            driver.quit();
        }
    }
