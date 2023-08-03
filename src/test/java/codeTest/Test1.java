package codeTest;

import org.openqa.selenium.WebDriver;

import base.Constants;
import base.DriverConfig;

public class Test1 {
	public static WebDriver driver;

	public static void main(String[] args) {
		
		System.out.println("This is browser detection test");
		driver = DriverConfig.getBrowser(Constants.browser);
		System.out.println("****** Launching Browser ********");
        driver.get(Constants.baseURL);
        driver.manage().window().maximize();
        driver.close();
        
	}

}
