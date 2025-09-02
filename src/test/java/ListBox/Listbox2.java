package ListBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Listbox2 {

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
		
		// selectByValue(String value)
		// Selects an option based on the value attribute.
		Select s1=new Select(dayListbox);
		s1.selectByValue("20");
		
		Select s2=new Select(monthListbox);
		s2.selectByValue("3");
		
		Select s3=new Select(yearListbox);
		s3.selectByValue("1997");
		
		Thread.sleep(3000);
			
		driver.close();	

	}

}
