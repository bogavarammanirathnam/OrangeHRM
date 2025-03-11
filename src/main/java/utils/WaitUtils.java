package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	private WebDriver driver;
	private WebDriverWait wait;

	public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Default wait time
    }
	
	public void setWaitTimeout(int timeoutInSeconds) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }
	
	public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
	
	public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
	
	public WebElement waitForPresenceOfElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
	
	public boolean waitForTextToBePresent(By locator, String text) {
	        return wait.until(ExpectedConditions.textToBe(locator, text));
	 }
	
	public boolean waitForPageTitle(String title) {
        return wait.until(ExpectedConditions.titleContains(title));
    }
	
	 public WebElement fluentWait(By locator, int timeoutInSeconds, int pollingInMillis) {
	        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
	                .pollingEvery(Duration.ofMillis(pollingInMillis))
	                .ignoring(NoSuchElementException.class);

	        return fluentWait.until(driver -> driver.findElement(locator));
	    }
}
