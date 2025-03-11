package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	private WebDriver driver;

	public ScreenshotUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void captureScreenshot(String methodName) {

		try {
			// Ensure the browser is in focus
			focusBrowser();

			String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

			String fileName = methodName + "_" + timestamp + ".png";

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File destination = new File("./screenshots/" + fileName);

			FileUtils.copyFile(screenshot, destination);
			System.out.println("Screenshot saved: " + destination.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Failed to save screenshot: " + e.getMessage());
		}
	}

	private void focusBrowser() {
		try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.err.println("Failed to bring the browser to the foreground: " + e.getMessage());
        }
	}
}
