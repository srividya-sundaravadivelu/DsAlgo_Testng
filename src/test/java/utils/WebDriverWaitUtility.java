package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitUtility {

	private static WebDriverWait wait;

	public static void initializeWait(WebDriver driver, long timeoutInSeconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	}

	public static WebElement waitForElementToBeVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static boolean waitForPageLoad(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return wait.until(
				(ExpectedCondition<Boolean>) wd -> js.executeScript("return document.readyState").equals("complete"));
	}

	public static boolean waitForAlert() {
		return wait.until(ExpectedConditions.alertIsPresent()) != null;
	}

}
