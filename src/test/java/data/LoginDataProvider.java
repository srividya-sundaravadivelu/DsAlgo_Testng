package data;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    private static final String VALID_LOGIN_SHEET = "validLoginSheet";
    private static final String INVALID_LOGIN_SHEET = "invalidLoginSheet";

    @DataProvider(name = "validLoginDataProvider")
    public static Object[][] validLoginDataProvider() throws IOException {
        Object[][] data = DsAlgoDataProvider.loadDataFromExcelForDataProvider(VALID_LOGIN_SHEET);
        return data;
    }
    
    @DataProvider(name = "invalidLoginDataProvider")
    public static Object[][] invalidLoginDataProvider() throws IOException {
        Object[][] data = DsAlgoDataProvider.loadDataFromExcelForDataProvider(INVALID_LOGIN_SHEET);
        return data;       
    }
}
