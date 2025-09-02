package WindowHandle;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program3 {

	public static void main(String[] args) {
		
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 1. Store the parent window
        String parentWindow = driver.getWindowHandle();

        // 2. Click on link/button that opens new window
        driver.findElement(By.linkText("Open New Window")).click();

        // 3. Get all window handles
        Set<String> allWindows = driver.getWindowHandles();

        // 4. Switch to the new window
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                System.out.println("Switched to child window: " + driver.getTitle());
                // 5. Perform action in new window
                driver.close(); // Close child window
            }
        }

        // 6. Switch back to parent window
        driver.switchTo().window(parentWindow);
        System.out.println("Back to parent window: " + driver.getTitle());
    }
}