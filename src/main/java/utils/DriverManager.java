package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	private static WebDriver driver;
    
    
    public static void initializeDriver() {
        	WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    public static WebDriver getDriver() {
    	 return driver;
    }
    
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
