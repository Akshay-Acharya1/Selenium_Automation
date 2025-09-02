package Screenshots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot2 {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://kite.zerodha.com/");
		
		driver.manage().window().maximize();
		
		//to take screenshot
		
		File s1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String ImgName="Akshayy";
		//Prints the file path of the screenshot to the console
		System.out.println(s1);
		
		File s2= new File("C:\\Users\\DELL\\OneDrive\\Desktop\\SeptBarch24\\"+ImgName+".jpg");
		
		FileHandler.copy(s1, s2);
		
		

	}

}
