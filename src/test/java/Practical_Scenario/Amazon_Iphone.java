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

public class Amazon_Iphone {

	public static void main(String[] args) throws InterruptedException {
		
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        searchBox.sendKeys("iPhone");
        driver.findElement(By.id("nav-search-submit-button")).click();

        // Fetch and print all iPhone product titles
        //List<WebElement> iphoneTitles = driver.findElements(By.xpath("//h2//span[contains(text(),'iPhone')]"));   or
        List<WebElement> iphoneTitles = driver.findElements(By.xpath("//h2[contains(@class, 'a-size-medium') and contains(@class, 'a-color-base')]/span"));

        System.out.println("iPhone Product Titles:");
        for (WebElement title : iphoneTitles) {
            System.out.println(title.getText());
        }

        driver.quit();

	}

}
