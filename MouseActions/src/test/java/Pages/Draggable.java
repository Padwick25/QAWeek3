package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Draggable {
	private WebDriver driver;
	
	@FindBy(css = "#ui-id-1")
	private WebElement defaultButton;
	
	@FindBy(css = "#ui-id-2")
	private WebElement constrainButton;
	
	@FindBy(css = "#ui-id-3")
	private WebElement cursorStyleButton;
	
	@FindBy(css = "#ui-id-4")
	private WebElement eventsButton;
	
	@FindBy(css = "#ui-id-5")
	private WebElement sortableButton;
	
	@FindBy(css = "#draggable")
	private WebElement defaultBox;
	
	@FindBy(css = "#draggabl")
	private WebElement constrainVerticalBox;
	
	@FindBy(css = "#draggabl2")
	private WebElement constrainHorizontalBox;
	
	@FindBy(css = "#draggabl3")
	private WebElement constrainInBox;
	
	@FindBy(css = "#drag")
	private WebElement styleCentreBox;
	
	@FindBy(css = "#drag2")
	private WebElement styleTopLeftBox;
	
	@FindBy(css = "#drag3")
	private WebElement styleBottomBox;
	
	@FindBy(css = "#dragevent")
	private WebElement eventBox;
	
	@FindBy(css = "#event-start")
	private WebElement eventStart;
	
	@FindBy(css = "#event-drag")
	private WebElement eventDrag;
	
	@FindBy(css = "#event-stop")
	private WebElement eventStop;
	
	@FindBy(css = "#sortablebox > li:nth-child(1)")
	private WebElement draggableItemOne;
	
	@FindBy(css = "#sortablebox > li:nth-child(2)")
	private WebElement draggableItemTwo;
	
	@FindBy(css = "#sortablebox > li:nth-child(3)")
	private WebElement draggableItemThree;
	
	@FindBy(css = "#sortablebox > li:nth-child(4)")
	private WebElement draggableItemFour;
	
	@FindBy(css = "#sortablebox > li:nth-child(5)")
	private WebElement draggableItemFive;
	
	public Draggable(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickDefault() {
		defaultButton.click();
	}
	
	public void clickConstrain() {
		constrainButton.click();
	}
	
	public void clickCursorStyle() {
		cursorStyleButton.click();
	}
	
	public void clickEvents() {
		eventsButton.click();
	}
	
	public void clickSortable() {
		sortableButton.click();
	}
	
	public WebElement getDefault() {
		return this.defaultBox;
	}
	
	public int getDefaultX() {
		return defaultBox.getLocation().getX();
	}

	public int getDefaultY() {
		return defaultBox.getLocation().getY();
	}
	
	public WebElement getConstrainVertical() {
		return this.constrainVerticalBox;
	}
	
	public int getConstrainVerticalX() {
		return this.constrainVerticalBox.getLocation().getX();
	}
	
	public int getConstrainVerticalY() {
		return this.constrainVerticalBox.getLocation().getY();
	}
	
	public WebElement getConstrainHorizontal() {
		return this.constrainHorizontalBox;
	}
	
	public int getConstrainHorizontalX() {
		return this.constrainHorizontalBox.getLocation().getX();
	}
	
	public int getConstrainHorizontalY() {
		return this.constrainHorizontalBox.getLocation().getY();
	}
	
	public WebElement getConstrainInBox() {
		return this.constrainInBox;
	}
	
	public int getConstrainInBoxY() {
		return this.constrainInBox.getLocation().getX();
	}
	
	public int getConstrainInBoxX() {
		return this.constrainInBox.getLocation().getY();
	}

	public WebElement getStyleCentre() {
		return this.styleCentreBox;
	}
	
	public int getStyleCentreX() {
		return this.styleCentreBox.getLocation().getX();
	}
	
	public int getStyleCentreY() {
		return this.styleCentreBox.getLocation().getY();
	}
	
	public WebElement getStyleTopLeft() {
		return this.styleTopLeftBox;
	}
	
	public int getStyleTopLeftX() {
		return this.styleTopLeftBox.getLocation().getX();
	}
	
	public int getStyleTopLeftY() {
		return this.styleTopLeftBox.getLocation().getY();
	}
	
	public WebElement getStyleBottom() {
		return this.styleBottomBox;
	}
	
	public int getStyleBottomX() {
		return this.styleBottomBox.getLocation().getX();
	}
	
	public int getStyleBottomY() {
		return this.styleBottomBox.getLocation().getY();
	}

	public WebElement getEventBox() {
		return this.eventBox;
	}

	public String getEventStart() {
		return eventStart.getText();
	}
	
	public String getEventDrag() {
		return eventDrag.getText();
	}
	
	public String getEventStop() {
		return eventStop.getText();
	}

	public WebElement getSortableItemOne() {
		return this.draggableItemOne;
	}
	
	public WebElement getSortableItemTwo() {
		return this.draggableItemTwo;
	}
	
	public int getSortableOnePos() {
		return this.draggableItemOne.getLocation().getY();
	}
	
	public int getSortableTwoPos() {
		return this.draggableItemTwo.getLocation().getY();
	}
	
	public int getSortableThreePos() {
		return this.draggableItemThree.getLocation().getY();
	}
	
	public int getSortableFourPos() {
		return this.draggableItemFour.getLocation().getY();
	}
	
	public int getSortableFivePos() {
		return this.draggableItemFive.getLocation().getY();
	}
}
