package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DashBoardPage {
	
	private WebDriver driver;
	
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private final By lnkAdmin = By.xpath("//span[text()='Admin']");
	private final By lnkPIM = By.xpath("//span[text()='PIM']");

	
	
	public void clickPIM() {
		driver.findElement(lnkPIM).click();
	}
	
	
	

}
