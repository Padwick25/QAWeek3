package Exercises.MouseActions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Pages.Draggable;
import Pages.Home;
import Pages.Selectable;

public class SelectableTests {
	private WebDriver driver;
	private Home home;
	private Selectable selectable;
	private Actions builder;
	private String url = "http://demoqa.com/";
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		builder = new Actions(driver);
		home = new Home(driver);
		selectable = new Selectable(driver);
		driver.navigate().to(url);
		driver.manage().window().maximize();
		home.clickSelectable();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void defFuctionality() throws InterruptedException {
		selectable.clickDefButton();
		
		builder.click(selectable.getDefItem1()).perform();
		assertEquals("Item 1 not selected", "<li class=\"ui-widget-content ui-corner-left ui-selectee ui-selected\">Item 1</li>", selectable.getDefItem1State());
		
		builder.click(selectable.getDefItem4()).perform();
		assertEquals("Item 1 still selected", "<li class=\"ui-widget-content ui-corner-left ui-selectee\">Item 1</li>", selectable.getDefItem1State());
		assertEquals("Item 4 not selected", "<li class=\"ui-widget-content ui-corner-left ui-selectee ui-selected\">Item 4</li>", selectable.getDefItem4State());
	}
	
	@Test
	public void grid() {
		selectable.clickGridButton();
			
		builder.click(selectable.getGridOne()).perform();
		assertEquals("Grid space one not selected", "<li class=\"ui-state-default ui-corner-left ui-selectee ui-selected\">1</li>", selectable.getGridOneState());
		
		builder.click(selectable.getGridTen()).perform();
		assertEquals("Grid space one still selected", "<li class=\"ui-state-default ui-corner-left ui-selectee\">1</li>", selectable.getGridOneState());
		assertEquals("Grid space ten not selected", "<li class=\"ui-state-default ui-corner-left ui-selectee ui-selected\">10</li>", selectable.getGridTenState());
	}
	
	@Test
	public void serialize() throws InterruptedException {
		selectable.clickSerializeButton();
		
		builder.click(selectable.getSerialItem1()).perform();
		assertEquals("Item 1 not selected", "<li class=\"ui-widget-content ui-corner-left ui-selectee ui-selected\">Item 1</li>", selectable.getSerialItem1State());
		assertEquals("Selected did not change from \"none\"", "#1", selectable.getSerialSelected());
		
		builder.click(selectable.getSerialItem5()).perform();
		assertEquals("Item 1 still selected", "<li class=\"ui-widget-content ui-corner-left ui-selectee\">Item 1</li>", selectable.getSerialItem1State());
		assertEquals("Item 1 not selected", "<li class=\"ui-widget-content ui-corner-left ui-selectee ui-selected\">Item 5</li>", selectable.getSerialItem5State());
		assertEquals("Selected did not change from \"#1\"", "#5", selectable.getSerialSelected());
	}
}
