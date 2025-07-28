package Testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {

	LoginPage lp;

	@BeforeMethod
	public void setupLoginPageObjects() {
		lp = new LoginPage(driver);
	}

	@Test
	public void verifyCorrectCredLogin() {
		logger.info("*** Verifying test case: verityCorrectCredLogin ***");

		lp.refreshPage();
		lp.setEmail(p.getProperty("adminEmail"));
		lp.setPassword(p.getProperty("adminPassword"));
		lp.clickLogin();

		wait.until(ExpectedConditions.urlToBe(p.getProperty("dashboardUrl")));
		Assert.assertEquals(driver.getCurrentUrl(), p.getProperty("dashboardUrl"), "Login failed: url mismatch.");

	}

}
