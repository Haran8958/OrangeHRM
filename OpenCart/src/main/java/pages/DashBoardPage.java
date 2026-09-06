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
		logger.info("Clicking PIM Link");
		WebElement element = driver.findElement(lnkPIM);
		waitUtil.waitForElementClickable(element).click();
		logger.info("PIM Link clicked");
	}
	
	public void clickAdmin() {
		logger.info("Clicking Admin Link");
		driver.findElement(lnkAdmin).click();
		logger.info("Admin Link clicked");
	}
	
	public void clickLeave() {
		logger.info("Clicking Leave Link");
		driver.findElement(lnkLeave).click();
		logger.info("Leave Link clicked");
	}
	
	public void clickTime() {
		logger.info("Clicking Time Link");
		driver.findElement(lnkTime).click();
		logger.info("Time Link clicked");
	}
	
	public void clickRecruitment() {
		logger.info("Clicking Recruitment Link");
		driver.findElement(lnkRecruitment).click();
		logger.info("Recruitment Link clicked");
	}
	
	public void clickMyInfo() {
		logger.info("Clicking My Info Link");
		driver.findElement(lnkMyInfo).click();
		logger.info("My Info Link clicked");
	}
	
	public void clickPerformance() {
		logger.info("Clicking Performance Link");
		driver.findElement(lnkPerformance).click();
		logger.info("Performance Link clicked");
	}
	
	public void clickDashBoard() {
		logger.info("Clicking DashBoard Link");
		driver.findElement(lnkDashBoard).click();
		logger.info("DashBoard Link clicked");
	}
	
	public void clickDirectory() {
		logger.info("Clicking Directory Link");
		driver.findElement(lnkDirectory).click();
		logger.info("Directory Link clicked");
	}
	
	public void clickMaintenance() {
		logger.info("Clicking Maintenance Link");
		driver.findElement(lnkMaintenance).click();
		logger.info("Maintenance Link clicked");
	}
	
	public void clickClaim() {
		logger.info("Clicking Claim Link");
		driver.findElement(lnkClaim).click();
		logger.info("Claim Link clicked");
	}
	
	public void clickBuzz() {
		logger.info("Clicking Buzz Link");
		driver.findElement(lnkBuzz).click();
		logger.info("Buzz Link clicked");
	}
	
	public void clickTheLinkYouWant(String linkName) {
		logger.info("Clicking " +linkName+ "Link");
		driver.findElement(By.xpath("//span[text()=' "+linkName+" ']")).click();
		logger.info(linkName + " Link clicked");
	}
	
	public boolean isDashboardDisplayed() {
		try {
	        return driver.findElement(lblDashBoard).isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
	
	

}
