package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LogHelper;
import utils.WebDriverWaitUtility;

public class RegisterPage extends BasePage {

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	private WebElement loginLink;

	@FindBy(xpath = "//*[@id='id_username']")
	private WebElement usernameField;

	@FindBy(xpath = "//*[@id='id_password1']")
	private WebElement passwordField;

	@FindBy(xpath = "//*[@id='id_password2']")
	private WebElement confirmPasswordField;

	@FindBy(xpath = "//form/input[@type='submit']")
	private WebElement registerButton;

	@FindBy(xpath = "//div[@class='alert alert-primary']")
	private WebElement errorMessage;

	public void clickRegisterButton() {
		WebDriverWaitUtility.waitForElementToBeClickable(registerButton);
		registerButton.click();
	}

	public void clickLoginLink() {
		WebDriverWaitUtility.waitForElementToBeClickable(loginLink);
		loginLink.click();
	}

	private String errormsgEmptyUser() {
		return usernameField.getAttribute("validationMessage");
	}

	private String errormsgEmptyPassword() {
		return passwordField.getAttribute("validationMessage");
	}

	private String errormsgEmptyConfirmPassword() {
		return confirmPasswordField.getAttribute("validationMessage");
	}

	private void enterUsername(String username) {
		WebDriverWaitUtility.waitForElementToBeVisible(usernameField);
		usernameField.clear();
		usernameField.sendKeys(username);
	}

	private void enterPassword(String password) {
		WebDriverWaitUtility.waitForElementToBeVisible(passwordField);
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	private void enterConfirmPassword(String cpassword) {
		WebDriverWaitUtility.waitForElementToBeVisible(confirmPasswordField);
		confirmPasswordField.clear();
		confirmPasswordField.sendKeys(cpassword);
	}

	public String getErrormsg() {
		String msg = null;
		try {
			WebDriverWaitUtility.waitForElementToBeVisible(errorMessage);
			msg = errorMessage.getText();

		} catch (NoSuchElementException e) {
			LogHelper.error(e.getMessage());
		}
		return msg;
	}

	public String register(String username, String password, String confirmPassword, String validation) {

		String actualOutput = "";
		enterUsername(username);
		enterPassword(password);
		enterConfirmPassword(confirmPassword);
		clickRegisterButton();

		switch (validation.toLowerCase()) {
		case "username_empty":
			actualOutput = errormsgEmptyUser();
			break;
		case "password_empty":
			actualOutput = errormsgEmptyPassword();
			break;
		case "confirmpassword_empty":
			actualOutput = errormsgEmptyConfirmPassword();
			break;
		case "username_invalid":
		case "password_invalid":
			actualOutput = getErrormsg();
			break;
		}

		return actualOutput;
	}

}
