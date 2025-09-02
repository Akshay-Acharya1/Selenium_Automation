package AdvanceXpath;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program2 {

	public static void main(String[] args) {
		
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
        
        //self
        String text=driver.findElement(By.xpath("//a[contains(text(),'IndusInd Bank')]/self::a")).getText();
        System.out.println(text);

        //Parent
        String text1=driver.findElement(By.xpath("//a[contains(text(),'IndusInd Bank')]/parent::td")).getText();
        System.out.println(text1);
        
      //if u want print all child size
      //Child
      List<WebElement> child=driver.findElements(By.xpath("//a[contains(text(),'IndusInd Bank')]/../../child::td")); 
      System.out.println(child.size());
	}

}
