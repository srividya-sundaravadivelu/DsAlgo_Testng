package tests;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.TreePage;
import utils.ConfigReader;
import utils.LogHelper;
import utils.PageNames;

public class TreePageTests extends BaseTest {

	TreePage treePage;

	@BeforeMethod
	public void treeSetupBeforeMethod() throws IOException {		
		login();
		treePage = testContext.getTreePage();
		treePage.navigateToPage(ConfigReader.getTreeUrl());
		LogHelper.info("Navigated to Tree page: " + treePage.getCurrentUrl());
	}

	@Test(priority = 1)
	public void shouldLoadTreePageSuccessfully() {
		Assert.assertEquals(treePage.getCurrentUrl(), ConfigReader.getTreeUrl());
		LogHelper.info("Current page is " + treePage.getCurrentUrl());
	}

	@Test
	public void shouldNavigateToOverviewOfTreesFromTopicsCovered() {
		treePage.clickItemUnderTopicsCovered(PageNames.OVERVIEW_OF_TREES_PAGE);
		assertPageUrlAndHeading(ConfigReader.getOverviewOfTreesUrl(), PageNames.OVERVIEW_OF_TREES_PAGE);
	}

	@Test
	public void shouldNavigateToTerminologiesFromTopicsCovered() {
		treePage.clickItemUnderTopicsCovered(PageNames.TREE_TERMINOLOGIES_PAGE);
		assertPageUrlAndHeading(ConfigReader.getTreeTerminologiesUrl(), PageNames.TREE_TERMINOLOGIES_PAGE);
	}

	@Test
	public void shouldNavigateToTypesOfTreesFromTopicsCovered() {
		treePage.clickItemUnderTopicsCovered(PageNames.TYPES_OF_TREES_PAGE);
		assertPageUrlAndHeading(ConfigReader.getTypesOfTreesUrl(), PageNames.TYPES_OF_TREES_PAGE);
	}

	@Test
	public void shouldNavigateToTreeTraversalsFromTopicsCovered() {
		treePage.clickItemUnderTopicsCovered(PageNames.TREE_TRAVERSALS_PAGE);
		assertPageUrlAndHeading(ConfigReader.getTreeTraversalsUrl(), PageNames.TREE_TRAVERSALS_PAGE);
	}

	@Test
	public void shouldNavigateToTraversalsIllustrationsFromTopicsCovered() {
		treePage.clickItemUnderTopicsCovered(PageNames.TRAVERSALS_ILLUSTRATIONS_PAGE);
		assertPageUrlAndHeading(ConfigReader.getTreeTraversalsIllustrationsUrl(),
				PageNames.TRAVERSALS_ILLUSTRATIONS_PAGE);
	}

	@Test
	public void shouldNavigateToBinaryTreesFromTopicsCovered() {
		treePage.clickItemUnderTopicsCovered(PageNames.BINARY_TREES_PAGE);
		assertPageUrlAndHeading(ConfigReader.getBinaryTreesUrl(), PageNames.BINARY_TREES_PAGE);
	}

	@Test
	public void shouldNavigateToTypesOfBinaryTreesFromTopicsCovered() {
		treePage.clickItemUnderTopicsCovered(PageNames.TYPES_OF_BINARY_TREES_PAGE);
		assertPageUrlAndHeading(ConfigReader.getTypesOfBinaryTreesUrl(), PageNames.TYPES_OF_BINARY_TREES_PAGE);
	}

	@Test
	public void shouldNavigateToImplementationInPythonFromTopicsCovered() {
		treePage.clickItemUnderTopicsCovered(PageNames.TREE_IMPLEMENTATION_IN_PYTHON_PAGE);
		assertPageUrlAndHeading(ConfigReader.getTreeImplementationInPythonUrl(),
				PageNames.TREE_IMPLEMENTATION_IN_PYTHON_PAGE);
	}

	@Test
	public void shouldNavigateToBinaryTreeTraversalsFromTopicsCovered() {
		treePage.clickItemUnderTopicsCovered(PageNames.BINARY_TREE_TRAVERSALS_PAGE);
		assertPageUrlAndHeading(ConfigReader.getBinaryTreeTraversalsUrl(), PageNames.BINARY_TREE_TRAVERSALS_PAGE);
	}

	@Test
	public void shouldNavigateToImplementationOfBinaryTreesFromTopicsCovered() {
		treePage.clickItemUnderTopicsCovered(PageNames.IMPLEMENTATION_OF_BINARY_TREES_PAGE);
		assertPageUrlAndHeading(ConfigReader.getImplementationOfBinaryTreesUrl(),
				PageNames.IMPLEMENTATION_OF_BINARY_TREES_PAGE);
	}

	@Test
	public void shouldNavigateToApplicationsOfBinaryTreesFromTopicsCovered() {
		treePage.clickItemUnderTopicsCovered(PageNames.APPLICATION_OF_BINARY_TREES_PAGE);
		assertPageUrlAndHeading(ConfigReader.getApplicationsOfBinaryTreesUrl(),
				PageNames.APPLICATION_OF_BINARY_TREES_PAGE);
	}

	@Test
	public void shouldNavigateToBinarySearchTreesFromTopicsCovered() {
		treePage.clickItemUnderTopicsCovered(PageNames.BINARY_SEARCH_TREES_PAGE);
		assertPageUrlAndHeading(ConfigReader.getBinarySearchTreesUrl(), PageNames.BINARY_SEARCH_TREES_PAGE);
	}

	@Test
	public void shouldNavigateToImplementationOfBSTFromTopicsCovered() {
		treePage.clickItemUnderTopicsCovered(PageNames.IMPLEMENTATION_OF_BST_PAGE);
		assertPageUrlAndHeading(ConfigReader.getImplementationOfBstUrl(), PageNames.IMPLEMENTATION_OF_BST_PAGE);
	}

	@Test
	public void shouldNavigateToTerminologiesFromOverviewOfTrees() {
		treePage.navigateToPage(ConfigReader.getOverviewOfTreesUrl());
		treePage.clickTerminologiesLink();
		assertPageUrlAndHeading(ConfigReader.getTreeTerminologiesUrl(), PageNames.TREE_TERMINOLOGIES_PAGE);
	}

	@Test
	public void shouldNavigateToTypesOfTreesFromTerminologies() {
		treePage.navigateToPage(ConfigReader.getTreeTerminologiesUrl());
		treePage.clickTypesOfTreesLink();
		assertPageUrlAndHeading(ConfigReader.getTypesOfTreesUrl(), PageNames.TYPES_OF_TREES_PAGE);
	}

	@Test
	public void shouldNavigateToTreeTraversalsFromTypesOfTrees() {
		treePage.navigateToPage(ConfigReader.getTypesOfTreesUrl());
		treePage.clickTreeTraversalsLink();
		assertPageUrlAndHeading(ConfigReader.getTreeTraversalsUrl(), PageNames.TREE_TRAVERSALS_PAGE);
	}

	@Test
	public void shouldNavigateToTraversalsIllustrationsFromTreeTraversals() {
		treePage.navigateToPage(ConfigReader.getTreeTraversalsUrl());
		treePage.clickTraversalsIllustrationLink();
		assertPageUrlAndHeading(ConfigReader.getTreeTraversalsIllustrationsUrl(), PageNames.TRAVERSALS_ILLUSTRATIONS_PAGE);
	}

	@Test
	public void shouldNavigateToBinaryTreesFromTraversalsIllustrations() {
		treePage.navigateToPage(ConfigReader.getTreeTraversalsIllustrationsUrl());
		treePage.clickBinaryTreesLink();
		assertPageUrlAndHeading(ConfigReader.getBinaryTreesUrl(), PageNames.BINARY_TREES_PAGE);
	}

	@Test
	public void shouldNavigateToTypesOfBinaryTreesFromBinaryTrees() {
		treePage.navigateToPage(ConfigReader.getBinaryTreesUrl());
		treePage.clickTypesOfBinaryTreesLink();
		assertPageUrlAndHeading(ConfigReader.getTypesOfBinaryTreesUrl(), PageNames.TYPES_OF_BINARY_TREES_PAGE);
	}

	@Test
	public void shouldNavigateToImplementationInPythonFromTypesOfBinaryTrees() {
		treePage.navigateToPage(ConfigReader.getTypesOfBinaryTreesUrl());
		treePage.clickImplementationInPythonLink();
		assertPageUrlAndHeading(ConfigReader.getTreeImplementationInPythonUrl(), PageNames.TREE_IMPLEMENTATION_IN_PYTHON_PAGE);
	}

	@Test
	public void shouldNavigateToBinaryTreeTraversalsFromImplementationInPython() {
		treePage.navigateToPage(ConfigReader.getTreeImplementationInPythonUrl());
		treePage.clickBinaryTreeTraversalsLink();
		assertPageUrlAndHeading(ConfigReader.getBinaryTreeTraversalsUrl(), PageNames.BINARY_TREE_TRAVERSALS_PAGE);
	}

	@Test
	public void shouldNavigateToImplementationOfBinaryTreesFromBinaryTreeTraversals() {
		treePage.navigateToPage(ConfigReader.getBinaryTreeTraversalsUrl());
		treePage.clickImplementationOfBinaryTreesLink();
		assertPageUrlAndHeading(ConfigReader.getImplementationOfBinaryTreesUrl(), PageNames.IMPLEMENTATION_OF_BINARY_TREES_PAGE);
	}

	@Test
	public void shouldNavigateToApplicationsOfBinaryTreesFromImplementationOfBinaryTrees() {
		treePage.navigateToPage(ConfigReader.getImplementationOfBinaryTreesUrl());
		treePage.clickApplicationsOfBinaryTreesLink();
		assertPageUrlAndHeading(ConfigReader.getApplicationsOfBinaryTreesUrl(), PageNames.APPLICATION_OF_BINARY_TREES_PAGE);
	}

	@Test
	public void shouldNavigateToBinarySearchTreesFromApplicationsOfBinaryTrees() {
		treePage.navigateToPage(ConfigReader.getApplicationsOfBinaryTreesUrl());
		treePage.clickBinarySearchTreesLink();
		assertPageUrlAndHeading(ConfigReader.getBinarySearchTreesUrl(), PageNames.BINARY_SEARCH_TREES_PAGE);
	}

	@Test
	public void shouldNavigateToImplementationOfBSTFromBinarySearchTrees() {
		treePage.navigateToPage(ConfigReader.getBinarySearchTreesUrl());
		treePage.clickImplementationOfBSTLink();
		assertPageUrlAndHeading(ConfigReader.getImplementationOfBstUrl(), PageNames.IMPLEMENTATION_OF_BST_PAGE);
	}

	@Test
	public void shouldNavigateToPracticeQuestionsFromImplementationOfBST() {
		treePage.navigateToPage(ConfigReader.getImplementationOfBstUrl());
		treePage.clickPracticeQuestionsLink();
		assertPageUrlAndHeading(ConfigReader.getTreePracticeUrl(), PageNames.TREE_PRACTICE_QUESTIONS_PAGE);
	}
	
	@Test
	public void shouldNavigateToTryEditorFromImplementationOfBST() {
		treePage.navigateToPage(ConfigReader.getImplementationOfBstUrl());
		treePage.clickTryHereButton();
        Assert.assertEquals(treePage.getCurrentUrl(), ConfigReader.getTryEditorUrl());
        LogHelper.info("Navigated to Try Editor: " + treePage.getCurrentUrl());
    }

	private void assertPageUrlAndHeading(String expectedUrl, String expectedHeading) {
		Assert.assertEquals(treePage.getCurrentUrl(), expectedUrl);
		Assert.assertEquals(treePage.getPageHeading(), expectedHeading);
		LogHelper.info("Current page is: " + treePage.getCurrentUrl());
	}

}