package ListBox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBusAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.redbus.in/");
		
		driver.findElement(By.id("src")).sendKeys("Mumbai");
		Thread.sleep(2000);
		//now je pn dropdown option yetat tyacha xpath find karaych
		//if more then one matching elements aa rahe return me (xpath find krte smay) to kaunsi method use krnege - findElements
		List<WebElement> List1= driver.findElements(By.xpath("//text[@class=\"placeHolderMainText\"]"));
		//List interface me size check krne ki kaunsi method hai- size()
		System.out.println(List1.size());
		
		//pure elemenets hame read karne hai(iterate) aur usme se ek option select krna hai then we use for loop
		for(int i=0;i<List1.size();i++)
		{
			String s1= List1.get(i).getText();     //get method is used to print all
			System.out.println(s1);   
			
			//select ke liye if condition liya
			if(s1.equals("kurla"))       //kurla waha pr(dropdown me) present hoga to select hoga
			{
				List1.get(i).click();    //uss selected element ke uper click krna hai
				break;
			}
		}
		
		driver.findElement(By.id("dest")).sendKeys("pune");
		Thread.sleep(2000);
		List<WebElement> List2= driver.findElements(By.xpath("//text[@class=\"placeHolderMainText\"]"));    //comman xpath
		
		for(int i=0;i<List2.size();i++)          //iterate all list value
		{
			String s2= List2.get(i).getText();     //get method is used to print all
			System.out.println(s2);   
			
			if(s2.equals("Wakad"))     
			{
				List2.get(i).click();  
				break;
			}
		}
		//now find xpath of date (calender icon in which having all dates)
		driver.findElement(By.xpath("//div[@class=\"labelCalendarContainer\"]")).click();
		
		//now we have to select one date
		driver.findElement(By.xpath("//span[text()='14']")).click();       //10 text me presend hai so we find that element by text xpath
		driver.findElement(By.id("search_button")).click();
		
		driver.close();


	}

}
