package baseClass;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import factory.DriverFactory;
import utils.ConfigReader;

public class BaseClass {

	protected WebDriver driver;
	private static final Logger logger = LogManager.getLogger(BaseClass.class);
	
	@BeforeMethod
	public void setUp() {
		logger.info("===== Test Setup Started =====");

		logger.info("Creating WebDriver");
		driver = DriverFactory.createDriver();
		logger.info("WebDriver created successfully");
		driver.manage().window().maximize();
		logger.info("Browser maximized");
		driver.manage().deleteAllCookies();
		logger.info("Cookies deleted");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String url = ConfigReader.getProperty("url");
		logger.info("Navigating to URL: {}", url);
		driver.get(url);
		logger.info("URL loaded successfully");

		logger.info("===== Test Setup Completed =====");

	}

	@AfterMethod
	public void tearDown() {
		logger.info("Starting browser teardown");
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		logger.info("Browser closed successfully");
	}






}
