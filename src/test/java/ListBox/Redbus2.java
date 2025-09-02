package ListBox;

import java.util.List;
import java.util.concurrent.TimeUnit;
//in another way ()
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Redbus2 {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        driver.get("https://www.redbus.in/");
        
        driver.findElement(By.id("src")).sendKeys("Mumbai");
        Thread.sleep(2000);
        List<WebElement> List1 = driver.findElements(By.xpath("//li[@class='autoFill']/descendant::span"));
        System.out.println(List1.size());
        
        for (WebElement element : List1) {
            String s1 = element.getText();
            System.out.println(s1);
            
            if (s1.contains("Kurla")) {
                element.click();
                break;
            }
        }
        
        driver.findElement(By.id("dest")).sendKeys("Pune");
        Thread.sleep(2000);
        List<WebElement> List2 = driver.findElements(By.xpath("//li[@class='autoFill']/descendant::span"));
        
        for (WebElement element : List2) {
            String s2 = element.getText();
            System.out.println(s2);
            
            if (s2.contains("Wakad")) {
                element.click();
                break;
            }
        }
        
        driver.findElement(By.xpath("//div[@class='labelCalendarContainer']")).click();
        driver.findElement(By.xpath("//span[text()='14']")).click();
        driver.findElement(By.id("search_button")).click();
        
        driver.close();
    }
}
