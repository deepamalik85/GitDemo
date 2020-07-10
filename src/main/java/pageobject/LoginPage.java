package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(xpath = "//input[@id='user_email']")
	WebElement email;

	private @FindBy(xpath = "//input[@id='user_password']")
	WebElement password;

	private @FindBy(xpath = "//input[@name='commit']")
	WebElement login;

	private @FindBy(xpath = "//a[@class='link-below-button']")
	WebElement forgetPass;
	
	private @FindBy(xpath="//div[@class='main-hero']/div")
	WebElement errorMsg;

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}
	public WebElement getError() {
		return errorMsg;
	}
	

	public ForgetPassPage getForgetPass() {
		forgetPass.click();
		return new ForgetPassPage();

	}

}
