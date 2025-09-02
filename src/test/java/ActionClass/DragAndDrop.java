package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		
		// Switch to iframe that contains the drag and drop elements
		WebElement iframe=driver.findElement(By.cssSelector("iframe.demo-frame"));
		driver.switchTo().frame(iframe);
		
		// Locate the source element (any <li> image to drag)
		WebElement Source= driver.findElement(By.xpath("//ul[@id=\"gallery\"]//li[2]"));
		
		// Locate the target element (trash bin)
		WebElement Destination= driver.findElement(By.id("trash"));
		
		// Perform drag and drop
		Actions a=new Actions(driver);
		a.dragAndDrop(Source,Destination).perform();
		
		//close the browser
		try { Thread.sleep(2000); } catch (InterruptedException e) {}
		driver.quit();
	}

}
