package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WebDriverWaitUtility;

public class LandingPage extends BasePage {

	public LandingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@href='/home']")
	WebElement getStartlink;
	
	public void clickGetStartedLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(getStartlink);
		getStartlink.click();
	}

}
