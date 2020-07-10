package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgetPassPage {
	WebDriver driver;
	private @FindBy(xpath = "//input[@id='user_email']")
	WebElement email;
	
	private @FindBy(xpath="//input[@name='commit']")
	WebElement send;
	
	public WebElement getEmail() {
		return email;
	}
	
	public WebElement sendInstructions() {
		return send;
	}

}
