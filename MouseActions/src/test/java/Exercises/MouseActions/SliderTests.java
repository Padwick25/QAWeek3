package Exercises.MouseActions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Pages.Home;
import Pages.Slider;

public class SliderTests {
	WebDriver driver;
	Home home;
	Slider slider;
	Actions builder;
	String url = "http://demoqa.com/";
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		slider = new Slider(driver);
		home = new Home(driver);
		builder = new Actions(driver);
		driver.navigate().to(url);
		driver.manage().window().maximize();
		home.clickSlider();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void slider() throws InterruptedException {
		home.clickSlider();
		
		String startValue = slider.getSliderValue();
		builder.moveToElement(slider.getSlider()).clickAndHold().moveByOffset(50, 0).release().perform();
		assertEquals("Incorrect value", "3", slider.getSliderValue());
		
		builder.moveToElement(slider.getSlider()).clickAndHold().moveByOffset(-1000, 0).release().perform();
		assertEquals("Incorrect value", "1", slider.getSliderValue());
	}
}
