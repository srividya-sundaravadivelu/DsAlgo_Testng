package data;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class TryEditorDataProvider {

    private static final String TRY_EDITOR_SHEET = "pythonCode";
    
    @DataProvider(name = "validTryEditorDataProvider")
    public static Object[][] validTryEditorDataProvider() throws IOException {
        Object[][] data = DsAlgoDataProvider.loadDataFromExcelForDataProvider(TRY_EDITOR_SHEET);
        // Return only the first row for valid try editor data
        return new Object[][] { data[0] };
    }

    @DataProvider(name = "invalidTryEditorDataProvider")
    public static Object[][] invalidTryEditorDataProvider() throws IOException {
        Object[][] data = DsAlgoDataProvider.loadDataFromExcelForDataProvider(TRY_EDITOR_SHEET);

        // Exclude the first row and return the rest for invalid data
        Object[][] invalidData = new Object[data.length - 1][1];
        for (int i = 1; i < data.length; i++) {
            invalidData[i - 1] = data[i];
        }
        return invalidData;
    }
}