package Practical_Scenario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Seemore_Link {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        
        List<WebElement> link=driver.findElements(By.xpath("//div[contains(@class,\"a-cardui-footer\")]//span[text()='See more']"));
        
        System.out.println("See more Link Texts:");
        for (WebElement linktxt : link) {
            System.out.println(linktxt.getText());
        }
        
        driver.quit();

	}

}
