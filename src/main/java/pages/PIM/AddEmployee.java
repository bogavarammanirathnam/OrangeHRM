package pages.PIM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployee {

	WebDriver driver;
	WebDriverWait wait;

	public AddEmployee(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstname;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastname;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement employeeId;

	@FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
	private WebElement enableCreateLogin;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
	private WebElement username;

	@FindBy(xpath = "(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[1]")
	private WebElement statusEnabled;

	@FindBy(xpath = "(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[2]")
	private WebElement statusDisabled;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[4]")
	private WebElement password;

	@FindBy(xpath = "(//input[@type='password'])[2]")
	private WebElement confirmpassword;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement saveBtn;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	private WebElement cancelBtn;

	public void enterEmployeeDetails() {
		getFirstname().sendKeys("Manirathnam");
		getLastname().sendKeys("Bogavaram");
		getEmployeeId().sendKeys("5544");
		getEnableCreateLogin().click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(username));
		getUsername().sendKeys("mrathnam808");
		getStatusEnabled().click();
		getPassword().sendKeys("Manirathnam123");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(confirmpassword));
		if (getConfirmpassword().isDisplayed()) {
			getConfirmpassword().sendKeys("Manirathnam123");
		}else {
			System.out.println("Password field is not visible.");
		}
		
		getSaveBtn().click();
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getEmployeeId() {
		return employeeId;
	}

	public WebElement getEnableCreateLogin() {
		return enableCreateLogin;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getStatusEnabled() {
		return statusEnabled;
	}

	public WebElement getStatusDisabled() {
		return statusDisabled;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmpassword() {
		return confirmpassword;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

}
