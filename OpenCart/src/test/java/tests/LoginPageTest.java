package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.LoginPage;
import pages.PIMPage;

public class LoginPageTest extends BaseClass{
	
	@Test
	public void verifyLoginPageTest() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		
		lp.login();
		lp.clickPIM();
		
		PIMPage pp = new PIMPage(driver);
		
		pp.clickbtnAdd();
		pp.enterFirstName("Michael");
		pp.enterMiddleName("B");
		pp.enterLastName("Jordon");
		System.out.println("EMP ID: "+pp.getEmpID());
		pp.clickbtnSave();
		Thread.sleep(10000);
		Assert.assertEquals(pp.getPerDet(), "Personal Details", "Person Details not displayed");
		Assert.assertEquals(pp.getEmpName(), "Michael Jordon");
		
		
		
	}
	
	
	
	

}
