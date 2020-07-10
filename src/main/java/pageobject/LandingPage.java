package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy(css = "a[href*='sign_in']") WebElement login;
	private @FindBy(xpath = "//h2[contains(text(),'Featured Courses')]") WebElement title;
	private @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']") WebElement navBar;
	private @FindBy(css = "div[class*=\"video-banner\"] h3") WebElement banner;
	private By popUp=By.xpath("//button[contains(text(),'NO THANKS')]");

	public LoginPage getLogin() {
		login.click();
		LoginPage logobj = new LoginPage(driver);
		return logobj;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getNavBar() {
		return navBar;
	}

	public WebElement getBanner() {
		return banner;
	}
	public int getPopUpSize() {
		return driver.findElements(popUp).size();
	}

}
