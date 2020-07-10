package stepdefinations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageobject.LandingPage;
import pageobject.LoginPage;

@RunWith(Cucumber.class)
public class StepDefinationOne extends Base {
	static public WebDriver driver;

	@Given("^User is on landing page$")
	public void user_is_on_landing_page() throws IOException {
		driver = intializeDriver();
		String URL = prop.getProperty("url");
		driver.get(URL);

	}

	@When("^User login into application with username \"([^\"]*)\"and password \"([^\"]*)\"$")
	public void user_login_into_application_with_username_somethingand_password_something(String strArg1,
			String strArg2) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LandingPage landobj = new LandingPage(driver);
		LoginPage logobj = landobj.getLogin();
		logobj.getEmail().sendKeys(strArg1);
		logobj.getPassword().sendKeys(strArg2);
		logobj.getLogin().click();

	}

	@When("^User login into application with wrong username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_login_into_application_with_wrong_username_something_and_password_something(String strArg1,
			String strArg2) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LandingPage landobj = new LandingPage(driver);
		LoginPage logobj = landobj.getLogin();
		logobj.getEmail().sendKeys(strArg1);
		logobj.getPassword().sendKeys(strArg2);
		logobj.getLogin().click();

	}

	/*
	 * @When("^User login into application with wrong username and password$")
	 * public void user_login_into_application_with_wrong_username_and_password() {
	 * 
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); LandingPage
	 * landobj = new LandingPage(driver); LoginPage logobj = landobj.getLogin();
	 * logobj.getEmail().sendKeys("deepamalik85");
	 * logobj.getPassword().sendKeys("12345"); logobj.getLogin().click();
	 * 
	 * }
	 */

	@Then("^Invalid email or password is displayed$")
	public void invalid_email_or_password_is_displayed() {

		LoginPage logobj = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String errorText = logobj.getError().getText();
		String formatText = errorText.trim();
		System.out.println(formatText);
		Assert.assertEquals(formatText, "Invalid email or password.");
		driver.quit();

	}

}