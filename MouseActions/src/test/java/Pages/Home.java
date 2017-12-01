package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	
	@FindBy(css = "#menu-item-140 > a")
	private WebElement draggableButton;
	
	@FindBy(css = "#menu-item-142 > a")
	private WebElement selectableButton;
	
	@FindBy(css = "#menu-item-151 > a")
	private WebElement sortableButton;
	
	@FindBy(css = "#menu-item-99 > a")
	private WebElement toolTipButton;
	
	@FindBy(css = "#menu-item-97 > a")
	private WebElement sliderButton;
	
	@FindBy(css = "#menu-item-146 > a")
	private WebElement datePickerButton;
	
	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickDraggable() {
		draggableButton.click();
	}
	
	public void clickSelectable() {
		selectableButton.click();
	}
	
	public void clickSortable() {
		sortableButton.click();
	}
	
	public void clickToolTip() {
		toolTipButton.click();
	}
	
	public void clickSlider() {
		sliderButton.click();
	}
	
	public void clickDatePicker() {
		datePickerButton.click();
	}
}
