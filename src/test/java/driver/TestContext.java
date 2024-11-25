package driver;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.*;
import utils.ConfigReader;
import utils.LogHelper;

public class TestContext {

	WebDriver driver;
	private GraphPage graphPage;
	private ArrayPage arrayPage;
	private DataStructuresIntroductionPage dataStructuresIntroductionPage;
	private HomePage homePage;
	private LinkedListPage linkedListPage;
	private LoginPage loginPage;
	private RegisterPage registerPage;
	private TreePage treePage;
	private TryEditorPage tryEditorPage;
	private StackPage stackPage;
	private QueuePage queuePage;
	private LandingPage landingPage;

	public void setDriver(String browser) {
		LogHelper.info("Browser value inside SetDriver method in TestContext:" + browser);
		long pageLoadTimeout = Long.parseLong(ConfigReader.getPageLoadTimeout());

		switch (browser.toLowerCase()) {
		case "chrome":			
			ChromeOptions chromeOptions = new ChromeOptions();
			if (ConfigReader.isChromeHeadless())
				chromeOptions.addArguments("--headless");
			driver = new ChromeDriver(chromeOptions);
			LogHelper.info("Chrome Driver is created");
			break;
		case "firefox":			
			FirefoxOptions ffOptions = new FirefoxOptions();
			if (ConfigReader.isFireFoxHeadless())
				ffOptions.addArguments("--headless");
			driver = new FirefoxDriver(ffOptions);
			LogHelper.info("Firefox Driver is created");
			break;
		case "edge":			
			EdgeOptions edgeOptions = new EdgeOptions();
			if (ConfigReader.isEdgeHeadless())
				edgeOptions.addArguments("--headless");
			driver = new EdgeDriver(edgeOptions);
			LogHelper.info("Edge Driver is created");
			break;
		default:
			throw new RuntimeException("Browser not supported: " + browser);
		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
		driver.manage().window().maximize();

	}

	public WebDriver getdriver() {
		return driver;
	}

	public void quitDriver() {
	    if (driver != null) {
	        LogHelper.info("Quitting WebDriver instance: " + driver);
	        driver.quit();
	    } else {
	        LogHelper.warn("WebDriver instance is already null or has been quit.");
	    }
	}

	public GraphPage getGraphPage() {
		if (graphPage == null)
			graphPage = new GraphPage(driver);
		return graphPage;
	}

	public HomePage getHomePage() {
		if (homePage == null)
			homePage = new HomePage(driver);
		return homePage;
	}

	public DataStructuresIntroductionPage getDataStructuresIntroductionPage() {
		if (dataStructuresIntroductionPage == null)
			dataStructuresIntroductionPage = new DataStructuresIntroductionPage(driver);
		return dataStructuresIntroductionPage;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null)
			loginPage = new LoginPage(driver);
		return loginPage;
	}

	public TreePage getTreePage() {
		if (treePage == null)
			treePage = new TreePage(driver);
		return treePage;
	}

	public TryEditorPage getTryEditorPage() {
		if (tryEditorPage == null)
			tryEditorPage = new TryEditorPage(driver);
		return tryEditorPage;
	}

	public RegisterPage getRegisterPage() {
		if (registerPage == null)
			registerPage = new RegisterPage(driver);
		return registerPage;
	}

	public ArrayPage getArrayPage() {
		if (arrayPage == null)
			arrayPage = new ArrayPage(driver);
		return arrayPage;
	}

	public LinkedListPage getLinkedListPage() {
		if (linkedListPage == null)
			linkedListPage = new LinkedListPage(driver);
		return linkedListPage;
	}
	
	public StackPage getStackPage() {
		if (stackPage == null)
			stackPage = new StackPage(driver);
		return stackPage;
	}
	
	public QueuePage getQueuePage() {
		if (queuePage == null)
			queuePage = new QueuePage(driver);
		return queuePage;
	}
	
	public LandingPage getLandingPage() {
		if (landingPage == null)
			landingPage = new LandingPage(driver);
		return landingPage;
	}

}
