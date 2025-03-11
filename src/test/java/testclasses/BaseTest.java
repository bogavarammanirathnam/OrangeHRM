package testclasses;






import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import utils.DriverManager;

@Listeners(listeners.ExtentReportListener.class)
public class BaseTest {

  
    
    @BeforeSuite
    public void setUp() {
    	DriverManager.initializeDriver();
    	System.out.println("Before Suite");
    }
    
    @AfterSuite
    public void tearDown() {
    	DriverManager.quitDriver();
    	System.out.println("After Suite");
    }
}
