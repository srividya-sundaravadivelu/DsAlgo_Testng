package data;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import utils.ConfigReader;
import utils.ExcelReader;
import utils.LogHelper;

public class DsAlgoDataProvider {
	
	
	public static Object[][] loadDataFromExcelForDataProvider(String sheetName) {
	    try {
	        ExcelReader excelReader = new ExcelReader(ConfigReader.getExcelFilePath());
	        int rowCount = excelReader.getRowCount(sheetName);
	        int colCount = excelReader.getColumnCount(sheetName);

	        Object[][] data = new Object[rowCount][1]; // Each row is a Map

	        for (int i = 1; i <= rowCount; i++) { // Assuming row 0 is the header
	            Map<String, String> rowData = new HashMap<>();
	            for (int j = 0; j < colCount; j++) {
	                String columnName = excelReader.getCellData(sheetName, 0, j); // Column header
	                String cellValue = excelReader.getCellData(sheetName, i, j); // Cell value
	                rowData.put(columnName, cellValue);
	            }
	            data[i - 1][0] = rowData; // Each row in the Object[][] array contains a Map
	        }
	        excelReader.close();
	        return data;
	    } catch (IOException e) {
	        LogHelper.error("Failed to read data from Excel");
	        throw new RuntimeException("Failed due to IO error", e);
	    }
	}

}
