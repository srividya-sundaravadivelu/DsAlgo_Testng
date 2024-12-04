package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.ConfigReader;
import utils.LogHelper;

public class DriverManager {

	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	public static void setDriver(String browser) {
		WebDriver driver;
		LogHelper.info("Browser value inside SetDriver method in DriverManager:" + browser);
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

		threadLocalDriver.set(driver);
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().window().maximize();		
	}

	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}

	public static void tearDown() {
	    if (getDriver() != null) {
	        getDriver().quit(); // Terminates the WebDriver session
	        threadLocalDriver.remove(); // Cleans up the ThreadLocal instance
	    }
	}

}