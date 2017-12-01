package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Selectable {
	private WebDriver driver;
	
	@FindBy(css = "#ui-id-1")
	private WebElement defButton;
	
	@FindBy(css = "#ui-id-2")
	private WebElement gridButton;
	
	@FindBy(css = "#ui-id-3")
	private WebElement serializeButton;
	
	@FindBy(css = "#selectable > li:nth-child(1)")
	private WebElement defItem1;
	
	@FindBy(css = "#selectable > li:nth-child(4)")
	private WebElement defItem4;
	
	@FindBy(css = "#selectable_grid > li:nth-child(1)")
	private WebElement gridOne;
	
	@FindBy(css = "#selectable_grid > li:nth-child(10)")
	private WebElement gridTen;
	
	@FindBy(css = "#selectable-serialize > li:nth-child(1)")
	private WebElement serialItem1;
	
	@FindBy(css = "#selectable-serialize > li:nth-child(5)")
	private WebElement serialItem5;
	
	@FindBy(css = "#select-result")
	private WebElement serialSelected;
	
	
	public Selectable(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickDefButton() {
		defButton.click();
	}
	
	public void clickGridButton() {
		gridButton.click();
	}
	
	public void clickSerializeButton() {
		serializeButton.click();
	}
	
	public WebElement getDefItem1() {
		return defItem1;
	}
	
	public String getDefItem1State() {
		return getDefItem1().getAttribute("outerHTML");
	}
	
	public WebElement getDefItem4() {
		return defItem4;
	}
	
	public String getDefItem4State() {
		return getDefItem4().getAttribute("outerHTML");
	}
	
	public WebElement getGridOne() {
		return gridOne;
	}
	
	public String getGridOneState() {
		return getGridOne().getAttribute("outerHTML");
	}
	
	public WebElement getGridTen() {
		return gridTen;
	}
	
	public String getGridTenState() {
		return getGridTen().getAttribute("outerHTML");
	}

	public WebElement getSerialItem1() {
		return this.serialItem1;
	}
	
	public String getSerialItem1State() {
		return getSerialItem1().getAttribute("outerHTML");
	}
	
	public WebElement getSerialItem5() {
		return this.serialItem5;
	}
	
	public String getSerialItem5State() {
		return getSerialItem5().getAttribute("outerHTML");
	}
	
	public String getSerialSelected() {
		return this.serialSelected.getText();
	}
}
