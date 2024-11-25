package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.ConfigReader;
import utils.ExcelReader;
import utils.LogHelper;

public class LoginDataProvider extends DataProvider {

	private List<Map<String, String>> loginData;
	private static String LOGIN_SHEET = "loginSheet";

	public LoginDataProvider() throws IOException {
		this.loginData = new ArrayList<>();

		// Load login data
		loadDataFromExcel(LOGIN_SHEET, loginData);
	}	

	public Map<String, String> getValidLoginData() {
		return loginData.getFirst(); // first row has valid login
	}

	public List<Map<String, String>> getInvalidLoginData() {
		return loginData.subList(1, loginData.size());// get from second row onwards for invalid login data
	}

}
