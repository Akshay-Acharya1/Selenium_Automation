package ListBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListBox1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		//locate the "Create new account" buttona and click on it
		driver.findElement(By.xpath("//a[contains(text(),\"Create new account\")]")).click();
		
		Thread.sleep(7000);
		driver.findElement(By.name("firstname")).sendKeys("Akshay");
		driver.findElement(By.name("lastname")).sendKeys("Acharya");
		
		//xpath of day month and year Listbox element
		WebElement dayListbox = driver.findElement(By.id("day"));
		WebElement monthListbox = driver.findElement(By.id("month"));
		WebElement yearListbox = driver.findElement(By.id("year"));
		
		//To perform List box first create Select class objects for each dropdown
		
		// Select values using selectByVisibleText
		Select s1=new Select(dayListbox);
		s1.selectByVisibleText("20");
		
		Select s2=new Select(monthListbox);
		s2.selectByVisibleText("Jan");
		
		Select s3=new Select(yearListbox);
		s3.selectByVisibleText("2024");
		
		// Select different values for Day, Month, and Year
		Select s4=new Select(dayListbox);
		s4.selectByVisibleText("21");
		
		Select s5=new Select(monthListbox);
		s5.selectByVisibleText("Mar");
		
		Select s6=new Select(yearListbox);
		s6.selectByVisibleText("2022");
		
		Thread.sleep(3000);
		
		driver.close();	
		
	}

}

//selectByVisibleText() - Selects an option based on the visible text
