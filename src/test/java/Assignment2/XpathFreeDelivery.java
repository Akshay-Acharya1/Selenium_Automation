package Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathFreeDelivery {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/s?k=mobile&crid=1Y0TV76WJOOZ6&sprefix=mobile%2Caps%2C230");
		
		driver.findElement(By.xpath("//span[contains(text(), 'FREE delivery')] [1]"));
	}

}
