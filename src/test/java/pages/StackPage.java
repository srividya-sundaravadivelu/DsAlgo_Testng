package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.LogHelper;
import utils.WebDriverWaitUtility;

public class StackPage extends BasePage {
	
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
	
	@FindBy(xpath = "//strong//p[contains(@class,'bg-secondary')]")
	private WebElement pageHeading;
	
	
	
	public void clickLinkUnderTopicsCovered(String itemName) {
		WebElement item = driver
				.findElement(By.xpath("//a[contains(@class,'list-group-item') and text()='" + itemName + "']"));
		WebDriverWaitUtility.waitForElementToBeClickable(item).click();
	}

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