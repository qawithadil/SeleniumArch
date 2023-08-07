package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static WebDriver driver;

	@FindBy(id = "name")
	private WebElement txt_userName;

	@FindBy(id = "password")
	private WebElement txt_password;

	@FindBy(id = "login")
	private WebElement btn_login;

	@FindBy(id = "logout")
	private WebElement btn_logout;

	@FindBy(xpath = "//div[@id='pageProfile']/h1")
	private WebElement Welcome_text;

	@FindBy(xpath = "//small[@id='passwordHelp']/following-sibling::div")
	private WebElement error_msg;

	public void enterCreds(String uName, String pass) {

		txt_userName.clear();
		txt_password.clear();
		txt_userName.sendKeys(uName);
		txt_password.sendKeys(pass);
	}

	public void clickLogin() {
		btn_login.click();
	}

	public void clickLogout() {
		btn_logout.click();
	}

	public String welcomeText() {

		return Welcome_text.getText();
	}

	public String error_txt() {
		return error_msg.getText();
	}

}
