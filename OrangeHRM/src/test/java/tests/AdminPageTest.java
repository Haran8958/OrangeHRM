package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import pages.AdminPage;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.ConfigReader;

public class AdminPageTest extends BaseClass {

	private static final Logger logger = LogManager.getLogger(LoginPageTest.class);
	
	@Test(priority = 1)
	public void verifyAdminPage() {
		
		LoginPage loginPage = new LoginPage(driver);
		DashBoardPage dashboardPage = loginPage.validLogin(ConfigReader.getProperty("username"),
				ConfigReader.getProperty("password"));
		logger.info("Login completed successfully");
		
		dashboardPage.clickAdmin();
		logger.info("Admin Clicked successfully");
		
		AdminPage adminPage = new AdminPage(driver);
		adminPage.enterUserName("Hari");
		adminPage.enterEmployeeName("Haran");
		adminPage.selectUserRole("Admin");
		adminPage.selectStatus("Enabled");
		adminPage.clickSearchBtn();
	}
	
	
	
	
	
	
}
