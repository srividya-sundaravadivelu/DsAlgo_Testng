package tests;

	import java.io.IOException;
    import org.testng.Assert;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import base.BaseTest;
    import pages.HomePage;
    import utils.ConfigReader;
	import utils.LogHelper;
    import utils.PageNames;

	public class HomePageTest  extends BaseTest{
		HomePage homePage;
		
		@BeforeMethod()
		public void homePageSetupBeforeMethod() throws IOException {
			login();
			homePage = new HomePage();
			homePage.navigateToPage(ConfigReader.getHomeUrl());
			LogHelper.info("Navigated to Home page: " + homePage.getCurrentUrl());
		}
		@Test(priority = 1)
		public void shouldLoadHomePageSuccessfully() {
			Assert.assertEquals(homePage.getCurrentUrl(), ConfigReader.getHomeUrl());
			LogHelper.info("Current page is " + homePage.getCurrentUrl());
		}


		@Test
		public void shouldnavigatetoDatastructureintroductionpage() {
			homePage.clickGetStarted("data-structures-introduction");
		    Assert.assertEquals(homePage.getCurrentUrl(), ConfigReader.getDataStructuresIntroductionUrl());
		}

		@Test
		public void shouldnavigatetoArrayPage() {
			homePage.clickGetStarted(PageNames.ARRAY_PAGE);
		    Assert.assertEquals(homePage.getCurrentUrl(), ConfigReader.getArrayUrl());
		    assertPageUrlAndHeading(ConfigReader.getArrayUrl(), PageNames.ARRAY_PAGE);
		}
		
		@Test
		public void shouldnavigatetoStackPage() {
			homePage.clickGetStarted(PageNames.STACK_PAGE);
		    Assert.assertEquals(homePage.getCurrentUrl(), ConfigReader.getStackUrl());
		   assertPageUrlAndHeading(ConfigReader.getStackUrl(), PageNames.STACK_PAGE);
		}
		
		@Test
		public void shouldnavigatetoQueuePage() {
			homePage.clickGetStarted(PageNames.QUEE_PAGE);
		    Assert.assertEquals(homePage.getCurrentUrl(), ConfigReader.getQueueUrl());
		    assertPageUrlAndHeading(ConfigReader.getQueueUrl(), PageNames.QUEE_PAGE);
		}
		
		
		@Test
		public void shouldnavigatetoTreePage() {
			homePage.clickGetStarted(PageNames.TREE_PAGE);
		    Assert.assertEquals(homePage.getCurrentUrl(), ConfigReader.getTreeUrl());
		   assertPageUrlAndHeading(ConfigReader.getTreeUrl(), PageNames.TREE_PAGE);
		}
		
		@Test
		public void shouldnavigatetoGraphPage() {
			homePage.clickGetStarted(PageNames.GRAPH_PAGE);
		    Assert.assertEquals(homePage.getCurrentUrl(), ConfigReader.getGraphHomeUrl());
		   assertPageUrlAndHeading(ConfigReader.getGraphHomeUrl(), PageNames.GRAPH_PAGE);
		}
		
		@Test
		public void shouldnavigatetoLinkedListPage() {
			homePage.clickGetStarted(PageNames.LINKED_LIST_LINK);
		    Assert.assertEquals(homePage.getCurrentUrl(), ConfigReader.getLinkedListUrl());
		assertPageUrlAndHeading(ConfigReader.getLinkedListUrl(), PageNames.LINKED_LIST_PAGE);
		}
		
		
		@Test
		public void shouldnavigatetoArraysPagefromDropdownlist() {
			homePage.clickDropDownItem("Arrays");
		    Assert.assertEquals(homePage.getCurrentUrl(), ConfigReader.getArrayUrl());
		   assertPageUrlAndHeading(ConfigReader.getArrayUrl(), PageNames.ARRAY_PAGE);
		}
		
		
		@Test
		public void shouldnavigatetoLinkedListPagefromDropdownlist() {
			homePage.clickDropDownItem(PageNames.LINKED_LIST_PAGE);
		    Assert.assertEquals(homePage.getCurrentUrl(), ConfigReader.getLinkedListUrl());
		   assertPageUrlAndHeading(ConfigReader.getLinkedListUrl(), PageNames.LINKED_LIST_PAGE);
		}
		
		
		@Test
		public void shouldnavigatetoStackfromDropdownlist() {
			homePage.clickDropDownItem(PageNames.STACK_PAGE);
		    Assert.assertEquals(homePage.getCurrentUrl(), ConfigReader.getStackUrl());
		   assertPageUrlAndHeading(ConfigReader.getStackUrl(), PageNames.STACK_PAGE);
		}
		
		@Test
		public void shouldnavigatetoQueuePagefromDropdownlist() {
			homePage.clickDropDownItem(PageNames.QUEE_PAGE);
		    Assert.assertEquals(homePage.getCurrentUrl(), ConfigReader.getQueueUrl());
		   assertPageUrlAndHeading(ConfigReader.getQueueUrl(), PageNames.QUEE_PAGE);
		}
		
		@Test
		public void shouldnavigatetoTreePagefromDropdownlist() {
			homePage.clickDropDownItem(PageNames.TREE_PAGE);
		    Assert.assertEquals(homePage.getCurrentUrl(), ConfigReader.getTreeUrl());
		   assertPageUrlAndHeading(ConfigReader.getTreeUrl(), PageNames.TREE_PAGE);
		}
		
		@Test
		public void shouldnavigatetoGraphPagefromDropdownlist() {
			homePage.clickDropDownItem(PageNames.GRAPH_PAGE);
		    Assert.assertEquals(homePage.getCurrentUrl(), ConfigReader.getGraphHomeUrl());
		    assertPageUrlAndHeading(ConfigReader.getGraphHomeUrl(), PageNames.GRAPH_PAGE);
		}
		
		
		private void assertPageUrlAndHeading(String expectedUrl, String expectedHeading) {
			Assert.assertEquals(homePage.getCurrentUrl(), expectedUrl);
			Assert.assertEquals(homePage.getPageTitle(), expectedHeading);
			LogHelper.info("Current page is: " + homePage.getCurrentUrl());
		}
}

