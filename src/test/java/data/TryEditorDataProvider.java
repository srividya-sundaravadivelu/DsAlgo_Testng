package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TryEditorDataProvider extends DataProvider{
	
	private List<Map<String, String>> tryEditorData;
	private static String TRY_EDITOR_SHEET = "pythonCode";

	public TryEditorDataProvider() throws IOException {
		this.tryEditorData = new ArrayList<>();

		// Load login data
		loadDataFromExcel(TRY_EDITOR_SHEET, tryEditorData);
	}	

	public Map<String, String> getValidPythonCode() {
		return tryEditorData.getFirst(); // first row has valid data
	}

	public List<Map<String, String>> getInvalidPythonCode() {
		return tryEditorData.subList(1, tryEditorData.size());// get from second row onwards for invalid data
	}

}
