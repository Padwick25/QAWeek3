package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Item2 {
	private WebDriver driver;
		
	@FindBy(css = "#quantity_wanted_p > a.btn.btn-default.button-plus.product_quantity_up > span > i")
	private WebElement plus1Item;
	
	@FindBy(css = "#group_1")
	private WebElement size;
	
	@FindBy(css = "#color_8")
	private WebElement changeColour;
	
	@FindBy(css = "#add_to_cart > button > span")
	private WebElement addToCart;
	
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span")
	private WebElement continueShopping;
	
	@FindBy(css = "#header_logo > a > img")
	private WebElement goHome;
	
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span")
	private WebElement checkout;
	
	public Item2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addItem() {
		this.plus1Item.click();
	}
	
	public void changeSize(String size) {
		this.size.sendKeys(size);
	}
	
	public void changeColour() {
		changeColour.click();
	}
	
	public void addToCart() {
		this.addToCart.click();
	}
	
	public void continueShopping() {
		this.continueShopping.click();
	}
	
	public void goHome() {
		this.goHome.click();
	}
	
	public void checkout() {
		this.checkout.click();
	}
}
