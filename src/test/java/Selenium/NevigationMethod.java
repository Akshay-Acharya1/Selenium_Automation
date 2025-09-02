package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NevigationMethod {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.navigate().to("https://www.facebook.com/");
		driver.manage().window().maximize();
		String Title = driver.getTitle();
		System.out.println(Title);
		driver.navigate().to("https://www.amazon.in/");
		String Title2 = driver.getTitle();
		System.out.println(Title2);
		Thread.sleep(2000);
		driver.navigate().back(); //Facbook
		Thread.sleep(2000);
		driver.navigate().forward(); //Amazon
		Thread.sleep(2000);
		driver.navigate().refresh(); //Refresh
		Thread.sleep(2000);
		driver.quit();

	}

}
