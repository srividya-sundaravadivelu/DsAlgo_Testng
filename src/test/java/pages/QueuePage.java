package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.LogHelper;
import utils.WebDriverWaitUtility;

public class QueuePage extends BasePage {
	
	@FindBy(xpath="//a[text()='Implementation of Queue in Python']")
	private WebElement implementationofQueueinPythonLink;
	
	@FindBy(xpath="//a[text()='Implementation using collections.deque']")
	private WebElement implementationUsingCollectionsLink;
	
	@FindBy(xpath="//a[text()='Implementation using array']")
	private WebElement implementationUsingArrayLink;
	
	@FindBy(xpath="//a[text()='Queue Operations']")
	private WebElement queueOperations;
	
	@FindBy(xpath = "//a[@href='/tryEditor']")
	private WebElement tryEditorLink;

	@FindBy(xpath = "//a[text()='Practice Questions']")
	private WebElement practiceLink;
	
	@FindBy(xpath = "//strong//p[contains(@class,'bg-secondary')]")
	private WebElement pageHeading;

	public void clickImplementationofQueueinPythonLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(implementationofQueueinPythonLink);
		implementationofQueueinPythonLink.click();
	}

	public void clickImplementationUsingCollectionsLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(implementationUsingCollectionsLink);
		implementationUsingCollectionsLink.click();
	}
	
	public void clickImplementationUsingArrayLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(implementationUsingArrayLink);
		implementationUsingArrayLink.click();
	}
	
	public void clickQueueOperationsLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(queueOperations);
		queueOperations.click();
	}
	
	public void clickTryHereButton() {
		WebDriverWaitUtility.waitForElementToBeClickable(tryEditorLink);
		tryEditorLink.click();
	}
	
	public void clickPracticeQuesLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(practiceLink);
		practiceLink.click();
	}
	
	public String getPageHeading() {
		try {
			WebDriverWaitUtility.waitForElementToBeVisible(pageHeading);
			return pageHeading.getText();
		} catch (TimeoutException e) {
			LogHelper.error("Page heading element is missing. This indicates a missing functionality.");
			throw new AssertionError("functionality not implemented", e);
		}
	}
}