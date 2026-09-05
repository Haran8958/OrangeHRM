package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.LoginPage;
import pages.PIMPage;

public class LoginPageTest extends BaseClass{
	
	@Test
	public void verifyAddEmployeeWithValidDetails() {
		
		// Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        // Navigate to PIM
        loginPage.clickPIM();

        // Add Employee
        PIMPage pimPage = new PIMPage(driver);

        pimPage.clickbtnAdd();

        pimPage.enterFirstName("Michael");
        pimPage.enterMiddleName("B");
        pimPage.enterLastName("Jordon");

        String employeeId = pimPage.getEmpID();
        System.out.println("Employee ID: " + employeeId);

        pimPage.clickbtnSave();

        // Validations
        Assert.assertEquals(pimPage.getPerDet(), "Personal Details", "Personal Details page is not displayed");

        Assert.assertEquals(pimPage.getEmpName(), "Michael Jordon", "Employee name is incorrect");
		
		
		
	}
	
}
