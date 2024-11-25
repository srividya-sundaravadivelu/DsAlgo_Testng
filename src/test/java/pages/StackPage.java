package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WebDriverWaitUtility;

public class StackPage extends BasePage {
	
	public StackPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='Operations in Stack']")
	private WebElement operationsInStackLink;
	
	@FindBy(xpath="//a[text()='Implementation']")
	private WebElement implementationLink;
	
	@FindBy(xpath="//a[text()='Applications']")
	private WebElement applicationLink;
	
	@FindBy(xpath = "//a[@href='/tryEditor']")
	private WebElement tryEditorLink;

	@FindBy(xpath = "//a[text()='Practice Questions']")
	private WebElement practiceLink;

	public void clickOperationsInStackLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(operationsInStackLink);
		operationsInStackLink.click();
	}

	public void clickImplementationLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(implementationLink);
		implementationLink.click();
	}
	
	public void clickApplicationsLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(applicationLink);
		applicationLink.click();
	}
	
	public void clickTryHereButton() {
		WebDriverWaitUtility.waitForElementToBeClickable(tryEditorLink);
		tryEditorLink.click();
	}
	
	public void clickPracticeQuesLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(practiceLink);
		practiceLink.click();
	}
}