package tests;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import data.TryEditorDataProvider;
import pages.TryEditorPage;
import utils.ConfigReader;
import utils.LogHelper;

public class TryEditorPageTests extends BaseTest {

	TryEditorPage tryEditorPage;
	
	@BeforeMethod	
	public void setup() throws IOException {		
		login();
		tryEditorPage = new TryEditorPage();
		tryEditorPage.navigateToPage(ConfigReader.getTryEditorUrl());
		LogHelper.info("Navigated to Try Editor page: " + tryEditorPage.getCurrentUrl());		
	}

	@Test(dataProvider = "validTryEditorDataProvider", dataProviderClass = TryEditorDataProvider.class)
	public void shouldRunValidPythonCode(Map<String, String> rowData) throws IOException {
		String pythonCode = rowData.get("pythonCode");
		String expectedOutput = rowData.get("Result");
		tryEditorPage.runPythonCode(pythonCode);
		
		String actualOutput = tryEditorPage.getConsoleOutput();
		LogHelper.info("Actual Output: " + actualOutput);
		LogHelper.info("Comparing the actual output with the expected output: " + expectedOutput);
		Assert.assertEquals(actualOutput, expectedOutput);
	}
	
	@Test(dataProvider = "invalidTryEditorDataProvider", dataProviderClass = TryEditorDataProvider.class)
	public void shouldRunInvalidPythonCode(Map<String, String> rowData) throws IOException {	
		String pythonCode = rowData.get("pythonCode");
		String expectedOutput = rowData.get("Result");
		tryEditorPage.runPythonCode(pythonCode);		
		
	    String alertMessage = tryEditorPage.handleAlert();
	    LogHelper.info("Alert message received: " + alertMessage);
	    LogHelper.info("Comparing the alert message with the expected output: " + expectedOutput);
	    Assert.assertEquals(alertMessage, expectedOutput);
	}
}
