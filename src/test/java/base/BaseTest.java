package base;

import driver.DriverManager;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.LoginDataProvider;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import utils.ConfigReader;
import utils.LogHelper;
import utils.WebDriverWaitUtility;

public class BaseTest {

	@BeforeMethod
	@Parameters("browser")
	public void setupTest(@Optional String browser) {

		LogHelper.info("Browser value from Testng Xml file:" + browser);

		if (browser != null) {
			ConfigReader.setBrowser(browser);
			LogHelper.info("Config Reader browser value: " + ConfigReader.getBrowser());
		}

		DriverManager.setDriver(browser);
		LogHelper.info("WebDriver initialized successfully.");

		WebDriverWaitUtility.initializeWait(DriverManager.getDriver(),ConfigReader.getWebDriverWaitTimeout());
		
		LogHelper.info("Thread ID: "+ Thread.currentThread().getId());
	}

	protected void login() throws IOException {

		// Retrieve valid login credentials
		Object[][] validCredentialsArray = LoginDataProvider.validLoginDataProvider();

		@SuppressWarnings("unchecked")
		Map<String, String> validCredentials = (Map<String, String>) validCredentialsArray[0][0];

		String username = validCredentials.get("username");
		String password = validCredentials.get("password");

		LoginPage loginPage = new LoginPage();
		loginPage.navigateToPage(ConfigReader.getLoginUrl());
		HomePage homePage = loginPage.login(username, password);

		Assert.assertTrue(homePage.isSignOutLinkVisible(), "Login failed!");
	}

	@AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        LogHelper.info("Tearing down WebDriver for thread: " + Thread.currentThread().getId());
        DriverManager.tearDown(); // Use tearDown to quit and clean up the driver
    }
}
