package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DataStructuresIntroductionPage;
import utils.ConfigReader;
import utils.LogHelper;
import utils.PageNames;

public class DataStructuresIntroductionPageTests extends BaseTest {
	DataStructuresIntroductionPage dataStructuresIntroductionPage;
	
	@BeforeMethod(alwaysRun = true)
	public void dataStructuresIntroductionPageSetupBeforeMethod() throws IOException {
		login();
		dataStructuresIntroductionPage = new DataStructuresIntroductionPage();
		dataStructuresIntroductionPage.navigateToPage(ConfigReader.getDataStructuresIntroductionUrl());
		LogHelper.info("Navigated to Data Strures Introduction page: " + dataStructuresIntroductionPage.getCurrentUrl());
	}
	@Test(priority = 1,groups={"functional"})
	public void shouldLoadDataStructuresIntroductionPageSuccessfully() {
		Assert.assertEquals(dataStructuresIntroductionPage.getCurrentUrl(), ConfigReader.getDataStructuresIntroductionUrl());
		LogHelper.info("Current page is " + dataStructuresIntroductionPage.getCurrentUrl());
	}

	@Test(groups={"functional"})
	public void shouldNavigateToTimeComplexityPageFromTopicsCovered() {
		dataStructuresIntroductionPage.clickLinkUnderTopicsCovered(PageNames.TIME_COMPLEXITY_PAGE);
		assertPageUrlAndHeading(ConfigReader.getDataStructuresTimeComplexityUrl() , PageNames.TIME_COMPLEXITY_PAGE);
	}

	@Test(groups={"functional"})
	public void shouldNavigateToPracticeQuestionsPageFromTimeComplexityPage() {
		dataStructuresIntroductionPage.navigateToPage(ConfigReader.getDataStructuresTimeComplexityUrl());
		dataStructuresIntroductionPage.clickPracticeLink();
		assertPageUrlAndHeading(ConfigReader.getDataStructuresPracticeUrl(), PageNames.PRACTICE_QUESTIONS_PAGE);
	}

	@Test(groups={"functional"})
	public void shouldNavigateToTryEditorFromTimeComplexityPage() {
		dataStructuresIntroductionPage.navigateToPage(ConfigReader.getDataStructuresTimeComplexityUrl());
		dataStructuresIntroductionPage.clickTryHereButton();
		Assert.assertEquals(dataStructuresIntroductionPage.getCurrentUrl(), ConfigReader.getTryEditorUrl());
		LogHelper.info("Navigated to Try Editor: " + dataStructuresIntroductionPage.getCurrentUrl());
	}
	
	private void assertPageUrlAndHeading(String expectedUrl, String expectedHeading) {
		Assert.assertEquals(dataStructuresIntroductionPage.getCurrentUrl(), expectedUrl);
		Assert.assertEquals(dataStructuresIntroductionPage.getPageTitle(), expectedHeading);
		LogHelper.info("Current page is: " + dataStructuresIntroductionPage.getCurrentUrl());
	}
}

