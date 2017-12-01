package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shipping {
	private WebDriver driver;
	
	@FindBy(css = "#form > p > button > span")
	private WebElement checkout;
	
	@FindBy(css = "#cgv")
	private WebElement terms;
	
	public Shipping(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void yesIAgreeNoIDidntReadIt() {
		terms.click();
	}
	
	public void oneDayWeWillFinishThisTransactionThatIsOnlyATest() {
		checkout.click();
	}
}
