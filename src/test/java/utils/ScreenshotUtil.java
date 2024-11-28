package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	 public static String captureScreenshot(WebDriver driver, String testName) {
		 
		 	// Generate a unique filename using time stamp to avoid file name conflicts
		 	String timestamp = String.valueOf(System.currentTimeMillis());
		 	String uniqueFileName = testName + "_" + timestamp + ".png";
	        
	        // Define the directory where screenshots will be saved
	        String screenshotDirectory =  System.getProperty("user.dir") + "/screenshots/";
	        
	        // Create the file
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	        // Define the full path for the screenshot
	        String screenshotPath = screenshotDirectory + uniqueFileName;

		 
//	        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
//	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        try {
	            Files.createDirectories(new File(screenshotPath).getParentFile().toPath());
	            Files.copy(src.toPath(), new File(screenshotPath).toPath());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return screenshotPath;
	 }

}
