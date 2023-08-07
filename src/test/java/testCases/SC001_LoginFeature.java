package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Constants;
import base.DriverConfig;
import base.Utilities;
import dev.failsafe.internal.util.Assert;
import pages.Login;

public class SC001_LoginFeature {
	public static WebDriver driver;
	Utilities util;
	public static Login login;
	String exp_wlecome_msg = "TestProject Example page";
	String exp_error_msg = "Password is invalid";

	@BeforeSuite
	public void beforeSuite() throws InterruptedException {
		System.out.println("This is before Suite Method...");
		driver = DriverConfig.getBrowser(Constants.browser);
		driver.get(Constants.baseURL);
		util = new Utilities(driver);
		util.windowMaximize();

	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Under After Suite Method...");
		driver.close();
	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.out.println("Under Before Test...");
		login = PageFactory.initElements(driver, Login.class);
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Under After Test...");

	}

	@Test
	public void TC001_successLogin() {
		System.out.println("Under TC001_successLogin...");
		login.enterCreds("Admin", "12345");
		login.clickLogin();
		String ac_welcome_msg = login.welcomeText();
		assertEquals(exp_wlecome_msg, ac_welcome_msg);
		login.clickLogout();
	}

	@Test
	public void TC002_unSuccessfull_login() {
		System.out.println("Under TC002_Unsuccessfull Login...");
		login.enterCreds("Admin", "123");
		login.clickLogin();
		String ac_error_msg = login.error_txt();
		System.out.println(ac_error_msg);
		assertEquals(exp_error_msg, ac_error_msg);
		
	}

}
