package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public NavigationPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Admin']")
	private WebElement adminButton;
	
	@FindBy(xpath="//span[text()='PIM']")
	private WebElement pIMButton;
	
	@FindBy(xpath="//span[text()='Leave']")
	private WebElement leaveButton;
	
	@FindBy(xpath="//span[text()='Time']")
	private WebElement timeButton;
	
	@FindBy(xpath="//span[text()='Recruitment']")
	private WebElement recruitmentButton;
	
	@FindBy(xpath="//span[text()='My Info']")
	private WebElement myinfoButton;
	
	@FindBy(xpath="//span[text()='Performance']")
	private WebElement performanceButton;
	
	@FindBy(xpath="//span[text()='Dashboard']")
	private WebElement dashBoardButton;
	
	@FindBy(xpath="//span[text()='Directory']")
	private WebElement directoryButton;
	
	@FindBy(xpath="//span[text()='Maintenance']")
	private WebElement maintenanceButton;
	
	@FindBy(xpath="//span[text()='Claim']")
	private WebElement claimButton;
	
	public void clickPIMButton() {
		getpIMButton().click();
	}

	public WebElement getAdminButton() {
		return adminButton;
	}

	public WebElement getpIMButton() {
		return pIMButton;
	}

	public WebElement getLeaveButton() {
		return leaveButton;
	}

	public WebElement getTimeButton() {
		return timeButton;
	}

	public WebElement getRecruitmentButton() {
		return recruitmentButton;
	}

	public WebElement getMyinfoButton() {
		return myinfoButton;
	}

	public WebElement getPerformanceButton() {
		return performanceButton;
	}

	public WebElement getDashBoardButton() {
		return dashBoardButton;
	}

	public WebElement getDirectoryButton() {
		return directoryButton;
	}

	public WebElement getMaintenanceButton() {
		return maintenanceButton;
	}

	public WebElement getClaimButton() {
		return claimButton;
	}
	
	
	
}
