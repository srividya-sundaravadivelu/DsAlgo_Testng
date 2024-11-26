package tests;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.GraphPage;
import utils.ConfigReader;
import utils.LogHelper;
import utils.PageNames;

public class GraphPageTests extends BaseTest {

	GraphPage graphPage;

	@BeforeMethod
	public void graphSetupBeforeMethod() throws IOException {
		login();
		graphPage = testContext.getGraphPage();
		graphPage.navigateToPage(ConfigReader.getGraphHomeUrl());
		LogHelper.info("Navigated to Graph page: " + graphPage.getCurrentUrl());
	}

	@Test(priority = 1)
	public void shouldLoadGraphHomePageSuccessfully() {
		Assert.assertEquals(graphPage.getCurrentUrl(), ConfigReader.getGraphHomeUrl());
		LogHelper.info("Current page is " + graphPage.getCurrentUrl());
	}

	@Test
	public void shouldNavigateToGraphPageFromTopicsCovered() {
		graphPage.clickLinkUnderTopicsCovered(PageNames.GRAPH_PAGE);
		assertPageUrlAndHeading(ConfigReader.getGraphUrl(), PageNames.GRAPH_PAGE);
	}

	@Test
	public void shouldNavigateToGraphRepresentationsPageFromTopicsCovered() {
		graphPage.clickLinkUnderTopicsCovered(PageNames.GRAPH_REPRESENTATIONS_PAGE);
		assertPageUrlAndHeading(ConfigReader.getGraphRepresentationsUrl(), PageNames.GRAPH_REPRESENTATIONS_PAGE);
	}

	@Test
	public void shouldNavigateToGraphRepresentationsPageFromGraph() {
		graphPage.navigateToPage(ConfigReader.getGraphUrl());
		graphPage.clickGraphRepresentationsLink();
		assertPageUrlAndHeading(ConfigReader.getGraphRepresentationsUrl(), PageNames.GRAPH_REPRESENTATIONS_PAGE);
	}

	@Test
	public void shouldNavigateToPracticeQuestionsPageFromGraphRepresentations() {
		graphPage.navigateToPage(ConfigReader.getGraphRepresentationsUrl());
		graphPage.clickPracticeLink();
		assertPageUrlAndHeading(ConfigReader.getGraphPracticeUrl(), PageNames.GRAPH_PRACTICE_QUESTIONS_PAGE);
	}

	@Test
	public void shouldNavigateToTryEditorFromGraph() {
		graphPage.navigateToPage(ConfigReader.getGraphUrl());
		graphPage.clickTryHereButton();
		Assert.assertEquals(graphPage.getCurrentUrl(), ConfigReader.getTryEditorUrl());
		LogHelper.info("Navigated to Try Editor: " + graphPage.getCurrentUrl());
	}

	@Test
	public void shouldNavigateToTryEditorFromGraphRepresentations() {
		graphPage.navigateToPage(ConfigReader.getGraphRepresentationsUrl());
		graphPage.clickTryHereButton();
		Assert.assertEquals(graphPage.getCurrentUrl(), ConfigReader.getTryEditorUrl());
		LogHelper.info("Navigated to Try Editor: " + graphPage.getCurrentUrl());
	}

	private void assertPageUrlAndHeading(String expectedUrl, String expectedHeading) {
		Assert.assertEquals(graphPage.getCurrentUrl(), expectedUrl);
		Assert.assertEquals(graphPage.getPageHeading(), expectedHeading);
		LogHelper.info("Current page is: " + graphPage.getCurrentUrl());
	}
}
