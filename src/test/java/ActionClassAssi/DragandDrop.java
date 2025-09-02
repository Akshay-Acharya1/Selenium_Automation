package ActionClassAssi;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		// Navigate to the demo page
		driver.get("https://www.demo.guru99.com/test/drag_drop.html");
		
		// Initialize WebDriverWait 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//Locate these elements
		WebElement bank = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'BANK')]"))); 
		WebElement accountText = wait.until(ExpectedConditions.elementToBeClickable(By.id("bank"))); 
		WebElement value5k = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'5000')][1]"))); 
		WebElement amountText = wait.until(ExpectedConditions.elementToBeClickable(By.id("amt7")));
		
		// Create an Actions object
		Actions act= new Actions(driver);
		
		// Perform drag and drop for BANK element
		act.dragAndDrop(bank, accountText).perform();
		
		//Thread.sleep(3000);
		// Perform drag and drop for 5000 element
		act.dragAndDrop(value5k, amountText).perform();
		
		// Wait after drag and drop to ensure the changes are reflected 
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("bank"), "BANK")); 
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("amt7"), "5000"));
		
		//verification
		WebElement debitAccount = driver.findElement(By.id("t7")); 
		WebElement debitAmount = driver.findElement(By.id("amt7"));
		
        String AcText = accountText.getText();
        String AmText = amountText.getText();
		
        if (AcText.equals("BANK") && AmText.equals("5000")) {
            System.out.println("Drag and drop successful!");
        } else {
            System.out.println("Drag and drop failed.");
        }

	}

}
