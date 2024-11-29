package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WebDriverWaitUtility;

public class LoginPage extends BasePage {

	@FindBy(id = "id_username")
	private WebElement usernameField;

	@FindBy(id = "id_password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@type='submit' and @value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class='alert alert-primary']")
	private WebElement alert;

	@FindBy(xpath = "//a[@href=\"/register\"]")
	private WebElement register;

	public HomePage login(String username, String password) {
		WebDriverWaitUtility.waitForElementToBeVisible(usernameField);
		usernameField.clear();
		usernameField.sendKeys(username);

		WebDriverWaitUtility.waitForElementToBeVisible(passwordField);
		passwordField.clear();
		passwordField.sendKeys(password);

		WebDriverWaitUtility.waitForElementToBeClickable(loginButton);
		loginButton.click();
		return new HomePage();
	}

	public void clickRegisterlink() {
		WebDriverWaitUtility.waitForElementToBeClickable(register);
		register.click();
	}

	public void clickLogin() {
		loginButton.click();
	}

	public String getValidationMessage() {
		String msg = alert.getText().trim();
		return msg;
	}

	private String errormsgEmptyUser() {
		return usernameField.getAttribute("validationMessage");
	}

	private String errormsgEmptyPassword() {
		return passwordField.getAttribute("validationMessage");
	}

	public String verifyLogin(String username, String password, String expMsg, String validation) {

		String actualOutput = "";
		enterUsername(username);
		enterPassword(password);
		clickLogin();

		switch (validation.toLowerCase()) {
		case "username_empty":
			actualOutput = errormsgEmptyUser();
			break;
		case "password_empty":
			actualOutput = errormsgEmptyPassword();
			break;

		case "username_invalid":
		case "password_invalid":
		case "invalid_data":
			actualOutput = getValidationMessage();
			break;
		}
		return actualOutput;
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
}