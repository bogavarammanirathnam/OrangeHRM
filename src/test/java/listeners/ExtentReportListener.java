package listeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.DriverManager;
import utils.ScreenshotUtils;

public class ExtentReportListener implements ITestListener {

	private static ExtentReports extent;
    private ExtentTest test;
    private WebDriver driver;
    private ScreenshotUtils screenshotUtils;
    
 // Constructor to receive WebDriver instance
    public ExtentReportListener() {
        
    }
    
    @Override
    public void onStart(ITestContext context) {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/extent-report.html");
        extent.attachReporter(spark);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        this.driver = DriverManager.getDriver(); // Get the driver from DriverManager
        this.screenshotUtils = new ScreenshotUtils(driver); // Initialize ScreenshotUtils
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable());
        
     // Capture screenshot using ScreenshotUtils
        screenshotUtils.captureScreenshot(result.getMethod().getMethodName());

        // Attach screenshot to report (if needed)
        String screenshotPath =  "./screenshots/" + result.getMethod().getMethodName() + "_" 
                + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".png"; // Construct the file path
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
