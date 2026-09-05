package factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LogTest {

	private static final Logger logger =
			LogManager.getLogger(LogTest.class);

	@Test
	public void testLogging() {

		logger.info("This is an INFO message");

		logger.warn("This is a WARNING message");

		logger.error("This is an ERROR message");

		System.out.println("Logging test completed");
	}
}