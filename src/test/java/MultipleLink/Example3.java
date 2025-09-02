package MultipleLink;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example3 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions option=new ChromeOptions();
		
		option.addArguments("--headless");
		
		WebDriver driver= new ChromeDriver(option);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);      
		
		driver.get("http://www.deadlinkcity.com/");
		
		// find all links and images
		
		List<WebElement> Links= driver.findElements(By.tagName("a"));
		
		Links.addAll(driver.findElements(By.tagName("img")));             // add images in link  
		
		System.out.println("Total links including images "+Links.size());   //kitani bhi links hogi wo print hogi 
	}

}
