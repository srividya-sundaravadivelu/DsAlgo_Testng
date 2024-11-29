package tests;

import java.io.IOException;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseTest;
import data.LoginDataProvider;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.LogHelper;

@Listeners(listeners.TestListener.class)
public class LoginPageTests extends BaseTest {
	LoginPage loginPage;
	
	@BeforeMethod()
	public void registerSetupBeforeMethod() throws IOException {
		loginPage = new LoginPage();
		loginPage.navigateToPage(ConfigReader.getLoginUrl());
		LogHelper.info("Navigated to Register page: " + loginPage.getCurrentUrl());
	}

	@Test(dataProvider = "validLoginDataProvider", dataProviderClass = LoginDataProvider.class)
	public void shouldValidateValidLoginData(Map<String, String> rowData) throws IOException {		
		LogHelper.info("Starting shouldValidateValidLoginData Test Iteration");
		String username = rowData.get("username");
		String password = rowData.get("password");
		String expectedMessage = rowData.get("expectedmessage");
		HomePage homePage = loginPage.login(username, password);
		String actualMessage = homePage.alert();
		LogHelper.info("Expected Message: " + expectedMessage);
		LogHelper.info("Actual Message: " + actualMessage);
		Assert.assertEquals(actualMessage, expectedMessage);
		LogHelper.info("Test Iteration Completed");
	}

	@Test(dataProvider = "invalidLoginDataProvider", dataProviderClass = LoginDataProvider.class)
	public void shouldValidateInvalidLoginData(Map<String, String> rowData) throws IOException {			
		LogHelper.info("Starting shouldValidateInvalidLoginData Test Iteration");		
		String username = rowData.get("username");
		String password = rowData.get("password");
		String expectedMessage = rowData.get("expectedmessage");
		String validationMessage = rowData.get("validation");

		String actMsg = loginPage.verifyLogin(username, password, expectedMessage, validationMessage);
		LogHelper.info("Expected Message: " + expectedMessage);
		LogHelper.info("Actual Message: " + validationMessage);
		Assert.assertEquals(actMsg, expectedMessage);
		LogHelper.info("Test Iteration Completed");
	}

	@Test
	public void shouldValidateRegisterBtn() {
		loginPage.navigateToPage(ConfigReader.getLoginUrl());
		loginPage.clickRegisterlink();
		LogHelper.info("Navigated to Register page: " + loginPage.getCurrentUrl());
		Assert.assertEquals(loginPage.getCurrentUrl(), ConfigReader.getRegisterUrl());
	}

}
