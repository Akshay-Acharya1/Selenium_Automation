package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpathbytext {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		//xpath by attribute
		// Syntax: //Tagname[@AttributeName="Attributevalue"]
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("Akshay");
		driver.findElement(By.xpath("//input[@id=\"pass\"]")).sendKeys("Akshay@pass");
		
		Thread.sleep(3000);
		
		//xpath by text
		// Syntax: //Tagname[text()="text value"]
		//driver.findElement(By.xpath("//Tagname[text()='text value']"))
		driver.findElement(By.xpath("//button[text()=\"Log in\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Forgotten password?\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Create new account\"]")).click();
		driver.close();

	}

}
