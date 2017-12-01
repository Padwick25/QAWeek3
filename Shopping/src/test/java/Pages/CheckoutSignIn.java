package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutSignIn {
	WebDriver driver;
	
	@FindBy(css = "#email")
	WebElement email;
	
	@FindBy(css = "#passwd")
	WebElement password; 
	
	@FindBy(css = "#SubmitLogin > span")
	WebElement button;
	
	public CheckoutSignIn(
}
