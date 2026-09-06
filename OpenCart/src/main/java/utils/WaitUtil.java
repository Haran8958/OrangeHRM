package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	private WebDriverWait wait;

	public WaitUtil(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Wait until element is visible
	public WebElement waitForElementVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Wait until element is clickable
	public WebElement waitForElementClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Wait until element is present
	public WebElement waitForElementPresent(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// Wait until element disappears
	public boolean waitForElementInvisible(WebElement element) {
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	// Wait until expected text is present in normal text element ( <h6>Michael Jordon</h6> )
	public boolean waitForTextInElement(WebElement element, String text) {
	    return wait.until(
	            ExpectedConditions.textToBePresentInElement(element, text)
	    );
	}

	// Wait until expected text is present inside an input field ( <input value="Michael Jordon"> )
	public boolean waitForTextInElementValue(WebElement element, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
	}


}

