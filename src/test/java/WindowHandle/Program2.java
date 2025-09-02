package WindowHandle;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//a[string()='OrangeHRM, Inc']")).click();
		
		Thread.sleep(3000);
		
		String WinID=driver.getWindowHandle();
		// it is used to store current window id in the format of string in a variable
		
		System.out.println(WinID);
	    //prints the value of the WinID variable to the console.
		
		//2. getWindowHandles
	    Set<String> WinIDs=driver.getWindowHandles();
	    
	    //First way        //another way to iterate strig is List
	    Iterator<String> Test= WinIDs.iterator();
	    
	    String ParentWindow=Test.next();
	    String ChildWindow=Test.next();
	    
	    System.out.println(ParentWindow);
	    System.out.println(ChildWindow);
	    
	    driver.switchTo().window(ChildWindow);
	    
		driver.findElement(By.id("Form_submitForm_EmailHomePage")).sendKeys("Test@gmail.com");
		
		driver.findElement(By.id("Form_submitForm_action_request")).click();
		
		driver.close();
		
	}

}


// now error is No such element because we we perform only one window so we have to use getWindowHandles() method