package ListBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Listbox3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		//locate the "Create new account" buttona and click on it
		driver.findElement(By.xpath("//a[contains(text(),\"Create new account\")]")).click();
		
		Thread.sleep(6000);
		driver.findElement(By.name("firstname")).sendKeys("Akshay");
		driver.findElement(By.name("lastname")).sendKeys("Acharya");
		WebElement dayListbox = driver.findElement(By.id("day"));
		WebElement monthListbox = driver.findElement(By.id("month"));
		WebElement yearListbox = driver.findElement(By.id("year"));
		
		// selectByIndex(String value)
		// Selects an option based on the value attribute.
		Select s1=new Select(dayListbox);
		s1.selectByIndex(19);
		
		Select s2=new Select(monthListbox);
		s2.selectByIndex(2);
		
		Select s3=new Select(yearListbox);
		s3.selectByIndex(4);
		
		Thread.sleep(3000);
			
		driver.close();

	}

}
