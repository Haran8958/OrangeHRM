package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import baseClass.BaseClass;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

	private static final Logger logger = LogManager.getLogger(TestListener.class);

	@Override
	public void onTestStart(ITestResult result) {
		//System.out.println("Test Started: " + result.getName());
		logger.info("TEST STARTED: {}",result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//System.out.println("Test Passed: " + result.getName());
		logger.info("TEST PASSED: {}",result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//System.out.println("Test Failed: " + result.getName());
		logger.info("TEST FAILED: {}",result.getName());

		Object testClass = result.getInstance(); 
		if (testClass instanceof BaseClass) { 
			BaseClass baseClass = (BaseClass) testClass; 

			try { 
				String screenshotPath = ScreenshotUtil.captureScreenshot( baseClass.getDriver(), result.getName() ); 
				logger.error( "Screenshot captured: {}", screenshotPath ); 
			} catch (Exception e) { 
				logger.error( "Failed to capture screenshot", e ); 
				} 
			}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//System.out.println("Test Skipped: " + result.getName());
		logger.info("TEST SKIPPED: {}",result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Suite Started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Suite Finished");
	}
}