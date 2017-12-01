package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmPayment {
	private WebDriver driver;
	
	@FindBy(css = "#cart_navigation > button > span")
	private WebElement confirm;
	
	public ConfirmPayment(WebDriver driver) {
		this.driver = driver;
	}
	
	public void confirmForTheLoveOfGod() {
		this.confirm.click();
	}
}
