package elementsHandling;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import base.Constants;
import base.DriverConfig;
import base.Utilities;

public class Elements1 {

	public static WebDriver driver;
	public static Utilities ut;

	public static void main(String[] args) {

		driver = DriverConfig.getBrowser(Constants.browser);
		driver.get("https://artoftesting.com/samplesiteforselenium");
		ut = new Utilities(driver);
		ut.windowMaximize();

		// Getting sample text

		System.out.println("*********** Getting Sample Text **************");
		String sample_text = driver.findElement(By.id("idOfDiv")).getText();
		System.out.println("Label Text=" + sample_text);

		/*
		 * Insert text & Clear it
		 */
		System.out.println("******* Insert Text & Clear It ************");
		WebElement text_box = driver.findElement(By.id("fname"));
		text_box.sendKeys("This is text message");
		text_box.clear();

		// Click Submit Button

		driver.findElement(By.id("idOfButton")).click();
		System.out.println("Button text=" + driver.findElement(By.id("idOfButton")).getText());

		// Double Click on button & click OK on PopUp

		WebElement dbl_click = driver.findElement(By.xpath(".//button[@id='dblClkBtn']"));

		Actions act = new Actions(driver);
		act.doubleClick(dbl_click).build().perform(); 
		
		/*
		 *  More Actions Classes: doubleClick, ContextClick,
		 */

		// Get the PopUp Text and Click OK

		String popup_text = driver.switchTo().alert().getText();
		System.out.println("Popup Text=" + popup_text);
		driver.switchTo().alert().accept();

		/*
		 * Radio Button Handling Selection = "Male"
		 */

		driver.findElement(By.id("male")).click();
		System.out.println("Radio Button Clicked:");

		/*
		 * Check Box handling Automation Testing Checked
		 */

		driver.findElement(By.className("Automation")).click();

		/*
		 * Validated that Radio Button is checked and fetch the selected radio value
		 * 
		 */

		List<WebElement> radio_button = driver.findElements(By.name("gender"));
		Iterator<WebElement> itr = radio_button.iterator();
		while (itr.hasNext()) {
			WebElement radioVal = itr.next();
			if (radioVal.isSelected()) {
				System.out.println("Selected Radio button Value=" + radioVal.getAttribute("value").toString());
			}
		}

		/*
		 * Un-check the checked Check box and check other check box field
		 * 
		 */
		
		List<WebElement> checkbox_list = driver.findElements(By.xpath(".//input[@type='checkbox']"));
		// System.out.println("Checkbox Size="+checkbox_list.size());
		Iterator<WebElement> itr_check = checkbox_list.iterator();
		while (itr_check.hasNext()) {

			WebElement checkBox_Val = itr_check.next();
			if (checkBox_Val.isSelected()) {
				System.out.println("Selected CHeckbox Value=" + checkBox_Val.getAttribute("value").toString());
				System.out.println("Unchecking the checkbox value...");
				checkBox_Val.click();
			} else {
				checkBox_Val.click();
				System.out.println("Newly Selected Checkbox value=" + checkBox_Val.getAttribute("value").toString());
			}
		}

		/*
		 * Drop Down Actions
		 * 
		 */
 
		WebElement dropDown = driver.findElement(By.id("testingDropdown"));
		Select select = new Select(dropDown);
		System.out.println("Choose 'DataBase Testing Option'");
		select.selectByValue("Database");
		List<WebElement> drop_list = select.getOptions();
		System.out.println("Total Value in Dropdown=" + drop_list.size());
		Iterator<WebElement> drop_itr = drop_list.iterator();
		System.out.println("Print All Drop Down values...");
		while (drop_itr.hasNext()) {
			WebElement drop_item = drop_itr.next();
			System.out.println(drop_item.getAttribute("value").toString());
		}
		System.out.println("********");

		/*
		 * Click on Alert Box
		 */

		driver.findElement(By.xpath(".//button[@onclick='generateAlertBox()']")).click();
		String alert_text = driver.switchTo().alert().getText();
		System.out.println("Alert Text=" + alert_text);
		driver.switchTo().alert().accept();

		/*
		 * Confirm Box Ops
		 * 
		 */

		driver.findElement(By.xpath(".//button[@onclick='generateConfirmBox()']")).click();
		String confirm_text = driver.switchTo().alert().getText();
		System.out.println("Confirm box Text=" + confirm_text);
		System.out.println("Clicking on Cancel button...");
		driver.switchTo().alert().dismiss();
		System.out.println("Text Value=" + driver.findElement(By.id("demo")).getText());

		/*
		 * Drag and Drop Handling
		 *
		 */
		
		WebElement target = driver.findElement(By.id("targetDiv"));
		WebElement source = driver.findElement(By.id("myImage"));
		Actions actD = new Actions(driver);
		actD.dragAndDrop(source, target).build().perform();
		driver.close();	
	}

}
