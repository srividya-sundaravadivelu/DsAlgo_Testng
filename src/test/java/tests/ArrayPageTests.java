package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ArrayPage;
import utils.ConfigReader;
import utils.LogHelper;
import utils.PageNames;

public class ArrayPageTests extends BaseTest {
	ArrayPage arrayPage;
	
	   @BeforeMethod
	    public void arraySetupBeforeMethod() throws IOException{    
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
	        arrayPage.clickArraysInPythonlink();;
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
	        arrayPage.navigateToPage(ConfigReader.getBasicOperationsInListsUrl());
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
	        arrayPage.navigateToPage(ConfigReader.getApplicationsOfArrayUrl());
	        arrayPage.clickApplicationsOfArray();;
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
	        arrayPage.navigateToPage(ConfigReader.getGraphRepresentationsUrl());
	        arrayPage.clickPracticeQuestionslink();
	        assertPageUrlAndHeading(ConfigReader.getArrayPracticeQuestionsUrl(), arrayPage.getArrayPageTitle());
	    }
	    
	    
	    
	   private void assertPageUrlAndHeading(String expectedUrl, String expectedHeading) {
	        Assert.assertEquals(arrayPage.getCurrentUrl(), expectedUrl);
	        Assert.assertEquals(arrayPage.getPageHeading(), expectedHeading);
	        LogHelper.info("Current page is: " + arrayPage.getCurrentUrl());
	    }

}
