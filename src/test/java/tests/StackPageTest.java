package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.StackPage;
import utils.ConfigReader;
import utils.LogHelper;
import utils.PageNames;

public class StackPageTest extends BaseTest {
	//@Listeners(listeners.TestListener.class)
	 

		StackPage stackPage;

		@BeforeMethod(alwaysRun = true)
		public void graphSetupBeforeMethod() throws IOException {
			login();
			stackPage = new StackPage();
			stackPage.navigateToPage(ConfigReader.getStackUrl());
			LogHelper.info("Navigated to Stack page: " + stackPage.getCurrentUrl());
		}

		@Test(priority = 1,groups={"functional"})
		public void shouldLoadStackHomePageSuccessfully() {
			Assert.assertEquals(stackPage.getCurrentUrl(), ConfigReader.getStackUrl());
			LogHelper.info("Current page is " + stackPage.getCurrentUrl());
		}
		
		
		
		
		@Test(groups={"functional"})
		public void shouldNavigateToOperationsinSatackPageFromTopicsCovered() { 
			stackPage.clickOperationsInStackLink();
			assertPageUrlAndHeading(ConfigReader.getOperationsInStackUrl(), PageNames.STACK_OPERATIONS_IN_STACK_PAGE);
		}
		
		
		@Test(groups={"functional"})
		public void shouldNavigateToImplementationPageFromTopicsCovered() { //f
			stackPage.clickImplementationLink();
			assertPageUrlAndHeading(ConfigReader.getImplementationUrl(), PageNames.STACK_IMPLEMENTAION_PAGE);
		}
		

		@Test(groups={"functional"})
		public void shouldNavigateToApplicationPageFromTopicsCovered() { 
			stackPage.clickApplicationsLink();
			assertPageUrlAndHeading(ConfigReader.getApplicationsUrl(), PageNames.STACK_APPLICATION_PAGE);
		}

	
		
		@Test(groups={"functional"})
		public void shouldNavigateToImplementationStackPageFromStackPage() { 
			stackPage.navigateToPage(ConfigReader.getStackUrl());
			stackPage.clickImplementationLink();
			assertPageUrlAndHeading(ConfigReader.getImplementationUrl(), PageNames.STACK_IMPLEMENTAION_PAGE);
		}
		
		
		@Test(groups={"functional"})
		public void shouldNavigateToApplicationsStackPageFromStackPage() { 
			stackPage.navigateToPage(ConfigReader.getStackUrl());
			stackPage.clickApplicationsLink();
			assertPageUrlAndHeading(ConfigReader.getApplicationsUrl(), PageNames.STACK_APPLICATION_PAGE);
		}
		
		

		@Test(groups={"functional"})
		public void shouldNavigateToImplementationPageFromOPerationsInStack() {
			stackPage.navigateToPage(ConfigReader.getOperationsInStackUrl());
			stackPage.clickImplementationLink();
			assertPageUrlAndHeading(ConfigReader.getImplementationUrl(), PageNames.STACK_IMPLEMENTAION_PAGE);
		}

		@Test(groups={"functional"})
		public void shouldNavigateToPracticeQuestionsPageFromOperationsinstackPage() { 
			stackPage.navigateToPage(ConfigReader.getOperationsInStackUrl());
			stackPage.clickPracticeQuesLink();
			assertPageUrlAndHeading(ConfigReader.getStackPracticeUrl(), PageNames.STACK_PRACTICE_QUESTIONS_PAGE);
		}

		@Test(groups={"functional"})
		public void shouldNavigateToTryEditorFromImplementationPage() {
			stackPage.navigateToPage(ConfigReader.getImplementationUrl());
			stackPage.clickTryHereButton();
			Assert.assertEquals(stackPage.getCurrentUrl(), ConfigReader.getTryEditorUrl());
			LogHelper.info("Navigated to Try Editor: " + stackPage.getCurrentUrl());
		}

		@Test(groups={"functional"})
		public void shouldNavigateToTryEditorFromApplicationPage() {
			stackPage.navigateToPage(ConfigReader.getApplicationsUrl());
			stackPage.clickTryHereButton();
			Assert.assertEquals(stackPage.getCurrentUrl(), ConfigReader.getTryEditorUrl());
			LogHelper.info("Navigated to Try Editor: " + stackPage.getCurrentUrl());
		}

		private void assertPageUrlAndHeading(String expectedUrl, String expectedHeading) {
			Assert.assertEquals(stackPage.getCurrentUrl(), expectedUrl);
			Assert.assertEquals(stackPage.getPageHeading(), expectedHeading);
			LogHelper.info("Current page is: " + stackPage.getCurrentUrl());
		}

}

