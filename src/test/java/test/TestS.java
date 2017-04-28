package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom_pf.AccPage;
import pom_pf.HomePage;
import pom_pf.LoginPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

@Title("TestS_Start")
@Description("Description")
public class TestS extends Test_BeforeAndAfter {

	// #1
	@Title("test_HomePage")
	@Test(groups = { "ff", "ok" })
	public void test_HomePage() {

		// ????????????????????????
		String exp = "Bio-Rad | Products for Life Science Research & Clinical Diagnostics";
		// ????????????????????????
		try {
			String act = driver.getTitle();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePage - " + exp);
		}
	}

	// #2
	@Title("test_HomePageToGoLogin")
	@Test(groups = { "ff", "ok" })
	public void test_HomePageToGoLogin() {

		boolean exp = true;
		try {
			HomePage homePage = new HomePage(driver, wait);
			homePage.findAndClickLink_USA();
			homePage.findAndClickLink_Login();

			LoginPage loginPF = new LoginPage(driver, wait);

			loginPF.findAndChange_iFrame();

			boolean act = loginPF.findButton_Login_isDisplayed();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoLogin " + exp);
		}
	}

	@DataProvider(name = "InvalidEmail")
	public static String[][] invalidEmail() {
		String[][] str = {
				{ "qwe", "qweasdzxc",
						"Invalid user name or password. Please try again. See login help for assistance." },
				{ "qwe@", "qweasdzxc",
						"Invalid user name or password. Please try again. See login help for assistance." },
				{ "qwe@asd", "qweasdzxc",
						"Invalid user name or password. Please try again. See login help for assistance." },
				{ "qwe@asd.", "qweasdzxc",
						"Invalid user name or password. Please try again. See login help for assistance." },
				{ "qwe@asd.c", "qweasdzxc",
						"Invalid user name or password. Please try again. See login help for assistance." },
				{ "qwe@.com", "qweasdzxc",
						"Invalid user name or password. Please try again. See login help for assistance." },
				{ "qweasdzxc@qaz.com", "qweasdzxc",
						"Invalid user name or password. Please try again. See login help for assistance." },
				{ "qweasd@qazwsx.com", "qweasdzxc",
						"Invalid user name or password. Please try again. See login help for assistance." },
				{ "qwe@qazwsxedc.com", "qweasdzxc",
						"Invalid user name or password. Please try again. See login help for assistance." },
				{ "qwe@qwe.com", "qweasdzxc",
						"Invalid user name or password. Please try again. See login help for assistance." } };
		return str;
	}

	// #3
	@Title("test_HomePageToGoLogin_InvalidEmail_ErrorValid")
	@Test(groups = { "ff", "ok" }, dataProvider = "InvalidEmail")
	public void test_HomePageToGoLogin_InvalidEmail_ErrorValid(String email, String pass, String must) {

		String exp = must;
		try {
			HomePage homePage = new HomePage(driver, wait);
			homePage.findAndClickLink_USA();
			homePage.findAndClickLink_Login();

			LoginPage loginPF = new LoginPage(driver, wait);

			loginPF.findAndChange_iFrame();

			loginPF.findAndFillInField_loginname(email);
			loginPF.findAndFillInField_loginpass(pass);
			loginPF.findAndClickButton_Login();

			String act = loginPF.find_InvalidEmail_Message();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoLogin_InvalidEmail_ErrorValid - " + email + ":" + pass + " = " + exp);
		}
	}

	// #4
	@Title("test_HomePageToGoAcc")
	@Test(groups = { "ff", "ok" })
	public void test_HomePageToGoAcc() {

		String email = "cufaza@envy17.com";
		String pass = "Zaq12wsx";

		String exp = email;
		try {
			HomePage homePage = new HomePage(driver, wait);
			homePage.findAndClickLink_USA();
			homePage.findAndClickLink_Login();

			LoginPage loginPF = new LoginPage(driver, wait);

			loginPF.findAndChange_iFrame();

			loginPF.findAndFillInField_loginname(email);
			loginPF.findAndFillInField_loginpass(pass);
			loginPF.findAndClickButton_Login();

			loginPF.findAndReturn_maneFrame();

			AccPage accPage = new AccPage(driver, wait);

			String act = accPage.find_label();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoAcc - " + email + ":" + pass + " = " + exp);
		}
	}
}