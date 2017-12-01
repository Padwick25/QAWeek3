package LoginTest.Login;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.AddUserPage;
import Pages.HomePage;
import Pages.LoginPage;

public class LoginTest {
	private String url = "http://thedemosite.co.uk/";
	private WebDriver webDriver;
	private HomePage homePage;
	private AddUserPage userPage;
	private LoginPage loginPage;
	private static ExtentReports report;
	private static SpreadsheetReader reader;
	
	@BeforeClass
	public static void init() {
		report = new ExtentReports();
        String fileName = "LoginReport" + ".html";
        String filePath = System.getProperty("user.dir")
                + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
        reader = new SpreadsheetReader();
	}
	//HI! :)
	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		webDriver.quit();
	}
	
	@AfterClass
	public static void cleanUp() {
		report.flush();
	}
	
	@Test
	public void qaTest() throws IOException {
		webDriver.navigate().to(url);
		ExtentTest loginTest = report.createTest("loginTest");
		loginTest.log(Status.INFO, "Test to sign up and login to the shitty website with the name I forgot");
		homePage = new HomePage(webDriver);
		loginPage = new LoginPage(webDriver);
		userPage = new AddUserPage(webDriver);
		
		loginTest.log(Status.DEBUG, "Moving to sign up page");
		homePage.clickAddUser();
		
		loginTest.log(Status.DEBUG, "Signing up");
		ArrayList<String> signUp = reader.readRow(0, "SignUp");
		userPage.login(signUp.get(0), signUp.get(1));
		
		loginTest.log(Status.DEBUG, "Signed up");
		loginTest.log(Status.DEBUG, "Moving to log in page");
		userPage.clickLoginPage();
		
		loginTest.log(Status.DEBUG, "Logging in");
		ArrayList<String> signIn = reader.readRow(0, "SignIn");
		loginPage.login(signIn.get(0), signIn.get(1));
		loginTest.log(Status.DEBUG, "Log in details entered");
		
		if(loginPage.getLoginText().equals("**Successful Login**")) {
			loginTest.log(Status.PASS, "Successfully logged in.");
		} else {
			loginTest.log(Status.FAIL, "Failed to log in.");
			Screenshot cap = new Screenshot();
			loginTest.addScreenCaptureFromPath(Screenshot.take(webDriver, "loginTest"));
		}
	}
}