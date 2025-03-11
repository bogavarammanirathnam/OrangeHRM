package testclasses;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utils.DriverManager;

public class LoginTest {

	WebDriver driver;
	LoginPage loginPage;
	
//	@BeforeClass
//	public void setup() {
//		WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}
	
	@Test
	public void loginTest() {
		driver = DriverManager.getDriver();
		
		loginPage = new LoginPage(driver);
		loginPage.enterLoginCredentials();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals("OrangeHRM",title);
	}
	
//	@AfterClass
//	public void terminate() {
//		driver.quit();
//	}
}
