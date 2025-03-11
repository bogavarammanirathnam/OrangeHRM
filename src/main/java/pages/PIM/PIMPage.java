package pages.PIM;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

public class PIMPage {

	WebDriver driver;
	WaitUtils waitUtils;
	
	public PIMPage(WebDriver driver) {
		this.driver = driver;
		this.waitUtils = new WaitUtils(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Configuration ']")
	private WebElement configuration;
	
	@FindBy(xpath="//a[text()='Employee List ']")
	private WebElement employeeList;
	
	@FindBy(xpath="//span[text()='More ']")
	private WebElement clickMoreButton;
	
	@FindBy(xpath="(//a[text()])[2]")
	private WebElement addEmployee;
	
	@FindBy(xpath="//a[text()='Reports ']")
	private WebElement reports;

	public void clickAddEmployee() {
		if(!addEmployee.isDisplayed()) {
			getClickMoreButton().click();
			System.out.println("Clicked More Options");
			waitUtils.waitForElementToBeVisible(By.xpath("(//a[text()])[2]"));
			getAddEmployee().click();
		}
		else {
			getAddEmployee().click();
		}
	}
	
	public WebElement getClickMoreButton() {
		return clickMoreButton;
	}

	public WebElement getReports() {
		return reports;
	}

	public void setReports(WebElement reports) {
		this.reports = reports;
	}

	public WebElement getConfiguration() {
		return configuration;
	}

	public WebElement getEmployeeList() {
		return employeeList;
	}

	public WebElement getAddEmployee() {
		return addEmployee;
	}
	
	
}
