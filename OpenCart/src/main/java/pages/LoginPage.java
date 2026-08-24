package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class LoginPage{
	
	private WebDriver driver;
	
	private static final Logger logger = LogManager.getLogger(LoginPage.class);
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private final By txtUsername = By.name("username");
	private final By txtUPassword = By.name("password");
	private final By btnLogin = By.xpath("//button[normalize-space()='Login']");
	private final By lnkForgetPassword = By.xpath("//p[text()='Forgot your password? ']");
	private final By imgLogo = By.xpath("//img[@alt='company-branding']");
	private final By lnkPIM = By.xpath("//span[text()='PIM']");
	
	public void enterUsername() {
		logger.info("Entering Username");
		driver.findElement(txtUsername).sendKeys(ConfigReader.getProperty("username"));
		logger.info("Username Entered");
	}
	
	public void enterPassword() {
		logger.info("Entering Password");
		driver.findElement(txtUPassword).sendKeys(ConfigReader.getProperty("password"));
		logger.info("Username Password");
	}
	
	public void clickLoginBtn() {
		logger.info("Clicking Login button");
		driver.findElement(btnLogin).click();
		//return new DashBoardPage();
		logger.info("Login button clicked");
	}
	
	public void login() {
		enterUsername();
		enterPassword();
		clickLoginBtn();
	}
	
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
	
	public void clickForgetPassword() {
		logger.info("Clicking Forget Password Link");
		driver.findElement(lnkForgetPassword).click();
		logger.info("Clicked Forget Password Link");
	}
	
	public boolean isLogoDisplayed() {
		return driver.findElement(imgLogo).isDisplayed();
	}
	
	public void clickPIM() {
		logger.info("Clicking PIM Link");
		driver.findElement(lnkPIM).click();
		logger.info("Clicked PIM Link");
	}

}
