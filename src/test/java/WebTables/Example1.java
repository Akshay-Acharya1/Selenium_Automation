package WebTables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		// How many rows
		
        int rows= driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
		System.out.println(rows);
		
		/* Another way to find xpath of rows 
		 * if you size method from here then the return type of findElements is List<WebElement> 
		 * List<WebElement> rows= driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr"));
		 * System.out.println(rows);
		 */ 

		//how many columns
		int col= driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr/th")).size();
		System.out.println(col);
		
		//Retrives the specific rows and column data "Austrila data retrive karaycha"
		String text= driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[4]/td[3]")).getText();
		System.out.println(text);
	}

}


/*
   //table[@id="customers"]	     - Find the <table> element with id="customers"
 
   /tbody	                     - Go inside its <tbody> section
   /tr	                         - Select all <tr> (table rows) inside <tbody>
   /th	                         - Then select the <th> (table header cells) inside those rows     
                                                                                                        */
