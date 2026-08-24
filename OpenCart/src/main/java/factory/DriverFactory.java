package factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class DriverFactory {
	private static final Logger logger = LogManager.getLogger(DriverFactory.class);

	private DriverFactory() {
	}

	public static WebDriver createDriver() {

		String browser = ConfigReader.getProperty("browser").toLowerCase();
		logger.info("Requested browser: {}", browser);

		switch (browser) {
		case "chrome":
			logger.info("Launching Chrome");
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();

		case "edge":
			logger.info("Launching Edge");
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();

		default:
			logger.error("Unsupported browser: {}",browser);
			throw new RuntimeException("Browser not supported: " + browser);
		}
	}




}
