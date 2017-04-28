package pom_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class AccPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//label[@class = 'darken']")
	private WebElement label;
	
	@FindBy(xpath = "//a[contains(text(), 'Log Out')]")
	private WebElement logOut;

	public AccPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("find_label")
	public String find_label() {
		wait.until(ExpectedConditions.visibilityOf(label));
		return label.getText();
	}
	
	@Step("findAndClickButton_label")
	public WebElement findAndClickButton_label() {
		wait.until(ExpectedConditions.visibilityOf(label)).click();
		return label;
	}
	
	@Step("findAndClickButton_logOut")
	public WebElement findAndClickButton_logOut() {
		wait.until(ExpectedConditions.visibilityOf(logOut)).click();
		return logOut;
	}
}