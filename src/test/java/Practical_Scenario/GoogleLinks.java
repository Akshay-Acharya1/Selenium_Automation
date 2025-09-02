package Practical_Scenario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLinks {

	public static void main(String[] args) throws InterruptedException {
		

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Open Google
        driver.get("https://www.google.com/");

        // 2. Enter "selenium" in search bar
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@title='Search']"));
        searchBox.sendKeys("selenium");

        // 3. Wait for suggestions to appear
        Thread.sleep(3000); // You can replace this with WebDriverWait for better practice

        // 4. Get all suggestion elements
        List<WebElement> allOptions = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']//span"));

        // 5. Print total count and text of each suggestion
        System.out.println("Total Suggestions: " + allOptions.size());

        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }

        driver.quit();
    }
}


//this program all about featch all suggetions on search bar when we type "selenium" on google search


