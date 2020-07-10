package stepdefinations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.LandingPage;
import pageobject.LoginPage;

public class StepDefinationLogin extends Base {

	@Given("^Initalize the chrome browser$")
	public void initalize_the_chrome_browser() throws IOException {
		driver = intializeDriver();
	}

	@And("^Navigate to \"([^\"]*)\" website$")
	public void navigate_to_something_website(String strArg1) {
		driver.get(strArg1);

	}

	@And("^click on Login button$")
	public void click_on_login_button() {
		LandingPage landobj = new LandingPage(driver);
		if (landobj.getPopUpSize() > 0) {
			landobj.getLogin();
		} else {
			landobj.getLogin();
		}

	}

	@When("^user login with (.+) and (.+)$")
	public void user_login_with_and(String username, String password) {
		LoginPage logobj = new LoginPage(driver);
		logobj.getEmail().sendKeys(username);
		logobj.getPassword().sendKeys(password);
		logobj.getLogin().click();
	}

	@Then("Invalid email or password error displayed")
	public void invalid_email_or_password_error_displayed() {
		LoginPage logobj = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String errorText = logobj.getError().getText();
		String formatText = errorText.trim();
		Assert.assertEquals(formatText, "Invalid email or password.");
		driver.quit();
	}
}
