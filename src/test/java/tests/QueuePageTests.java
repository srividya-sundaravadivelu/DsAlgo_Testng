package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.QueuePage;
import utils.ConfigReader;
import utils.LogHelper;
import utils.PageNames;

public class QueuePageTests extends BaseTest{
	
	QueuePage queuePage;

	@BeforeMethod(alwaysRun = true)
	public void queueSetupBeforeMethod() throws IOException {
		login();
		queuePage = new QueuePage();
		queuePage.navigateToPage(ConfigReader.getQueueUrl());
		LogHelper.info("Navigated to Queue page: " + queuePage.getCurrentUrl());
	}

	@Test(priority = 1,groups={"functional"})
	public void shouldLoadQueuePageSuccessfully() {
		Assert.assertEquals(queuePage.getCurrentUrl(), ConfigReader.getQueueUrl());
		LogHelper.info("Current page is " + queuePage.getCurrentUrl());
	}
	
	@Test(groups={"functional"})
	public void shouldNavigateToImplementationOfQueueInPythonFromTopicsCovered() {
		queuePage.clickImplementationofQueueinPythonLink();
		assertPageUrlAndHeading(ConfigReader.getImplementationofQueueinPython(), PageNames.IMPLEMENTATION_OF_QUEUE_IN_PYTHON);
	}
	
	@Test(groups={"functional"})
	public void shouldNavigateToImplementationUsingCollectionsDequeFromTopicsCovered() {
		queuePage.clickImplementationUsingCollectionsLink();
		assertPageUrlAndHeading(ConfigReader.getImplementationUsingCollectionsDeque(), PageNames.IMPLEMENTAION_USING_COLLECTIONS_DEQUEUE);
	}
	
	@Test(groups={"functional"})
	public void shouldNavigateToImplementationUsingArrayFromTopicsCovered() {
		queuePage.clickImplementationUsingArrayLink();
		assertPageUrlAndHeading(ConfigReader.getImplementationUsingArrayinQueue(), PageNames.QUEUE_IMPLEMENTATION_USING_ARRAY);
	}
	
	@Test(groups={"functional"})
	public void shouldNavigateToQueueOperationsFromTopicsCovered() {
		queuePage.clickQueueOperationsLink();
		assertPageUrlAndHeading(ConfigReader.getQueueOperations(), PageNames.QUEUE_OPERATIONS);
	}
	
	@Test(groups={"functional"})
	public void shouldNavigateToImplementationUsingCollectionsDequeFromImplementationOfQueueInPython() {
		queuePage.navigateToPage(ConfigReader.getImplementationofQueueinPython());
		queuePage.clickImplementationUsingCollectionsLink();
		assertPageUrlAndHeading(ConfigReader.getImplementationUsingCollectionsDeque(), PageNames.IMPLEMENTAION_USING_COLLECTIONS_DEQUEUE);
	}
	
	@Test(groups={"functional"})
	public void shouldNavigateToImplementationUsingArrayFromImplementationUsingCollectionsDeque() {
		queuePage.navigateToPage(ConfigReader.getImplementationUsingCollectionsDeque());
		queuePage.clickImplementationUsingArrayLink();
		assertPageUrlAndHeading(ConfigReader.getImplementationUsingArrayinQueue(), PageNames.QUEUE_IMPLEMENTATION_USING_ARRAY);
	}
	
	@Test(groups={"functional"})
	public void shouldNavigateToQueueOperationsFromImplementationUsingArray() {
		queuePage.navigateToPage(ConfigReader.getImplementationUsingArrayinQueue());
		queuePage.clickQueueOperationsLink();
		assertPageUrlAndHeading(ConfigReader.getQueueOperations(), PageNames.QUEUE_OPERATIONS);
	}	
	
	@Test(groups={"functional"})
	public void shouldNavigateToPracticeQuestionsFromQueueOperations() {
		queuePage.navigateToPage(ConfigReader.getQueueOperations());
		queuePage.clickPracticeQuesLink();
		assertPageUrlAndHeading(ConfigReader.getQueuePracticeUrl(), PageNames.QUEUE_PRACTICE_QUESTIONS);
	}
	
	@Test(groups={"functional"})
	public void shouldNavigateToTryEditorFromImplementationOfQueueInPython() {
		queuePage.navigateToPage(ConfigReader.getImplementationofQueueinPython());
		queuePage.clickTryHereButton();
		Assert.assertEquals(queuePage.getCurrentUrl(), ConfigReader.getTryEditorUrl());
		LogHelper.info("Navigated to Try Editor: " + queuePage.getCurrentUrl());
	}
	
	@Test(groups={"functional"})
	public void shouldNavigateToTryEditorFromImplementationUsingCollectionsDeque() {
		queuePage.navigateToPage(ConfigReader.getImplementationUsingCollectionsDeque());
		queuePage.clickTryHereButton();
		Assert.assertEquals(queuePage.getCurrentUrl(), ConfigReader.getTryEditorUrl());
		LogHelper.info("Navigated to Try Editor: " + queuePage.getCurrentUrl());
	}
	
	@Test(groups={"functional"})
	public void shouldNavigateToTryEditorFromImplementationUsingArray() {
		queuePage.navigateToPage(ConfigReader.getImplementationUsingArrayinQueue());
		queuePage.clickTryHereButton();
		Assert.assertEquals(queuePage.getCurrentUrl(), ConfigReader.getTryEditorUrl());
		LogHelper.info("Navigated to Try Editor: " + queuePage.getCurrentUrl());
	}
	
	@Test(groups={"functional"})
	public void shouldNavigateToTryEditorFromQueueOperations() {
		queuePage.navigateToPage(ConfigReader.getQueueOperations());
		queuePage.clickTryHereButton();
		Assert.assertEquals(queuePage.getCurrentUrl(), ConfigReader.getTryEditorUrl());
		LogHelper.info("Navigated to Try Editor: " + queuePage.getCurrentUrl());
	}
	
	private void assertPageUrlAndHeading(String expectedUrl, String expectedHeading) {
		Assert.assertEquals(queuePage.getCurrentUrl(), expectedUrl);
		Assert.assertEquals(queuePage.getPageHeading(), expectedHeading);
		LogHelper.info("Current page is: " + queuePage.getCurrentUrl());
	}

}
