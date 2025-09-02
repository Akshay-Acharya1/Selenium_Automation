package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetCurrentURLMethod {

	public static void main(String[] args) {
		
		String Exp_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
				// Step 1
				WebDriverManager.chromedriver().setup();
				// Step 2
				WebDriver driver = new ChromeDriver();
				// Step 3
				driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				driver.manage().window().maximize();
				String URL = driver.getCurrentUrl();
				if (Exp_URL.equals(URL)) {
				System.out.println("Correct URL");
				}
				else {
					System.out.println("Incorrect URL");
					}
					driver.close();
	}
}

