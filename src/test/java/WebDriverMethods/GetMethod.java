package WebDriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetMethod {
	
	public static void main(String args[]) {
		
		WebDriverManager.chromedriver().reset();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		//open website in browser though the link so we use get() method
		driver.get("https://www.facebook.com/");
	}

}
