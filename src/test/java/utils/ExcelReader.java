package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private Workbook workbook;

	public ExcelReader(String filePath) throws IOException {
		FileInputStream fis = new FileInputStream(Paths.get(filePath).toFile());
		workbook = new XSSFWorkbook(fis);
	}

	public String getCellData(String sheetName, int rowNumber, int cellNumber) {
		Sheet sheet = workbook.getSheet(sheetName);

		if (sheet == null) {
			throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in the Excel file.");
		}

		Row row = sheet.getRow(rowNumber);
		if (row == null) {
			throw new IllegalArgumentException("Row " + rowNumber + " does not exist in the sheet.");
		}

		Cell cell = row.getCell(cellNumber);
		if (cell == null) {
			throw new IllegalArgumentException(
					"Cell at row " + rowNumber + ", column " + cellNumber + " does not exist.");
		}

		return cell.getStringCellValue();
	}

	public void close() throws IOException {
		workbook.close();
	}
	
	//method for practice questions of Array
	public String getCellDataByTitle(String sheetName, String questionTitle, String columnName) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row headerRow = sheet.getRow(0);
        int colIndex = -1;

        // Locate the column index based on the column name
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                colIndex = cell.getColumnIndex();
                break;
            }
        }

        // Return data for the row where question title matches
        for (Row row : sheet) {
            Cell titleCell = row.getCell(0);
            if (titleCell != null && titleCell.getStringCellValue().equalsIgnoreCase(questionTitle)) {
                Cell targetCell = row.getCell(colIndex);
                return targetCell != null ? targetCell.getStringCellValue() : "";
            }
        }
        return null;
    }
	
	// Method to get the total number of rows in a sheet
    public int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist.");
        }
        return sheet.getLastRowNum(); // Returns the zero-based index of the last row
    }
    
    // Method to get the total number of columns in the first row of the sheet
    public int getColumnCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist.");
        }
        
        // Get the first row (usually contains headers)
        Row firstRow = sheet.getRow(0); // The first row is at index 0
        if (firstRow == null) {
            return 0; // No columns if there is no row
        }
        
        // Returns the number of cells in the first row
        return firstRow.getPhysicalNumberOfCells();
    }
}

