package WindowHandle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program1 {

	public static void main(String[] args) {
		
		//Step 1
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		
		//getWindowHandle
		String WindID=driver.getWindowHandle();
		
		System.out.println(WindID);
		//97DA28855F35D2E25AB6449BB2B07942
		//F1ED62C4BE2C061D2D527C0ECFA83662

	}

}
