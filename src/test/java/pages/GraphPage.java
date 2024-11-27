package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.LogHelper;
import utils.WebDriverWaitUtility;

public class GraphPage extends BasePage {

	@FindBy(xpath = "//li//a[text()='Graph Representations']")
	private WebElement graphRepresentationsLink;

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

	public void clickGraphRepresentationsLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(graphRepresentationsLink);
		graphRepresentationsLink.click();
	}

	public void clickTryHereButton() {
		WebDriverWaitUtility.waitForElementToBeClickable(tryEditorLink);
		tryEditorLink.click();
	}

	public void clickPracticeLink() {
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