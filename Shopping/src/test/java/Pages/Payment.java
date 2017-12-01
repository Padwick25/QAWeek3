package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Payment {
	private WebDriver driver;
	
	@FindBy(css = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a\"")
	private WebElement payByWire;
	
	public Payment(WebDriver driver) {
		this.driver = driver;
	}
	
	public void payByWire() {
		this.payByWire.click();
	}
}
