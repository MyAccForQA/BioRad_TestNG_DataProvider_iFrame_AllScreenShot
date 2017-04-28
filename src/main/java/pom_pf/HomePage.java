package pom_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait wait;

	// @FindBy(id = "portalloginlink")
	// $x("//a[@class = 'loginlink' and contains(text(), 'Log In/Register')]")
	@FindBy(xpath = "//a[@class = 'loginlink' and contains(text(), 'Log In/Register')]")
	private WebElement login;

	@FindBy(xpath = "//a[contains(text(), 'USA')]")
	private WebElement countrylistheader;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findAndClickLink_Login")
	public WebElement findAndClickLink_Login() {
		wait.until(ExpectedConditions.elementToBeClickable(login)).click();

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return login;
	}

	@Step("findAndClickLink_countrylistheader")
	public WebElement findAndClickLink_USA() {
		wait.until(ExpectedConditions.elementToBeClickable(countrylistheader)).click();

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return countrylistheader;
	}
}