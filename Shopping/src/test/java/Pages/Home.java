package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	private WebDriver driver;
	
	@FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
	private WebElement signInButton;
	
	@FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")
	private WebElement addBasketItem1;
	
	@FindBy(css = "#homefeatured > li:nth-child(2) > div > div.right-block > h5 > a")
	private WebElement openItem2;
	
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span")
	private WebElement continueShopping;
	
	@FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.last-line.first-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")
	private WebElement addBasketItem7;
	
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span")
	private WebElement checkOut;
	
	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignInButton() {
		this.signInButton.click();
	}
	
	public void addBasketItem1() {
		this.addBasketItem1.click();
	}
	
	public void openItem2() {
		this.openItem2.click();
	}
	
	public void continueShopping() {
		this.continueShopping.click();
	}
	
	public void addBasketItem7() {
		this.addBasketItem7.click();
	}
	
	public void checkOut() {
		this.checkOut.click();
	}
}
