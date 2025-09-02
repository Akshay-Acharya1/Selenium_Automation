package Screenshots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot1 {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.youtube.com/");
		
		driver.manage().window().maximize();
		
		// to take the screenshot   
		File s1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  //file ke object me screenshot store krte hai
		System.out.println(s1);
		
		//Save Screenshot to Local File
		
		//Creates a new File object s2 with the specified path. (uss object me path store krte hai)
		File s2= new File("C:\\Users\\DELL\\OneDrive\\Desktop\\SeptBarch24\\Test.png");
		
		//Copies the screenshot from s1 to the location specified by s2 (Local file madhe because local cha path dilay)
		FileHandler.copy(s1, s2);
		
		driver.close();

	}

}
