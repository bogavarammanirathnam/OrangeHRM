package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.DriverManager;
import utils.ScreenshotUtils;

public class ScreenshotListener implements ITestListener {



	@Override
	public void onTestFailure(ITestResult result) {
		
		 WebDriver driver = DriverManager.getDriver();
		 
		 String methodName = result.getMethod().getMethodName();
		
		// Capture screenshot
	        if (driver != null) {
	            ScreenshotUtils screenshotUtils = new ScreenshotUtils(driver);
	            screenshotUtils.captureScreenshot(methodName);
	        }
	}
}
