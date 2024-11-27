package pages;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.LogHelper;
import utils.WebDriverWaitUtility;

public class TryEditorPage extends BasePage {

	@FindBy(xpath = "//button[text()='Run']")
	private WebElement runButton;

	@FindBy(id = "output")
	private WebElement outputField;

	@FindBy(xpath = "//textarea/ancestor::div[contains(@class,'CodeMirror')]")
	private WebElement codeMirrorDiv;

	public void runPythonCode(String pythonCode) {
		codeMirrorDiv.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);", pythonCode);
		WebDriverWaitUtility.waitForElementToBeClickable(runButton);
		runButton.click();
	}

	public String getConsoleOutput() {
		WebDriverWaitUtility.waitForElementToBeVisible(outputField);
		return outputField.getText();
	}

	public String handleAlert() {
		String alertMessage = "";
		if (isAlertPresent()) {
			Alert alert = driver.switchTo().alert();
			alertMessage = alert.getText();
			alert.accept();
		} else {
			LogHelper.info("No alert present");
		}
		return alertMessage;
	}

	private boolean isAlertPresent() {
		try {
			LogHelper.info("Checking for alert. WebDriver instance: " + driver + ", Thread ID: "
					+ Thread.currentThread().getId());

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());			
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
