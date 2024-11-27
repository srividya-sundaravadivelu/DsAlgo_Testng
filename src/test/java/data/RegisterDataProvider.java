package data;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class RegisterDataProvider {
	
private static final String REGISTRATION_SHEET = "registrationSheet";
    
    @DataProvider(name = "invalidRegistrationDataProvider")
    public static Object[][] invalidRegistrationDataProvider() throws IOException {
        Object[][] data = DsAlgoDataProvider.loadDataFromExcelForDataProvider(REGISTRATION_SHEET);

        return data;
    }

}
