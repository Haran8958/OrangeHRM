package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtil;

public class PIMPage {
	
private WebDriver driver;

	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	private WaitUtil waitUtil;

	public PIMPage(WebDriver driver) {
	    this.driver = driver;
	    waitUtil = new WaitUtil(driver);
	}
	
	private final By btnAdd = By.xpath("//button[text()=' Add ']");
	//private final By tabAddEmployee = By.xpath("//a[text()='Add Employee']");
	private final By txtFirstName = By.name("firstName");
	private final By txtMiddleName = By.name("middleName");
	private final By txtLastName = By.name("lastName");
	private final By txtEmpID = By.xpath("//label[text()='Employee Id']/following::div/input");
	private final By txtErorMsg = By.xpath("//label[text()='Employee Id']/following::span");
	private final By btnSave = By.xpath("//button[text()=' Save ']");
	private final By lblEmpName = By.xpath("//div[@class='orangehrm-edit-employee-name']/h6");
	private final By lblPerDet = By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/h6");
	
	public void clickbtnAdd() {
		logger.info("Clicking Add button");
		driver.findElement(btnAdd).click();
		logger.info("Add button clicked");
	}
	
	public void enterFirstName(String firstname) {
		logger.info("Entering Firstname");
		driver.findElement(txtFirstName).sendKeys(firstname);
		logger.info("Firstname Entered");
	}
	
	public void enterMiddleName(String middlename) {
		logger.info("Entering Middlename");
		driver.findElement(txtMiddleName).sendKeys(middlename);
		logger.info("Middlename Entered");
	}
	
	public void enterLastName(String lastname) {
		logger.info("Entering Lastname");
		driver.findElement(txtLastName).sendKeys(lastname);
		logger.info("Lastname Entered");
	}
	
	public String getEmpID() {
		return driver.findElement(txtEmpID).getText();
	}
	
	public String getErrorMsg() {
		return driver.findElement(txtErorMsg).getText();
	}
	public void clickbtnSave() {
		logger.info("Clicking Save button");
		driver.findElement(btnSave).click();
		logger.info("Save button clicked");
	}
	
	public String getPerDet() {
		WebElement personalDetails = driver.findElement(lblPerDet);
		WebElement element = waitUtil.waitForElementVisible(personalDetails);
		return element.getText();
	}
	
	public String getEmpName() {
		WebElement employeeName = driver.findElement(lblEmpName);
	    waitUtil.waitForElementVisible(employeeName);
	    waitUtil.waitForTextInElement(employeeName, "Michael Jordon");
	    return employeeName.getText();
	}
	
	
	
	

}
