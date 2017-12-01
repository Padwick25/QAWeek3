package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Slider {
	WebDriver driver;
	
	@FindBy(css = "#slider-range-max > span")
	WebElement slider;
	
	@FindBy(css = "#amount1")
	WebElement sliderValue;
	
	public Slider(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSlider() {
		return this.slider;
	}
	
	public String getSliderValue() {
		return this.sliderValue.getAttribute("value");
	}
}
