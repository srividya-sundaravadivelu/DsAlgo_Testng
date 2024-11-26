package data;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    private static final String LOGIN_SHEET = "loginSheet";

    @DataProvider(name = "validLoginDataProvider")
    public static Object[][] validLoginDataProvider() throws IOException {
        Object[][] data = DsAlgoDataProvider.loadDataFromExcelForDataProvider(LOGIN_SHEET);
        // Return only the first row for valid login data
        return new Object[][] { data[0] };
    }
    
    @DataProvider(name = "invalidLoginDataProvider")
    public static Object[][] invalidLoginDataProvider() throws IOException {
        Object[][] data = DsAlgoDataProvider.loadDataFromExcelForDataProvider(LOGIN_SHEET);

        // Exclude the first row and return the rest for invalid login data
        Object[][] invalidData = new Object[data.length - 1][1];
        for (int i = 1; i < data.length; i++) {
            invalidData[i - 1] = data[i];
        }
        return invalidData;
    }
}
