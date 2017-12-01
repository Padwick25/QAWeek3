package Exercises.MouseActions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Pages.Draggable;
import Pages.Home;

public class DraggableTest {
	private WebDriver driver;
	private Draggable draggable;
	private Home home;
	private Actions builder;
	private String url = "http://demoqa.com/";
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		builder = new Actions(driver);
		home = new Home(driver);
		draggable = new Draggable(driver);
		driver.navigate().to(url);
		driver.manage().window().maximize();
		home.clickDraggable();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void defaultFunctionality() {		//Passing
		draggable.clickDefault();
		
		int xStart = draggable.getDefaultX();
		int yStart = draggable.getDefaultY();
		builder.moveToElement(draggable.getDefault()).clickAndHold().moveByOffset(50, 10).release().perform();
		assertEquals("Moved wrong ammount in x", xStart + 50, draggable.getDefaultX());
		assertEquals("Moved wrong ammount in y", yStart + 10, draggable.getDefaultY());
	}
	
	@Test
	public void constrainMovement() { //all pass but constrained to parent
		draggable.clickConstrain();
		
		int xVerticalStart = draggable.getConstrainVerticalX();
		int yVerticalStart = draggable.getConstrainVerticalY();
		builder.moveToElement(draggable.getConstrainVertical()).clickAndHold().moveByOffset(10, 0).release().perform();;
		assertEquals("Vertical box moved horrizontally", xVerticalStart, draggable.getConstrainVerticalX());
		
		builder.moveToElement(draggable.getConstrainVertical()).clickAndHold().moveByOffset(0, -10).release().perform();
		assertEquals("Vertical box did not move by expected ammount", yVerticalStart - 10, draggable.getConstrainVerticalY());
		
		int xHorizontalStart = draggable.getConstrainHorizontalX();
		int yHorizontalStart = draggable.getConstrainHorizontalY();
		builder.moveToElement(draggable.getConstrainHorizontal()).clickAndHold().moveByOffset(0, 10).release().perform();
		assertEquals("Horizontal box moved vertically", yHorizontalStart, draggable.getConstrainHorizontalY());
		
		builder.moveToElement(draggable.getConstrainHorizontal()).clickAndHold().moveByOffset(10, 0).release().perform();
		assertEquals("Horizontal box didn't move by expected ammount", xHorizontalStart + 10, draggable.getConstrainHorizontalX());
		
		int xInBoxStart = draggable.getConstrainInBoxX();
		builder.moveToElement(draggable.getConstrainInBox()).clickAndHold().moveByOffset(1000, 0).release().perform();
		assertNotEquals("Box moved outside of big box", xInBoxStart + 1000, draggable.getConstrainInBoxX());
	}
	
	@Test
	public void cursorStyle() { //All pass
		draggable.clickCursorStyle();
		
		int xCentreStart = draggable.getStyleCentreX();			//off centre by 6 in x and y xDDDDDddddDDDdddee
		int yCentreStart = draggable.getStyleCentreY();
		builder.moveToElement(draggable.getStyleCentre()).clickAndHold().moveByOffset(1, 1).moveByOffset(-1, -1).release().perform();
		System.out.println(xCentreStart + " " + draggable.getStyleCentreX());
		System.out.println(yCentreStart + " " + draggable.getStyleCentreY());
		assertEquals("\"Centre\" box did not move by expected ammount in x", xCentreStart - 6, draggable.getStyleCentreX());
		assertEquals("\"Centre\" box did not move by expected ammount in y", yCentreStart - 6, draggable.getStyleCentreY());
		
		int xTopLeftStart = draggable.getStyleTopLeftX();
		int yTopLeftStart = draggable.getStyleTopLeftY();
		builder.moveToElement(draggable.getStyleTopLeft()).clickAndHold().moveByOffset(1, 1).moveByOffset(-1, -1).release().perform();
		assertEquals("Top Left box did not move by expected ammount in x", xTopLeftStart + 55, draggable.getStyleTopLeftX());
		assertEquals("Top Left box did not move by expected ammount in y", yTopLeftStart + 55, draggable.getStyleTopLeftY());
		
		int xBottomStart = draggable.getStyleBottomX();
		int yBottomStart = draggable.getStyleBottomY();
		builder.moveToElement(draggable.getStyleBottom()).clickAndHold().moveByOffset(1, 1).moveByOffset(-1, -1).release().perform();
		assertEquals("Bottom moved in x", xBottomStart, draggable.getStyleBottomX());
		assertEquals("Bottom box did not move by expected ammount in y", yBottomStart - 50, draggable.getStyleBottomY());
	}
	
	@Test
	public void events() {			//All pass
		draggable.clickEvents();
		
		builder.moveToElement(draggable.getEventBox()).clickAndHold().moveByOffset(10, 0).release().perform();
		assertEquals("\"start\" not invoked enough times", "“start” invoked 1x", draggable.getEventStart());
		assertEquals("\"drag\" not invoked enough times", "“drag” invoked 1x", draggable.getEventDrag());
		assertEquals("\"stop\" not invoked enough times", "“stop” invoked 1x", draggable.getEventStop());
	}
	
	/*@Test					//????????
	public void sortable() throws InterruptedException {
		draggable.clickSortable();
		
		int sortableOneStartPos = draggable.getSortableOnePos();
		int sortableTwoStartPos = draggable.getSortableTwoPos();
		int sortableThreeStartPos = draggable.getSortableThreePos();
		builder.moveToElement(draggable.getSortableItemOne()).clickAndHold().moveByOffset(0, 30).release().perform();
		Thread.sleep(5000);
		System.out.println(sortableOneStartPos + " " + draggable.getSortableOnePos());
		assertEquals("Item one not in position two", sortableTwoStartPos, draggable.getSortableOnePos());
		assertEquals("Item two not in position one", sortableOneStartPos, draggable.getSortableTwoPos());
		assertEquals("Item three has moved", sortableThreeStartPos, draggable.getSortableThreePos());
	}*/
}