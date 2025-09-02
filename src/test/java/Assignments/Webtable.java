package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {

	public static void main(String[] args) {
		
		//Use WebDriverManager to setup ChromeDriver.
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, null)
		
		driver.get("https://datatables.net/");
		
		// Use XPath to find all names of employees whose Office is New York
		List<WebElement> nyEmployee= driver.findElements(By.xpath("//table[@id=\"example\"]/tbody/tr[td[text()='New York']]/td[1]"));
		
		for(WebElement employee:nyEmployee)
		{
			System.out.println(employee.getText());
		}
		
		//close the browswer
		driver.quit();
		
	}

}
//Set the path of local file and store it in file veriable s2