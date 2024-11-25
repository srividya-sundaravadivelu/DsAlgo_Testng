package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WebDriverWaitUtility;

public class QueuePage extends BasePage {
	
	public QueuePage(WebDriver driver) {
		super(driver);
	}
	
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
}