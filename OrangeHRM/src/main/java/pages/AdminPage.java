package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtil;

public class AdminPage {

	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(AdminPage.class);
	private WaitUtil waitUtil;

	// Constructor
	public AdminPage(WebDriver driver) {
		this.driver=driver;
		waitUtil = new WaitUtil(driver);
	}

	private final By txtUserName = By.xpath("//label[text()='Username']/following::input[contains(@class,'oxd-input')]");
	private final By txtEmployeeName = By.xpath("//label[text()='Employee Name']/following::input[contains(@placeholder,'Type for hints...')]");
	private final By ddUserRole = By.xpath("//label[text()='Status']/preceding::div[contains(text(),'-- Select --')]");
	private final By ddStatus = By.xpath("//label[text()='Status']/following::div[contains(text(),'-- Select --')]");
	private final By btnSearch = By.xpath("//button[normalize-space()='Search']");
	private final By btnReset = By.xpath("//button[normalize-space()='Reset']");
	private final By btnAdd = By.xpath("//button[normalize-space()='Add']");
	//Chevron, Disclosure Triangle, Expander/Collapse Icon, Toggle Arrow
	private final By chevron = By.xpath("//i[@class='oxd-icon bi-chevron-down']");

	//User Management Categories
	private final By userManagement = By.xpath("//span[normalize-space()='User Management']");
	private final By Users = By.xpath("//a[text()='Users']");
	
	//Jobs Categories
	private final By Job = By.xpath("//span[text()='Job ']");
	private final By jobTitles = By.xpath("//span[text()='Job Titles']");
	private final By payGrades = By.xpath("//span[text()='Pay Grades']");
	private final By employmentStatus = By.xpath("//span[text()='Employment Status']");
	private final By jobCategories = By.xpath("//span[text()='Job Categories']");
	private final By workShifts = By.xpath("//span[text()='Work Shifts']");
	
	//Organization Categories
	private final By Organization = By.xpath("//span[text()='Organization ']");
	private final By generalInformation = By.xpath("//span[text()='General Information']");
	private final By Locations = By.xpath("//span[text()='Locations']");
	private final By structure = By.xpath("//span[text()='Structure']");
	
	//Qualifications Categories
	private final By Qualifications = By.xpath("//span[text()='Qualifications ']");
	private final By skills = By.xpath("//span[text()='Skills']");
	private final By education = By.xpath("//span[text()='Education']");
	private final By licenses = By.xpath("//span[text()='Licenses']");
	private final By languages = By.xpath("//span[text()='Languages']");
	private final By memberships = By.xpath("//span[text()='Memberships']");
	

	private final By nationalities = By.xpath("//a[text()='Nationalities']");
	
	//More categories
	private final By more = By.xpath("//span[normalize-space()='More']");
	private final By corporateBranding = By.xpath("//a[normalize-space()='Corporate Branding']");
	private final By configuration = By.xpath("////a[normalize-space()='Configuration']"); 
			
	public void enterUserName(String username) {
		logger.info("Entering Username: {}", username);
		waitUtil.waitForElementVisible(txtUserName).sendKeys(username);
		logger.info("Username Entered");
	}

	public void enterEmployeeName(String employeeName) {
		logger.info("Entering Employee Name: {}", employeeName);
		waitUtil.waitForElementVisible(txtEmployeeName).sendKeys(employeeName);
		logger.info("Employee Name Entered");
	}

	public void selectUserRole(String userRole) {
		logger.info("Selecting User Role: {}", userRole);
		waitUtil.waitForElementVisible(ddUserRole).click();
	    waitUtil.waitForElementVisible(ddRoleOption(userRole)).click();
		logger.info("User Role Selected");
	}

	private By ddRoleOption(String userRole) {
		return By.xpath("//span[normalize-space()='" + userRole + "']");
	}
	
	public void selectStatus(String status) {
		logger.info("Selecting Status: {}", status);
		waitUtil.waitForElementVisible(ddStatus).click();
	    waitUtil.waitForElementVisible(ddStatusOption(status)).click();
		logger.info("Status Selected");
	}
	
	private By ddStatusOption(String status) {
		return By.xpath("//span[normalize-space()='" + status + "']");
	}
	
	public void clickSearchBtn() {
		logger.info("Clicking Search button");
		waitUtil.waitForElementClickable(btnSearch).click();
		logger.info("Search button clicked");
	}
	
	public void clickResetBtn() {
		logger.info("Clicking Reset button");
		waitUtil.waitForElementClickable(btnReset).click();
		logger.info("Reset button clicked");
	}
	
	public void clickAddBtn() {
		logger.info("Clicking Add button");
		waitUtil.waitForElementClickable(btnAdd).click();
		logger.info("Add button clicked");
	}
	
	public void clickExpandArrow() {
		logger.info("Clicking Chevron Arrow");
		waitUtil.waitForElementClickable(chevron).click();
		logger.info("Chevron Arrow clicked");
	}
	
	//User Management Categories
	public void navigateToUsers() {
		logger.info("Navigating to Users page");
		waitUtil.waitForElementClickable(userManagement).click();
		waitUtil.waitForElementClickable(Users).click();
		logger.info("Navigated to Users page");
	}
	
	//Job Categories
	public void navigateToJobTitles() {
		logger.info("Navigating to Job Titles page");
		waitUtil.waitForElementClickable(Job).click();
		waitUtil.waitForElementClickable(jobTitles).click();
		logger.info("Navigated to Job Titles page");
	}
	
	public void navigateToPayGrades() {
		logger.info("Navigating to Pay Grades page");
		waitUtil.waitForElementClickable(Job).click();
		waitUtil.waitForElementClickable(payGrades).click();
		logger.info("Navigated to Pay Grades page");
	}
	
	public void navigateToEmploymentStatus() {
		logger.info("Navigating to Employment Status page");
		waitUtil.waitForElementClickable(Job).click();
		waitUtil.waitForElementClickable(employmentStatus).click();
		logger.info("Navigated to Employment Status page");
	}
	
	public void navigateToJobCategories() {
		logger.info("Navigating to Job Categories page");
		waitUtil.waitForElementClickable(Job).click();
		waitUtil.waitForElementClickable(jobCategories).click();
		logger.info("Navigated to Job Categories page");
	}
	
	public void navigateToWorkShifts() {
		logger.info("Navigating to Work Shifts page");
		waitUtil.waitForElementClickable(Job).click();
		waitUtil.waitForElementClickable(workShifts).click();
		logger.info("Navigated to Work Shifts page");
	}
	
	//Organization Categories
	public void navigateToGeneralInformation() {
		logger.info("Navigating to General Information page");
		waitUtil.waitForElementClickable(Organization).click();
		waitUtil.waitForElementClickable(generalInformation).click();
		logger.info("Navigated to General Information page");
	}
	
	public void navigateToLocations() {
		logger.info("Navigating to Locations page");
		waitUtil.waitForElementClickable(Organization).click();
		waitUtil.waitForElementClickable(Locations).click();
		logger.info("Navigated to Locations page");
	}
	
	public void navigateToStructure() {
		logger.info("Navigating to Structure page");
		waitUtil.waitForElementClickable(Organization).click();
		waitUtil.waitForElementClickable(structure).click();
		logger.info("Navigated to Structure page");
	}
	
	//Qualifications Categories
	public void navigateToSkills() {
		logger.info("Navigating to Skills page");
		waitUtil.waitForElementClickable(Qualifications).click();
		waitUtil.waitForElementClickable(skills).click();
		logger.info("Navigated to Skills page");
	}
	
	public void navigateToEducation() {
		logger.info("Navigating to Education page");
		waitUtil.waitForElementClickable(Qualifications).click();
		waitUtil.waitForElementClickable(education).click();
		logger.info("Navigated to Education page");
	}
	
	public void navigateToLicenses() {
		logger.info("Navigating to Licenses page");
		waitUtil.waitForElementClickable(Qualifications).click();
		waitUtil.waitForElementClickable(licenses).click();
		logger.info("Navigated to Licenses page");
	}
	
	public void navigateToLanguages() {
		logger.info("Navigating to Languages page");
		waitUtil.waitForElementClickable(Qualifications).click();
		waitUtil.waitForElementClickable(languages).click();
		logger.info("Navigated to Languages page");
	}
	
	public void navigateToMemberships() {
		logger.info("Navigating to Memberships page");
		waitUtil.waitForElementClickable(Qualifications).click();
		waitUtil.waitForElementClickable(memberships).click();
		logger.info("Navigated to Memberships page");
	}
	
	//Nationalities
	public void navigateToNationalities() {
		logger.info("Navigating to Nationalities page");
		waitUtil.waitForElementClickable(nationalities).click();
		logger.info("Navigated to Nationalities page");
	}
	
	//More Categories
	public void navigateToCorporateBranding() {
		logger.info("Navigating to Corporate Branding page");
		waitUtil.waitForElementClickable(more).click();
		waitUtil.waitForElementClickable(corporateBranding).click();
		logger.info("Navigated to Corporate Branding page");
	}
	
	public void navigateToConfiguration() {
		logger.info("Navigating to Configuration page");
		waitUtil.waitForElementClickable(more).click();
		waitUtil.waitForElementClickable(configuration).click();
		logger.info("Navigated to Configuration page");
	}
	
	

}
