package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User {
	private WebDriver driver;
	
	@FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(2) > a")
	private WebElement signOutButton;
	
	public User(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void signOut() {
		signOutButton.click();
	}
}
