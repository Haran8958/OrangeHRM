package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

    private WebDriver driver;
    private JavascriptExecutor js;

    public JavaScriptUtil(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0);");
    }

    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void clickElement(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public void highlightElement(WebElement element) {
        js.executeScript("arguments[0].style.border='3px solid red';", element);
    }

    public String getPageTitle() {
        return (String) js.executeScript("return document.title;");
    }
}