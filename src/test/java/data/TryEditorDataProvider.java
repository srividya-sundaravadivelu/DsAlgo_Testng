package data;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class TryEditorDataProvider {

    private static final String VALID_TRY_EDITOR_SHEET = "validTryEditor";
    private static final String INVALID_TRY_EDITOR_SHEET = "invalidTryEditor";
    
    @DataProvider(name = "validTryEditorDataProvider")
    public static Object[][] validTryEditorDataProvider() throws IOException {
        Object[][] data = DsAlgoDataProvider.loadDataFromExcelForDataProvider(VALID_TRY_EDITOR_SHEET);
        return data;
    }

    @DataProvider(name = "invalidTryEditorDataProvider")
    public static Object[][] invalidTryEditorDataProvider() throws IOException {
        Object[][] data = DsAlgoDataProvider.loadDataFromExcelForDataProvider(INVALID_TRY_EDITOR_SHEET);
        return data;
        
    }
}