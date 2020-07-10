package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.LandingPage;

public class Validation extends Base {
	public static WebDriver driver;	
	public static Logger log = LogManager.getLogger(HomePage.class.getName());

	@BeforeTest
	public void setUP() throws IOException {
		driver = intializeDriver();
		log.info("Driver is initialized");
		String URL = prop.getProperty("url");
		driver.get(URL);
		log.info("Navigated to Home Page");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void validate() throws IOException {
		LandingPage landObj = new LandingPage(driver);
		String titleName = landObj.getTitle().getText();
		System.out.println(titleName);
		Assert.assertEquals(titleName, "FEATURED COURSES");
		log.info("Successfully validated text message");
		Boolean condition = landObj.getNavBar().isDisplayed();
		Assert.assertTrue(condition);
		log.info("Navigation bar is displayed");

	}

	@Test
	public void validateBanner() {
		LandingPage landObj = new LandingPage(driver);
		String bannerText=landObj.getBanner().getText();
		System.out.println(bannerText);
		Assert.assertEquals(bannerText,"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Successfully validated banner text");

	}

	@AfterTest
	public void quitMethod() {
		driver.quit();
	}

}
