package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ConfigReader;
import utils.WaitUtil;

public class LoginPage{

	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(LoginPage.class);
	private WaitUtil waitUtil;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		waitUtil = new WaitUtil(driver);
	}

	//Locators
	private final By txtUsername = By.name("username");
	private final By txtPassword = By.name("password");
	private final By btnLogin = By.xpath("//button[normalize-space()='Login']");
	private final By lnkForgetPassword = By.xpath("//p[text()='Forgot your password? ']");
	private final By imgLogo = By.xpath("//img[@alt='company-branding']");
	private final By lblErrorMsg = By.xpath("//div[@role='alert']//p");

	// Page Actions
	public void enterUsername() {
		logger.info("Entering Username");
		//driver.findElement(txtUsername).sendKeys(ConfigReader.getProperty("username"));
		waitUtil.waitForElementVisible(txtUsername).sendKeys(ConfigReader.getProperty("username"));
		logger.info("Username Entered");
	}

	public void enterPassword() {
		logger.info("Entering Password");
		waitUtil.waitForElementVisible(txtPassword).sendKeys(ConfigReader.getProperty("password"));
		logger.info("Password Entered");
	}

	public void enterUsername(String username) { 
		logger.info("Entering Username: {}", username); 
		//driver.findElement(txtUsername).sendKeys(username);
		waitUtil .waitForElementVisible(txtUsername).sendKeys(username); 
		logger.info("Username Entered"); 
	} 

	public void enterPassword(String password) { 
		logger.info("Entering Password"); 
		waitUtil .waitForElementVisible(txtPassword).sendKeys(password); 
		logger.info("Password Entered"); 
	}

	public DashBoardPage clickLoginBtn() {
		logger.info("Clicking Login button");
		waitUtil.waitForElementClickable(btnLogin).click();
		logger.info("Login button clicked");
		return new DashBoardPage(driver);
	}

	// Login Methods
	public DashBoardPage login() {
		enterUsername();
		enterPassword();
		clickLoginBtn();
		return new DashBoardPage(driver);
	}

	public DashBoardPage validLogin(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginBtn();
		return new DashBoardPage(driver);
	}

	public String invalidLogin(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginBtn();
		return getErrorMessage();
	}

	// Page Information
	public String getTitle() {
		String title = driver.getTitle();
		logger.info("Page title: {}", title);
		return title;
	}

	public String getURL() {
		String url = driver.getCurrentUrl();
		logger.info("Current URL: {}", url);
		return url;
	}

	public String getErrorMessage() {
		String errorMsg = waitUtil .waitForElementVisible(lblErrorMsg).getText();
		logger.info("Error Message: {}", errorMsg);
		return errorMsg;
	}

	// Other Page Actions
	public void clickForgetPassword() {
		logger.info("Clicking Forget Password Link");
		waitUtil.waitForElementClickable(lnkForgetPassword).click();
		logger.info("Clicked Forget Password Link");
	}

	public boolean isLogoDisplayed() {
		boolean isDisplayed = waitUtil .waitForElementVisible(imgLogo).isDisplayed();
		logger.info( "OrangeHRM logo displayed: {}", isDisplayed );
		return isDisplayed;
	}


}
