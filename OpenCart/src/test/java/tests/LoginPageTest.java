package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.PIMPage;
import utils.ConfigReader;

public class LoginPageTest extends BaseClass{

	private static final Logger logger = LogManager.getLogger(LoginPageTest.class);
	LoginPage loginPage = new LoginPage(driver);

	@Test(priority = 1)
	public void verifyValidLogin() {
		logger.info("Starting valid login test");

		DashBoardPage dashboardPage = loginPage.validLogin(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));

		Assert.assertTrue(dashboardPage.isDashboardDisplayed(),"Dashboard page is not displayed after successful login");

		logger.info("Valid login test completed successfully");
	}


	@Test(priority = 2)
	public void verifyInvalidLogin() {
		logger.info("Starting invalid login test");
		
		String actualErrorMessage = loginPage.invalidLogin("InvalidUser","InvalidPassword");
		String expectedErrorMessage = "Invalid credentials";

		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
				"Incorrect error message displayed for invalid login");

		logger.info("Invalid login test completed successfully");
	}








}
