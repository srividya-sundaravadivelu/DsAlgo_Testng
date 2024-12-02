package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LogHelper;
import utils.WebDriverWaitUtility;

public class LinkedListPage extends BasePage {

	@FindBy(xpath = "//a[text()='Introduction']")
	WebElement introductionLink;

	@FindBy(xpath = "//a[text()='Creating Linked LIst']")
	WebElement creatingLinkedlistLink;

	@FindBy(xpath = "//a[text()='Types of Linked List']")
	WebElement typesOfLinkedlistLLink;

	@FindBy(xpath = "//a[text()='Implement Linked List in Python']")
	WebElement implementLinkedListInPythonLink;

	@FindBy(xpath = "//a[text()='Traversal']")
	WebElement traversalLink;

	@FindBy(xpath = "//a[text()='Insertion']")
	WebElement insertionLink;

	@FindBy(xpath = "//a[text()='Deletion']")
	WebElement deletionLink;

	@FindBy(xpath = "//a[@href='/linked-list/practice']")
	WebElement practiceQuestionLinkOfLnkdList;

	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement tryHereLink;

	@FindBy(xpath = "//*[@class=' CodeMirror-line ']")
	WebElement editorInput;

	@FindBy(xpath = "//*[@id='answer_form']/button")
	WebElement runButton;

	@FindBy(id = "output")
	WebElement output;

	@FindBy(xpath = "//a[contains(@href, 'question')]")
	WebElement lListPracticeQns;

	@FindBy(xpath = "//strong//p[contains(@class,'bg-secondary')]")
	private WebElement pageHeading;

	@FindBy(xpath = "//a[@class='list-group-item']")
	List<WebElement> linkedListTopicLinks;

	public void clickLinkUnderTopicsCovered(String itemName) {
		WebElement item = driver
				.findElement(By.xpath("//a[contains(@class,'list-group-item') and text()='" + itemName + "']"));
		WebDriverWaitUtility.waitForElementToBeClickable(item).click();
	}

	public void clickIntroductionLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(introductionLink);
		introductionLink.click();
	}

	public void clickCreatingLinkedlistLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(creatingLinkedlistLink);
		creatingLinkedlistLink.click();
	}

	public void clickTypesOfLinkedlistLLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(typesOfLinkedlistLLink);
		typesOfLinkedlistLLink.click();
	}

	public void clickImplementLinkedListInPythonLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(implementLinkedListInPythonLink);
		implementLinkedListInPythonLink.click();
	}

	public void clickTraversalLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(traversalLink);
		traversalLink.click();
	}

	public void clickInsertionLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(insertionLink);
		insertionLink.click();
	}

	public void clickDeletionLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(deletionLink);
		deletionLink.click();
	}

	public void clickPracticeQuestionLinkOfLnkdList() {
		WebDriverWaitUtility.waitForElementToBeClickable(practiceQuestionLinkOfLnkdList);
		practiceQuestionLinkOfLnkdList.click();
	}

	public String getLinkedListPageTitle() {
		String title = driver.getTitle();
		return title;
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

	public void clickTryHereButton() {

		tryHereLink.click();
	}

	public List<WebElement> getLinkedListTopicLinks() {
		return linkedListTopicLinks;
	}

	public void navigateBack() {
		driver.navigate().back();
	}

}
