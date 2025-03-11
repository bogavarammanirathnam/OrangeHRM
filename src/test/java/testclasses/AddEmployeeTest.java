package testclasses;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.NavigationPage;
import pages.PIM.AddEmployee;
import pages.PIM.PIMPage;
import utils.DriverManager;
import utils.WaitUtils;

public class AddEmployeeTest extends BaseTest {

	WebDriver driver;
	WaitUtils waitUtils;
	NavigationPage navigationPage;
	PIMPage pimpage;
	AddEmployee addEmployee;
	LoginPage loginpage;

//	@BeforeClass
//	public void setup() {
//		WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}

	@Test(dependsOnMethods = { "testclasses.LoginTest.loginTest" })
	public void addEmployeeTest() {
		driver = DriverManager.getDriver();

		// driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		loginpage = new LoginPage(driver);
//		loginpage.enterLoginCredentials();

		navigationPage = new NavigationPage(driver);
		navigationPage.clickPIMButton();
		waitUtils = new WaitUtils(driver);
		waitUtils.setWaitTimeout(10);
		waitUtils.waitForElementToBeVisible(By.xpath("//span[text()='PIM']"));
		// wait.until(ExpectedConditions.visibilityOf(navigationPage.getpIMButton()));

		pimpage = new PIMPage(driver);
		pimpage.clickAddEmployee();

		// driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");

		addEmployee = new AddEmployee(driver);
		addEmployee.enterEmployeeDetails();

		Set<String> set = driver.getWindowHandles();
		System.out.println(set);
	}

//	@AfterClass
//	public void terminate() {
//		driver.quit();
//	}
}
