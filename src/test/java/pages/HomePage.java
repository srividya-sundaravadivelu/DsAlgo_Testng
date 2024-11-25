package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.ConfigReader;
import utils.WebDriverWaitUtility;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Sign out')]")
	private WebElement signOutLink;

	@FindBy(xpath = "//a[contains(@class,'dropdown-toggle')]")
	private WebElement dropdownMenu;
	
	// alert
	@FindBy(xpath = "//*[@class='alert alert-primary']")
	WebElement alert_msg;

	@FindBy(xpath = "//a[@href='/login']")
	WebElement signin;
	@FindBy(xpath = "//a[@href='/register']")
	WebElement register;

	public Boolean isSignOutLinkVisible() {
		try {
			WebDriverWaitUtility.waitForElementToBeVisible(signOutLink);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickDropDownItem(String itemName) {
		WebDriverWaitUtility.waitForElementToBeClickable(dropdownMenu).click();
		WebElement item = driver.findElement(By.xpath("//a[text()='" + itemName + "']"));
		WebDriverWaitUtility.waitForElementToBeClickable(item).click();
	}

	public void clickGetStarted(String itemName) {
		WebElement item = driver.findElement(By.xpath("//a[@href='" + itemName.toLowerCase() + "']"));
		WebDriverWaitUtility.waitForElementToBeClickable(item).click();
	}

	public void dsalgopage() {
		driver.get(ConfigReader.getBaseUrl());
	}

//	public String getPageTitle() {
//		String title = driver.getTitle();
//		return title;
//	}	

	public void clickHomePageLink() {
		driver.get(ConfigReader.getHomeUrl());
	}

	public String alert() {
		String msg = alert_msg.getText();
		return msg;
	}

	public String home_page() {
		String title = driver.getTitle();
		return title;
	}

	public void signin_link() {
		signin.click();
	}

	public void register_link() {
		register.click();
	}

	public String register_page() {
		String title = driver.getTitle();
		return title;
	}

}