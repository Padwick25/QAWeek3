package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
	private WebDriver driver;
	
	@FindBy(css = "#id_gender1")
	private WebElement mrButton;
	
	@FindBy(css = "#id_gender2")
	private WebElement mrsButton;
	
	@FindBy(css = "#customer_firstname")
	private WebElement firstName;
	
	@FindBy(css = "#customer_lastname")
	private WebElement lastName;
	
	@FindBy(css = "#passwd")
	private WebElement password;
	
	@FindBy(css = "#days")
	private WebElement dobDay;
	
	@FindBy(css = "#months")
	private WebElement dobMonth;
	
	@FindBy(css = "#years")
	private WebElement dobYear;
	
	@FindBy(css = "#address1")
	private WebElement addressLine1;
	
	@FindBy(css = "#city")
	private WebElement addressCity;
	
	@FindBy(css = "#id_state")
	private WebElement addressState;
	
	@FindBy(css = "#postcode")
	private WebElement addressPostCode;
	
	@FindBy(css = "#id_country")
	private WebElement addressCountry;
	
	@FindBy(css = "#phone_mobile")
	private WebElement mobileNo;
	
	@FindBy(css = "#submitAccount > span")
	private WebElement registerButton;
	
	public SignUp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterDetails(String isMale, String firstName, String lastName, String password, String dobDay, String dobMonth, String dobYear, String addressLine1,
			String city, String state, String postCode, String mobileNo) {
		if(isMale == "1.0") {
			mrButton.click();
		} else {
			mrsButton.click();
		}
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.password.sendKeys(password);
		this.dobDay.sendKeys(dobDay);
		this.dobMonth.sendKeys(dobMonth);
		this.dobYear.sendKeys(dobYear);
		this.addressLine1.sendKeys(addressLine1);
		this.addressCity.sendKeys(city);
		this.addressState.sendKeys(state);
		this.addressPostCode.sendKeys(postCode.substring(0, 5));
		this.mobileNo.sendKeys(mobileNo);
	}
	
	public void register() {
		this.registerButton.click();
	}
}
