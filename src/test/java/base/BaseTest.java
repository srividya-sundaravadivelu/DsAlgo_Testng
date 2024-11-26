package base;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.LoginDataProvider;
import driver.TestContext;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.LogHelper;
import utils.WebDriverWaitUtility;

public class BaseTest {
	protected TestContext testContext;
	protected LoginPage loginPage;
	protected HomePage homePage;

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
//	 @BeforeClass Runs Before All @Test methods, Frequency: Runs once per class 	
	public void setupTest(@Optional String browser) throws IOException {
		LogHelper.info("Browser value from Testng Xml file:" + browser);

		if (browser != null) {
			ConfigReader.setBrowser(browser);
			LogHelper.info("Config Reader browser value: " + ConfigReader.getBrowser());
		}

		testContext = new TestContext();
		testContext.setDriver(ConfigReader.getBrowser());
		WebDriver driver = testContext.getdriver();
		WebDriverWaitUtility.initializeWait(driver, ConfigReader.getWebDriverWaitTimeout());
	}

	protected void login() throws IOException {

		// Retrieve valid login credentials
		Object[][] validCredentialsArray = LoginDataProvider.validLoginDataProvider();
		
		@SuppressWarnings("unchecked")
		Map<String, String> validCredentials = (Map<String, String>) validCredentialsArray[0][0];

		String username = validCredentials.get("username");
		String password = validCredentials.get("password");

		LoginPage loginPage = testContext.getLoginPage();
		loginPage.navigateToPage(ConfigReader.getLoginUrl());
		HomePage homePage = loginPage.login(username, password);

		Assert.assertTrue(homePage.isSignOutLinkVisible(), "Login failed!");
	}

//	 @AfterClass Runs After All @Test methods, Frequency: Runs once per class 
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		if (testContext != null) {
			testContext.quitDriver(); // Quit WebDriver using TestContext
		}
	}

}

