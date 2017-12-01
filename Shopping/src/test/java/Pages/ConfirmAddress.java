package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmAddress {
	private WebDriver driver;
	
	@FindBy(css = "#center_column > form > p > button > span")
	private WebElement checkout;
	
	public ConfirmAddress(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fuckingContinueJesus() {
		this.checkout.click();
	}
	
	
}
