package pom_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//iframe[@id = 'loginFrame']")
	private WebElement iframe;

	@FindBy(id = "loginname")
	private WebElement loginname;

	@FindBy(id = "loginpass")
	private WebElement loginpass;

	@FindBy(id = "loginbutton")
	private WebElement loginbutton;

	@FindBy(id = "forgotpoploginforgotusername")
	private WebElement invalid;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findAndChange_iFrame")
	public WebElement findAndChange_iFrame() {
		wait.until(ExpectedConditions.visibilityOf(iframe));
		driver.switchTo().frame(iframe);
		return iframe;
	}

	@Step("findAndReturn_maneFrame")
	public WebElement findAndReturn_maneFrame() {
		wait.until(ExpectedConditions.visibilityOf(iframe));
		driver.switchTo().frame(0);
		return iframe;
	}

	@Step("findAndFillInField_loginname with user name - [{0}]")
	public WebElement findAndFillInField_loginname(String st) {
		wait.until(ExpectedConditions.visibilityOf(loginname)).clear();
		loginname.sendKeys(st);
		return loginname;
	}

	@Step("findAndFillInField_loginpass with password - [{0}]")
	public WebElement findAndFillInField_loginpass(String st) {
		wait.until(ExpectedConditions.visibilityOf(loginpass)).clear();
		loginpass.sendKeys(st);
		return loginpass;
	}

	@Step("findButton_Login_isEnabled - return boolean")
	public boolean findButton_Login_isEnabled() {
		return wait.until(ExpectedConditions.visibilityOf(loginbutton)).isEnabled();
	}

	@Step("findButton_Login_isDisplayed - return boolean")
	public boolean findButton_Login_isDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(loginbutton)).isDisplayed();
	}

	@Step("findAndClickButton_Login")
	public WebElement findAndClickButton_Login() {
		wait.until(ExpectedConditions.visibilityOf(loginbutton)).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return loginbutton;
	}

	@Step("find_InvalidEmail")
	public WebElement find_InvalidEmail() {
		wait.until(ExpectedConditions.visibilityOf(invalid));
		return invalid;
	}

	@Step("find_InvalidEmail_Message")
	public String find_InvalidEmail_Message() {
		wait.until(ExpectedConditions.visibilityOf(invalid));
		return invalid.getText();
	}
}