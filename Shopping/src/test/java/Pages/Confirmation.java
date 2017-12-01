package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmation {
	private WebDriver driver;
	
	@FindBy(css = "#center_column > div > p > strong")
	WebElement checkConfirm;
	
	public Confirmation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkConfirm() {
		if(checkConfirm.getText().equals("Your order on My Store is complete.")) {
			return true;
		} else {
			return false;
		}
	}
}
