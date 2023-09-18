package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.Constants;
import base.DriverConfig;
import base.Utilities;
import pages.Login;

public class SC002_LoginWithExcel {
	public static WebDriver driver;
	Utilities util;
	public static Login login;
	String exp_wlecome_msg = "TestProject Example page";
	String exp_error_msg = "Password is invalid";
	
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.out.println("This is before Suite Method...");
		driver = DriverConfig.getBrowser(Constants.browser);
		driver.get(Constants.baseURL);
		util = new Utilities(driver);
		util.windowMaximize();
		System.out.println("Under Before Test...");
		login = PageFactory.initElements(driver, Login.class);
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Under After Test...");
		driver.close();
	}
	
	@Test
	public void TC001_Successfull_Login() {
		System.out.println("Under SC002_TC001_successLogin...");	
	}
}
