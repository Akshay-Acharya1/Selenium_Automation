package AlertsorPopups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Popup1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.bigbasket.com/");
		
		driver.findElement(By.xpath("//button[contains(string(),'Login/ Sign Up')]")).click();
		
		driver.findElement(By.xpath("//label[@for=\"multiform\"]")).sendKeys("AkshayAcharya@gmail.com");
		
		driver.findElement(By.xpath("//div[@class=\"absolute top-0 right-0\"]")).click();
		
		driver.close();

	}

}
