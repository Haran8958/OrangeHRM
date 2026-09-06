package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.PIMPage;
import utils.ConfigReader;

public class PIMPageTest extends BaseClass{
	
	@Test
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
