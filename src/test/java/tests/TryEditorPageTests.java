package tests;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import data.LoginDataProvider;
import data.TryEditorDataProvider;
import pages.HomePage;
import pages.LoginPage;
import pages.TryEditorPage;
import utils.ConfigReader;
import utils.LogHelper;

public class TryEditorPageTests extends BaseTest {

	TryEditorPage tryEditorPage;
	TryEditorDataProvider tryEditorDataProvider;
	
	@BeforeClass
	public void tryEditorSetupBeforeClass() throws IOException {		
		tryEditorDataProvider = new TryEditorDataProvider();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		login();
		tryEditorPage = testContext.getTryEditorPage();
		tryEditorPage.navigateToPage(ConfigReader.getTryEditorUrl());
		LogHelper.info("Navigated to Try Editor page: " + tryEditorPage.getCurrentUrl());
		
	}

	@Test
	public void shouldRunValidPythonCode() throws IOException {
		Map<String, String> validData = tryEditorDataProvider.getValidPythonCode();
		String pythonCode = validData.get("pythonCode");
		String expectedOutput = validData.get("Result");
		tryEditorPage.runPythonCode(pythonCode);
		
		String actualOutput = tryEditorPage.getConsoleOutput();
		LogHelper.info("Actual Output: " + actualOutput);
		LogHelper.info("Comparing the actual output with the expected output: " + expectedOutput);
		Assert.assertEquals(actualOutput, expectedOutput);
	}
	
	@Test
	public void shouldRunInvalidPythonCode() throws IOException {		
		Map<String, String> invalidData = tryEditorDataProvider.getInvalidPythonCode().getFirst();		
		String pythonCode = invalidData.get("pythonCode");
		String expectedOutput = invalidData.get("Result");
		tryEditorPage.runPythonCode(pythonCode);		
		
	    String alertMessage = tryEditorPage.handleAlert();
	    LogHelper.info("Alert message received: " + alertMessage);
	    LogHelper.info("Comparing the alert message with the expected output: " + expectedOutput);
	    Assert.assertEquals(alertMessage, expectedOutput);
	}

}
