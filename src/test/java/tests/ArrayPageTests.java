package tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import data.ArrayQuestionsDataProvider;
import pages.ArrayPage;
import utils.ConfigReader;
import utils.LogHelper;
import utils.PageNames;

public class ArrayPageTests extends BaseTest {
	ArrayPage arrayPage;

	@BeforeMethod
	public void arraySetupBeforeMethod() throws IOException {
		login();
		arrayPage = testContext.getArrayPage();
		arrayPage.navigateToPage(ConfigReader.getArrayUrl());
		LogHelper.info("Navigated to Array page: " + arrayPage.getCurrentUrl());
	}

	@Test(priority = 1)
	public void shouldLoadArrayPageSuccessfully() {
		Assert.assertEquals(arrayPage.getCurrentUrl(), ConfigReader.getArrayUrl());
		LogHelper.info("Current page is " + arrayPage.getCurrentUrl());
	}

	@Test
	public void shouldNavigateToArraysInPythonPageFromTopicsCovered() {
		arrayPage.clickLinkUnderTopicsCovered("Arrays in Python");
		assertPageUrlAndHeading(ConfigReader.getArraysInPythonUrl(), PageNames.ARRAYS_IN_PYTHON_PAGE);
	}

	@Test
	public void shouldNavigateToArraysUsingListPageFromTopicsCovered() {
		arrayPage.clickLinkUnderTopicsCovered("Arrays Using List");
		assertPageUrlAndHeading(ConfigReader.getArraysUsingListUrl(), PageNames.ARRAYS_USING_LIST_PAGE);
	}

	@Test
	public void shouldNavigateToBasicOperationsInListsPageFromTopicsCovered() {
		arrayPage.clickLinkUnderTopicsCovered("Basic Operations in Lists");
		assertPageUrlAndHeading(ConfigReader.getBasicOperationsInListsUrl(), PageNames.BASIC_OPERATIONS_IN_LISTS);
	}

	@Test
	public void shouldNavigateToApplicationsOfArrayPageFromTopicsCovered() {
		arrayPage.clickLinkUnderTopicsCovered("Applications of Array");
		assertPageUrlAndHeading(ConfigReader.getApplicationsOfArrayUrl(), PageNames.APPLICATIONS_OF_ARRAY);
	}

	@Test
	public void shouldNavigateToArraysInPythonPageFromArray() {
		arrayPage.navigateToPage(ConfigReader.getArrayUrl());
		arrayPage.clickArraysInPythonlink();
		assertPageUrlAndHeading(ConfigReader.getArraysInPythonUrl(), PageNames.ARRAYS_IN_PYTHON_PAGE);
	}

	@Test
	public void shouldNavigateToTryEditorFromArraysInPythonPage() {
		arrayPage.navigateToPage(ConfigReader.getArraysInPythonUrl());
		arrayPage.clickTryHereButton();
		Assert.assertEquals(arrayPage.getCurrentUrl(), ConfigReader.getTryEditorUrl());
		LogHelper.info("Navigated to Try Editor: " + arrayPage.getCurrentUrl());
	}

	@Test
	public void shouldNavigateToArraysUsingListPageFromArraysInPython() {
		arrayPage.navigateToPage(ConfigReader.getArraysInPythonUrl());
		arrayPage.clickArraysUsingList();
		assertPageUrlAndHeading(ConfigReader.getArraysUsingListUrl(), PageNames.ARRAYS_USING_LIST_PAGE);
	}

	@Test
	public void shouldNavigateToTryEditorFromArraysUsingListPage() {
		arrayPage.navigateToPage(ConfigReader.getArraysUsingListUrl());
		arrayPage.clickTryHereButton();
		Assert.assertEquals(arrayPage.getCurrentUrl(), ConfigReader.getTryEditorUrl());
		LogHelper.info("Navigated to Try Editor: " + arrayPage.getCurrentUrl());
	}

	@Test
	public void shouldNavigateToBasicOperationsInListsFromArraysUsingList() {
		arrayPage.navigateToPage(ConfigReader.getArraysUsingListUrl());
		arrayPage.clickBasicOperationsInLists();
		assertPageUrlAndHeading(ConfigReader.getBasicOperationsInListsUrl(), PageNames.BASIC_OPERATIONS_IN_LISTS);
	}

	@Test
	public void shouldNavigateToTryEditorFromBasicOperationsInLists() {
		arrayPage.navigateToPage(ConfigReader.getBasicOperationsInListsUrl());
		arrayPage.clickTryHereButton();
		Assert.assertEquals(arrayPage.getCurrentUrl(), ConfigReader.getTryEditorUrl());
		LogHelper.info("Navigated to Try Editor: " + arrayPage.getCurrentUrl());
	}

	@Test
	public void shouldNavigateToApplicationsOfArrayFromBasicOperationsInLists() {
		arrayPage.navigateToPage(ConfigReader.getBasicOperationsInListsUrl());
		arrayPage.clickApplicationsOfArray();
		assertPageUrlAndHeading(ConfigReader.getApplicationsOfArrayUrl(), PageNames.APPLICATIONS_OF_ARRAY);
	}

	@Test
	public void shouldNavigateToTryEditorFromApplicationsOfArray() {
		arrayPage.navigateToPage(ConfigReader.getApplicationsOfArrayUrl());
		arrayPage.clickTryHereButton();
		Assert.assertEquals(arrayPage.getCurrentUrl(), ConfigReader.getTryEditorUrl());
		LogHelper.info("Navigated to Try Editor: " + arrayPage.getCurrentUrl());
	}

	@Test
	public void shouldNavigateToPracticeQuestionsPageFromApplicationsOfArray() {
		arrayPage.navigateToPage(ConfigReader.getApplicationsOfArrayUrl());
		arrayPage.clickPracticeQuestionslink();
		// assertPageUrlAndHeading(ConfigReader.getArrayPracticeQuestionsUrl(),
		// arrayPage.getArrayPageTitle());
		Assert.assertEquals(arrayPage.getCurrentUrl(), ConfigReader.getArrayPracticeQuestionsUrl());
		LogHelper.info("Navigated to Practice Questions: " + arrayPage.getCurrentUrl());
	}

	@Test
	public void shouldNavigateToPracticeQuestionsFromQuestionsPage() {
		arrayPage.navigateToPage(ConfigReader.getArrayPracticeQuestionsUrl());
		// Get all question links from the page
		List<WebElement> questionLinks = arrayPage.getAllQuestionLinks();
		LogHelper.info("Number of Questions found: " + questionLinks.size());
		// Loop through each link
		for (int i = 0; i < questionLinks.size(); i++) {
			questionLinks = arrayPage.getAllQuestionLinks();
			// Get the current link
			WebElement questionLink = questionLinks.get(i);
			// Extract the expected URL from the link
			String expectedUrl = arrayPage.getQuestionLinkHref(questionLink);
			// Click the link
			arrayPage.clickQuestionlink(questionLink);
			String actualUrl = arrayPage.getCurrentUrl();
			LogHelper.info("Actual Output: " + actualUrl);
			LogHelper.info("Comparing the actual output with the expected output: " + expectedUrl);
			// Validate the URL
			Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch for question link: " + (i + 1));

			// Navigate back to the main page
			arrayPage.navigateBack();
		}

	}

	@Test(dataProvider = "validPythonCodeForRunDataProvider", dataProviderClass = ArrayQuestionsDataProvider.class)
	public void shouldRunValidPythonCode(Map<String, String> rowData) throws IOException {
		arrayPage.navigateToPage(ConfigReader.getArrayPracticeQuestionsUrl());
		String questionTitle = rowData.get("questionTitle");
		LogHelper.info("validPythonCodeForRunDataProvider: " + questionTitle);
		arrayPage.clickQuestionLinkByTitle(questionTitle);
		String pythonCode = rowData.get("pythonCode");
		String expectedResult = rowData.get("Result");
		arrayPage.enterCodeInEditor(pythonCode);
		arrayPage.clickRunBtn();
		String actualResult = arrayPage.getActualResult();

		LogHelper.info("Actual Output: " + actualResult);
		LogHelper.info("Comparing the actual output with the expected output: " + expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(dataProvider = "validPythonCodeForSubmitDataProvider", dataProviderClass = ArrayQuestionsDataProvider.class)
	public void shouldSubmitValidPythonCode(Map<String, String> rowData) throws IOException {
		arrayPage.navigateToPage(ConfigReader.getArrayPracticeQuestionsUrl());
		String questionTitle = rowData.get("questionTitle");
		LogHelper.info("validPythonCodeForSubmitDataProvider: " + questionTitle);
		arrayPage.clickQuestionLinkByTitle(questionTitle);
		String pythonCode = rowData.get("pythonCode");
		String expectedResult = rowData.get("Result");
		arrayPage.enterCodeInEditor(pythonCode);
		arrayPage.clickSubmitBtn();
		String actualResult = arrayPage.getActualResult();

		LogHelper.info("Actual Output: " + actualResult);
		LogHelper.info("Comparing the actual output with the expected output: " + expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(dataProvider = "invalidPythonCodeForRunDataProvider", dataProviderClass = ArrayQuestionsDataProvider.class)
	public void shouldVerifyInvalidPythonCode(Map<String, String> rowData) throws IOException {

		arrayPage.navigateToPage(ConfigReader.getArrayPracticeQuestionsUrl());
		String questionTitle = rowData.get("questionTitle");
		LogHelper.info("shouldVerifyInvalidPythonCode: " + questionTitle);
		arrayPage.clickQuestionLinkByTitle(questionTitle);
		String pythonCode = rowData.get("pythonCode");
		String expectedResult = rowData.get("Result");
		arrayPage.enterCodeInEditor(pythonCode);
		arrayPage.clickRunBtn();
		String actualResult = arrayPage.getErrorText();

		LogHelper.info("Actual Output: " + actualResult);
		LogHelper.info("Comparing the actual output with the expected output: " + expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
	}

	private void assertPageUrlAndHeading(String expectedUrl, String expectedHeading) {
		Assert.assertEquals(arrayPage.getCurrentUrl(), expectedUrl);
		Assert.assertEquals(arrayPage.getPageHeading(), expectedHeading);
		LogHelper.info("Current page is: " + arrayPage.getCurrentUrl());
	}

}
