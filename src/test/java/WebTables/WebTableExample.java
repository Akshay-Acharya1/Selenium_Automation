package WebTables;

import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableExample {

    public static void main(String[] args) {

        // Step 1: Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/html_tables.asp");

        // Step 2: Locate all Company name cells (1st column in the table)
        List<WebElement> companyCells = driver.findElements(By.xpath("//table[@id='customers']//tr/td[1]"));

        // Step 3: Extract text and store in list
        List<String> companyNames = new ArrayList<>();

        for (WebElement cell : companyCells) {
            companyNames.add(cell.getText());
        }

        // Step 4: Print all company names
        System.out.println("Companies found in the table:");
        for (String name : companyNames) {
            System.out.println(name);
        }

        // Step 5: Verify if specific company exists
        String companyToFind = "Island Trading";
        if (companyNames.contains(companyToFind)) {
            System.out.println("✅ Company '" + companyToFind + "' found!");
        } else {
            System.out.println("❌ Company '" + companyToFind + "' not found!");
        }

        // Step 6: Close browser
        driver.quit();
    }
}