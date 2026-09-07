package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtil;

public class DashBoardPage {
	
	private static final Logger logger = LogManager.getLogger(DashBoardPage.class);
	private WebDriver driver;
	
	private WaitUtil waitUtil;
	
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
		waitUtil = new WaitUtil(driver);
	}
	
	private final By lnkAdmin = By.xpath("//span[text()='Admin']");
	private final By lnkPIM = By.xpath("//span[text()='PIM']");
	private final By lnkLeave = By.xpath("//span[text()='Leave']");
	private final By lnkTime = By.xpath("//span[text()='Time']");
	private final By lnkRecruitment = By.xpath("//span[text()='Recruitment']");
	private final By lnkMyInfo = By.xpath("//span[text()='My Info']");
	private final By lnkPerformance = By.xpath("//span[text()='Performance']");
	private final By lnkDashBoard = By.xpath("//span[text()='DashBoard']");
	private final By lnkDirectory = By.xpath("//span[text()='Directory']");
	private final By lnkMaintenance = By.xpath("//span[text()='Maintenance']");
	private final By lnkClaim = By.xpath("//span[text()='Claim']");
	private final By lnkBuzz = By.xpath("//span[text()='Buzz']");
	
	private final By lblDashBoard = By.tagName("//h6");

	public void clickPIM() {
		//driver.findElement(lnkPIM).click();
		
		//WebElement element = driver.findElement(lnkPIM);
		//waitUtil.waitForElementClickable(lnkPIM).click();		//WebElement (lnkPIM)
		
		logger.info("Clicking PIM Link");
		waitUtil.waitForElementClickable(lnkPIM).click();
		logger.info("PIM Link clicked");
	}
	
	public void clickAdmin() {
		logger.info("Clicking Admin Link");
		waitUtil.waitForElementClickable(lnkAdmin).click();
		logger.info("Admin Link clicked");
	}
	
	public void clickLeave() {
		logger.info("Clicking Leave Link");
		waitUtil.waitForElementClickable(lnkLeave).click();
		logger.info("Leave Link clicked");
	}
	
	public void clickTime() {
		logger.info("Clicking Time Link");
		waitUtil.waitForElementClickable(lnkTime).click();
		logger.info("Time Link clicked");
	}
	
	public void clickRecruitment() {
		logger.info("Clicking Recruitment Link");
		waitUtil.waitForElementClickable(lnkRecruitment).click();
		logger.info("Recruitment Link clicked");
	}
	
	public void clickMyInfo() {
		logger.info("Clicking My Info Link");
		waitUtil.waitForElementClickable(lnkMyInfo).click();
		logger.info("My Info Link clicked");
	}
	
	public void clickPerformance() {
		logger.info("Clicking Performance Link");
		waitUtil.waitForElementClickable(lnkPerformance).click();
		logger.info("Performance Link clicked");
	}
	
	public void clickDashBoard() {
		logger.info("Clicking DashBoard Link");
		waitUtil.waitForElementClickable(lnkDashBoard).click();
		logger.info("DashBoard Link clicked");
	}
	
	public void clickDirectory() {
		logger.info("Clicking Directory Link");
		waitUtil.waitForElementClickable(lnkDirectory).click();
		logger.info("Directory Link clicked");
	}
	
	public void clickMaintenance() {
		logger.info("Clicking Maintenance Link");
		waitUtil.waitForElementClickable(lnkMaintenance).click();
		logger.info("Maintenance Link clicked");
	}
	
	public void clickClaim() {
		logger.info("Clicking Claim Link");
		waitUtil.waitForElementClickable(lnkClaim).click();
		logger.info("Claim Link clicked");
	}
	
	public void clickBuzz() {
		logger.info("Clicking Buzz Link");
		waitUtil.waitForElementClickable(lnkBuzz).click();
		logger.info("Buzz Link clicked");
	}
	
	public void clickTheLinkYouWant(String linkName) {
		logger.info("Clicking " +linkName+ "Link");
		waitUtil.waitForElementClickable(By.xpath("//span[text()=' "+linkName+" ']")).click();
		logger.info(linkName + " Link clicked");
	}
	
	public boolean isDashboardDisplayed() {
		try {
			boolean displayed = waitUtil.waitForElementVisible(lblDashBoard).isDisplayed();
	        logger.info("Navigated to DashBoard Page and Dashboard label displayed: {}", displayed);
	        return displayed;
	    } catch (NoSuchElementException e) {
	    	logger.error("Did NOT navigate to DashBoard Page and Dashboard label was not displayed");
	        return false;
	    }
	}
	
	

}
