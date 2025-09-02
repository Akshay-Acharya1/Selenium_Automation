package ActionClassAssi;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
				
		WebDriverManager.chromedriver().setup();
		// Initialize WebDriver
		WebDriver driver= new ChromeDriver();
		// Maximize the browser window
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		
		// Set implicit wait (optional, but recommended for dynamic elements)
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		// Navigate to Amazon's homepage
		driver.get("https://www.amazon.in");
		
		//Locate the "Account & Lists" element
		WebElement AccList= driver.findElement(By.xpath("//span[contains(text(),\"Account & Lists\")]"));
		
		//create Action class object
		Actions act= new Actions(driver);
		
		// Perform mouse hover over the "Account & Lists" element
		act.moveToElement(AccList).build().perform();        //for that we use moveToElement() method

		}
	}
		

