package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobject.ForgetPassPage;
import pageobject.LandingPage;
import pageobject.LoginPage;

public class HomePage extends Base {
	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePage.class.getName());

	@BeforeTest
	public void setUP() throws IOException {
		driver = intializeDriver();
		log.info("Driver is initialized");

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException {
		String URL = prop.getProperty("url");
		driver.get(URL);
		log.info("Navigated to Home Page");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LandingPage landobj = new LandingPage(driver);
		LoginPage logobj = landobj.getLogin();
		logobj.getEmail().sendKeys(username);
		logobj.getPassword().sendKeys(password);
		logobj.getLogin().click();
		log.info("User validation done");
		// ForgetPassPage forobj=logobj.getForgetPass();
		// forobj.getEmail().sendKeys("deepamalik85@gmail.com");
		// forobj.sendInstructions().click();

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];

		data[0][0] = "deepamalik85@gmail.com";
		data[0][1] = "12345";

		data[1][0] = "nsaroha616@gmail.com";
		data[1][1] = "67890";

		return data;

	}

	@AfterTest
	public void quitMethod() {
		driver.quit();
	}

}
