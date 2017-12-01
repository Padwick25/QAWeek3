package Exercises.Shopping;

import java.io.File;
import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.Address;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.Basket;
import Pages.ConfirmAddress;
import Pages.ConfirmPayment;
import Pages.Confirmation;
import Pages.Home;
import Pages.Item2;
import Pages.Payment;
import Pages.Shipping;
import Pages.SignIn;
import Pages.SignUp;
import Pages.User;

public class ShoppingTests {
	private WebDriver driver;
	private String url = "http://automationpractice.com/";
	private static ExtentReports report;
	private Home home;
	private SignIn signIn;
	private SignUp signUp;
	private static SpreadsheetReader reader;
	private User user;
	private Item2 item2;
	private Basket basket;
	private ConfirmAddress address;
	private Shipping shipping;
	private Payment payment;
	private ConfirmPayment confirmPayment;
	private Confirmation confirmation;
	
	@BeforeClass
	public static void init() {
		report = new ExtentReports();
        String fileName = "LoginReport" + ".html";
        String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
	}
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
		home = new Home(driver);
		reader = new SpreadsheetReader();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@AfterClass
	public static void cleanUp() {
		report.flush();
	}
	
	/*@Test
	public void signUp() throws InterruptedException {
		ExtentTest loginTest = report.createTest("Login test");
		signIn = new SignIn(driver);
		signUp = new SignUp(driver);
		user = new User(driver);
		
		loginTest.log(Status.INFO, "Test that attempts to create an account, log out of it, and sign back in");
		loginTest.log(Status.DEBUG, "Moving to sign in page");
		home.clickSignInButton();
		loginTest.log(Status.DEBUG, "Making array list of user details from excel doc");
		ArrayList<String> details = reader.readRow(0, "user1");
		loginTest.log(Status.DEBUG, "Enter email");
		signIn.createAccount(details.get(0));
		Thread.sleep(5000);
		loginTest.log(Status.DEBUG, "Enter details");
		signUp.enterDetails(details.get(1), details.get(2), details.get(3), details.get(4), details.get(5), details.get(6), details.get(7), details.get(8), details.get(9), details.get(10), details.get(11), details.get(12));
		loginTest.log(Status.DEBUG, "Registering");
		signUp.register();
		loginTest.log(Status.DEBUG, "Signing out");
		user.signOut();
		
		loginTest.log(Status.DEBUG, "Signing in");
		signIn.signIn(details.get(0), details.get(4));
		Thread.sleep(5000);
		if(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account")) {
			loginTest.log(Status.PASS, "Succesfully signed back in");
		} else {
			loginTest.log(Status.FAIL, "Not on user page");
		}
	}*/
	
	@Test
	public void buyItem() throws InterruptedException {
		ExtentTest buyTest = report.createTest("Buy test");
		item2 = new Item2(driver);
		basket = new Basket(driver);
		address = new ConfirmAddress(driver);
		shipping = new Shipping(driver);
		payment = new Payment(driver);
		confirmPayment = new ConfirmPayment(driver);
		confirmation = new Confirmation(driver);
		buyTest.log(Status.INFO, "Test to add multiple items to carts, with different methods.");
		
		home.openItem2();
		Thread.sleep(5000);
		item2.addToCart();
		item2.changeSize("m");
		item2.changeColour();
		item2.addToCart();
		Thread.sleep(2500);
		item2.checkout();
		Thread.sleep(2000);
		
		basket.checkout();
		Thread.sleep(2000);
		address.fuckingContinueJesus();
		Thread.sleep(2000);
		shipping.oneDayWeWillFinishThisTransactionThatIsOnlyATest();
		Thread.sleep(2000);
		payment.payByWire();
		Thread.sleep(2000);
		if(confirmation.checkConfirm()) {
			buyTest.log(Status.PASS, "Successfully checked out");
		} else {
			buyTest.log(Status.FAIL, "Failed to checkout");
		}
	}
}
