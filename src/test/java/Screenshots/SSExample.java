package Screenshots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSExample {

	public static void main(String[] args) throws IOException {


		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://kite.zerodha.com/");
		
		File s1= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println(s1);
		
		String Str= "ApurvaA";
		File s2= new File("C:\\Users\\DELL\\OneDrive\\Desktop\\SeptBarch24\\"+Str+".jpg");
		
		FileHandler.copy(s1,s2);
		
		driver.close();
	
	}
	
}