package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import listeners.TestListener;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.PIMPage;
import utils.ConfigReader;
import utils.RetryAnalyzer;

@Listeners(TestListener.class)
public class PIMPageTest extends BaseClass{
	
	
	@Test (retryAnalyzer  = RetryAnalyzer.class)
	public void verifyAddEmployeeWithValidDetails() {
		
		// Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        // Navigate to PIM
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.clickPIM();

        // Add Employee
        PIMPage pimPage = new PIMPage(driver);

        pimPage.clickbtnAdd();

        pimPage.enterFirstName(ConfigReader.getProperty("empFirstName"));
        pimPage.enterMiddleName(ConfigReader.getProperty("empMiddleName"));
        pimPage.enterLastName(ConfigReader.getProperty("empLastName"));

        String employeeId = pimPage.getEmpID();
        System.out.println("Employee ID: " + employeeId);

        pimPage.clickbtnSave();

        // Validations
        Assert.assertEquals(pimPage.getPerDet(), "Personal Details", "Personal Details page is not displayed");

        Assert.assertEquals(pimPage.getEmpName(), ConfigReader.getProperty("empFirstName")
        		+" "+ConfigReader.getProperty("empLastName"), "Employee name is incorrect");
		
		
	}

}
