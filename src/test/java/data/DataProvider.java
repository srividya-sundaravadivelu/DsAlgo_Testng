package data;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.ConfigReader;
import utils.ExcelReader;
import utils.LogHelper;

public class DataProvider {
	
	protected void loadDataFromExcel(String sheetName, List<Map<String, String>> dataList) {
		try {
			ExcelReader excelReader = new ExcelReader(ConfigReader.getExcelFilePath());
			int rowCount = excelReader.getRowCount(sheetName);
			int colCount = excelReader.getColumnCount(sheetName);

			for (int i = 1; i <= rowCount; i++) { // Assuming row 0 is the header
				Map<String, String> rowData = new HashMap<>();
				for (int j = 0; j < colCount; j++) {
					String columnName = excelReader.getCellData(sheetName, 0, j); // Column header
					String cellValue = excelReader.getCellData(sheetName, i, j); // Cell value
					rowData.put(columnName, cellValue);
				}
				dataList.add(rowData);
			}
			excelReader.close();
		} catch (IOException e) {
			LogHelper.error("Failed to read data from Excel");
			throw new RuntimeException("Failed due to IO error", e);
		}
	}

}
