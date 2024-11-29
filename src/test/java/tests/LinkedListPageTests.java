package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LinkedListPage;
import utils.ConfigReader;
import utils.LogHelper;
import utils.PageNames;
@Listeners(listeners.TestListener.class)
public class LinkedListPageTests extends BaseTest {
	LinkedListPage linkedlistPage;

	@BeforeMethod
	public void LinkedListSetupBeforeMethod() throws IOException {
		login();
		linkedlistPage = new LinkedListPage();
		linkedlistPage.navigateToPage(ConfigReader.getLinkedListUrl());
		LogHelper.info("Navigated to LinkedList page: " + linkedlistPage.getCurrentUrl());
	}

	@Test(priority = 1)
	public void shouldLoadLinkedListPageSuccessfully() {
		Assert.assertEquals(linkedlistPage.getCurrentUrl(), ConfigReader.getLinkedListUrl());
		LogHelper.info("Current page is " + linkedlistPage.getCurrentUrl());
	}

	@Test
	public void shouldNavigateToIntroductionFromTopicsCovered() {
		linkedlistPage.clickLinkUnderTopicsCovered(PageNames.INTRODUCTION_PAGE);
		assertPageUrlAndHeading(ConfigReader.getIntroductionUrl(), PageNames.INTRODUCTION_PAGE);
	}

	@Test
	public void shouldNavigateToCreatingLinkedListFromTopicsCovered() {
		linkedlistPage.clickLinkUnderTopicsCovered(PageNames.CREATING_LINKED_LIST_PAGE);
		assertPageUrlAndHeading(ConfigReader.getCreatinglinkedListUrl(), PageNames.CREATING_LINKED_LIST_PAGE);
	}

	@Test
	public void shouldNavigateToTypesOfLinkedListFromTopicsCovered() {
		linkedlistPage.clickLinkUnderTopicsCovered(PageNames.TYPES_OF_LINKED_LIST_PAGE);
		assertPageUrlAndHeading(ConfigReader.getTypesOfLinkedListUrl(), PageNames.TYPES_OF_LINKED_LIST_PAGE);
	}

	@Test
	public void shouldNavigateToImplementLinkedlistInPythonFromTopicsCovered() {
		linkedlistPage.clickLinkUnderTopicsCovered(PageNames.IMPLEMENT_LINKED_LIST_IN_PYTHON_PAGE);
		assertPageUrlAndHeading(ConfigReader.getImplementLinkedListInPython(),
				PageNames.IMPLEMENT_LINKED_LIST_IN_PYTHON_PAGE);
	}

	@Test
	public void shouldNavigateToTraversalFromTopicsCovered() {
		linkedlistPage.clickLinkUnderTopicsCovered(PageNames.TRAVERSAL_PAGE);
		assertPageUrlAndHeading(ConfigReader.getTraversal(), PageNames.TRAVERSAL_PAGE);
	}

	@Test
	public void shouldNavigateToInsertionFromTopicsCovered() {
		linkedlistPage.clickLinkUnderTopicsCovered(PageNames.INSERTION_PAGE);
		assertPageUrlAndHeading(ConfigReader.getInsertion(), PageNames.INSERTION_PAGE);
	}

	@Test
	public void shouldNavigateToDeletionFromTopicsCovered() {
		linkedlistPage.clickLinkUnderTopicsCovered(PageNames.DELETION_PAGE);
		assertPageUrlAndHeading(ConfigReader.getDeletion(), PageNames.DELETION_PAGE);
	}

	@Test
	public void shouldNavigateToCreatingLinkedlistFromIntroduction() {
		linkedlistPage.navigateToPage(ConfigReader.getIntroductionUrl());
		linkedlistPage.clickCreatingLinkedlistLink();
		assertPageUrlAndHeading(ConfigReader.getCreatinglinkedListUrl(), PageNames.CREATING_LINKED_LIST_PAGE);
	}

	@Test
	public void shouldNavigateToTypesOfLinkedListFromCreatingLinkedlist() {
		linkedlistPage.navigateToPage(ConfigReader.getCreatinglinkedListUrl());
		linkedlistPage.clickTypesOfLinkedlistLLink();
		assertPageUrlAndHeading(ConfigReader.getTypesOfLinkedListUrl(), PageNames.TYPES_OF_LINKED_LIST_PAGE);
	}

	@Test
	public void shouldNavigateToImplementLListInPythonFromTypesOfLinkedlist() {
		linkedlistPage.navigateToPage(ConfigReader.getTypesOfLinkedListUrl());
		linkedlistPage.clickImplementLinkedListInPythonLink();
		assertPageUrlAndHeading(ConfigReader.getImplementLinkedListInPython(),
				PageNames.IMPLEMENT_LINKED_LIST_IN_PYTHON_PAGE);
	}

	@Test
	public void shouldNavigateToTraversalFromImplementLListInpython() {
		linkedlistPage.navigateToPage(ConfigReader.getImplementLinkedListInPython());
		linkedlistPage.clickTraversalLink();
		assertPageUrlAndHeading(ConfigReader.getTraversal(), PageNames.TRAVERSAL_PAGE);
	}

	@Test
	public void shouldNavigateToInsertionFromTraversal() {
		linkedlistPage.navigateToPage(ConfigReader.getTraversal());
		linkedlistPage.clickInsertionLink();
		assertPageUrlAndHeading(ConfigReader.getInsertion(), PageNames.INSERTION_PAGE);
	}

	@Test
	public void shouldNavigateToDeletionFromInsertion() {
		linkedlistPage.navigateToPage(ConfigReader.getInsertion());
		linkedlistPage.clickDeletionLink();
		assertPageUrlAndHeading(ConfigReader.getDeletion(), PageNames.DELETION_PAGE);
	}

	@Test
	public void shouldNavigateToTryEditorFromEachTopic() {
		linkedlistPage.navigateToPage(ConfigReader.getLinkedListUrl());
		List<WebElement> topicLinks = linkedlistPage.getLinkedListTopicLinks();
		LogHelper.info("Number of Topics found: " + topicLinks.size());
		// Loop through each link
		for (int i = 0; i < topicLinks.size(); i++) {
			topicLinks = linkedlistPage.getLinkedListTopicLinks();
			// Get the current link
			WebElement topicLink = topicLinks.get(i);
			topicLink.click();
			linkedlistPage.clickTryHereButton();
			String expectedUrl = ConfigReader.getTryEditorUrl();
			String actualUrl = linkedlistPage.getCurrentUrl();
			LogHelper.info("Actual Output: " + actualUrl);
			LogHelper.info("Comparing the actual output with the expected output: " + expectedUrl);
			// Validate the URL
			Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch for question link: " + (i + 1));

			// Navigate back to the main page
			linkedlistPage.navigateBack();
			linkedlistPage.navigateBack();
		}

		linkedlistPage.navigateToPage(ConfigReader.getDeletion());
		linkedlistPage.clickTryHereButton();
		Assert.assertEquals(linkedlistPage.getCurrentUrl(), ConfigReader.getTryEditorUrl());
		LogHelper.info("Navigated to Try Editor: " + linkedlistPage.getCurrentUrl());
	}

	@Test
	public void shouldNavigateToPracticeQuestionsFromDeletion() {
		linkedlistPage.navigateToPage(ConfigReader.getDeletion());
		linkedlistPage.clickPracticeQuestionLinkOfLnkdList();
		assertPageUrlAndHeading(ConfigReader.getLinkedListPracticeQuestionUrl(),
				PageNames.LINKED_LIST_PRACTICE_QUESTIONS_PAGE);
	}

	private void assertPageUrlAndHeading(String expectedUrl, String expectedHeading) {
		Assert.assertEquals(linkedlistPage.getCurrentUrl(), expectedUrl);
		LogHelper.info("Current page is: " + linkedlistPage.getCurrentUrl());
		Assert.assertEquals(linkedlistPage.getPageHeading(), expectedHeading);
		LogHelper.info("Page Heading is: " + linkedlistPage.getPageHeading());
	}

}
