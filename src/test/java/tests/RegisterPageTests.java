package tests;

import java.io.IOException;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseTest;
import data.RegisterDataProvider;
import pages.RegisterPage;
import utils.ConfigReader;
import utils.LogHelper;

@Listeners(listeners.TestListener.class)
public class RegisterPageTests extends BaseTest {
	
	RegisterPage registerPage;
	
	@BeforeMethod(groups={"sanity","functional"})
	public void registerSetupBeforeMethod() throws IOException {
		registerPage = new RegisterPage();
		registerPage.navigateToPage(ConfigReader.getRegisterUrl());
		LogHelper.info("Navigated to Register page: " + registerPage.getCurrentUrl());
	}
	
	@Test(dataProvider = "invalidRegistrationDataProvider", dataProviderClass = RegisterDataProvider.class,groups={"functional"})
	public void shouldValidateInvalidRegistrationData(Map<String, String> rowData) throws IOException {	
		String username = rowData.get("username");
		String password = rowData.get("password");
		String confirmPassword = rowData.get("confirmPassword");
		String expectedMessage = rowData.get("expectedMessage");
		String validation = rowData.get("validation");
		
		String actualOutput = registerPage.register(username, password, confirmPassword, validation);
		Assert.assertEquals(actualOutput, expectedMessage);
	}
	
	@Test(groups={"sanity","functional"})
	public void shouldNavigateToLoginPage() {
		registerPage.clickLoginLink();
		Assert.assertEquals(registerPage.getCurrentUrl(), ConfigReader.getLoginUrl());
	}
}