package data;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ArrayQuestionsDataProvider {

	private static final String VALID_PYTHONCODE_RUN_SHEET = "validPythonCode";
	private static final String VALID_PYTHONCODE_SUBMIT_SHEET = "submitPythonCode";
	private static final String INVALID_PYTHONCODE_RUN_SHEET = "invalidPythonCode";

	@DataProvider(name = "validPythonCodeForRunDataProvider")
	public static Object[][] validPythonCodeRunDataProvider() throws IOException {
		return DsAlgoDataProvider.loadDataFromExcelForDataProvider(VALID_PYTHONCODE_RUN_SHEET);

	}

	@DataProvider(name = "validPythonCodeForSubmitDataProvider")
	public static Object[][] validPythonCodeSubmitDataProvider() throws IOException {
		return DsAlgoDataProvider.loadDataFromExcelForDataProvider(VALID_PYTHONCODE_SUBMIT_SHEET);

	}

	@DataProvider(name = "invalidPythonCodeForRunDataProvider")
	public static Object[][] InvalidPythonCodeRunDataProvider() throws IOException {
		return DsAlgoDataProvider.loadDataFromExcelForDataProvider(INVALID_PYTHONCODE_RUN_SHEET);

	}

}
