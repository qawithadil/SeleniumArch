package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverConfig {

	// Variable declaration

	public static WebDriver driver = null;

	public static WebDriver getBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", Constants.chrome_path);
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", Constants.edge_path);
			driver = new EdgeDriver();

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", Constants.firefox_path);
			driver = new ChromeDriver();

		}

		else {
			System.out.println("***Your Browser is not configured into System****");
		}
		
		return driver;

	}

}
