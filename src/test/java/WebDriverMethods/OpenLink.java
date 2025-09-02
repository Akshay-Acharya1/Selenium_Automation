package WebDriverMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OpenLink {
    public static void main(String[] args) {
        // 1. Initialize WebDriver with basic options
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        try {
            // 2. Set up explicit wait (15 seconds maximum)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            
            // 3. Navigate to Google
            driver.get("https://www.google.com");
            
            // 4. Wait for search box to be present and interact
            WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
            searchBox.sendKeys("QA automation");
            searchBox.sendKeys(Keys.RETURN);
            
            // 5. Wait for search results container
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#search")));
            
            // 6. Get all result blocks first
            List<WebElement> resultBlocks = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.g"))
            );
            
            // 7. Extract links from each block
            List<String> validLinks = new ArrayList<>();
            for (WebElement block : resultBlocks) {
                try {
                    // Wait for link to be present within each block
                    WebElement link = block.findElement(By.cssSelector("a"));
                    String href = link.getAttribute("href");
                    
                    if (href != null && !href.contains("google.com") && href.startsWith("http")) {
                        validLinks.add(href);
                        System.out.println(href);
                    }
                } catch (NoSuchElementException | StaleElementReferenceException e) {
                    // Skip if element not found or became stale
                    continue;
                }
            }
            
            System.out.println("\nTotal valid links found: " + validLinks.size());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
 