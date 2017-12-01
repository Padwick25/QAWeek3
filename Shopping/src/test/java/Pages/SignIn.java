package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {
	private WebDriver driver;
	
	@FindBy(css = "#email_create#email_create")
	private WebElement createAccountEmailBox;
	
	@FindBy(css = "#SubmitCreate > span")
	private WebElement createAccountButton;
	
	@FindBy(css = "#email")
	private WebElement signInEmail;
	
	@FindBy(css = "#passwd")
	private WebElement signInPassword;
	
	@FindBy(css = "#SubmitLogin > span")
	private WebElement signInButton;
	
	public SignIn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createAccount(String email) {
		this.createAccountEmailBox.sendKeys(email);
		this.createAccountButton.click();
	}
	
	public void signIn(String email, String password) {
		this.signInEmail.sendKeys(email);
		this.signInPassword.sendKeys(password);
		this.signInButton.click();
	}

}
