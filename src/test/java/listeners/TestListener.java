package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import driver.DriverManager;
import utils.ExtentReportManager;
import utils.LogHelper;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {
	
	    
	    // ThreadLocal for thread-safe ExtentTest instance
	    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	    @Override
	    public void onTestStart(ITestResult result) {
	    	  String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
	          
	          // Create an ExtentTest object and attach the browser info
	          ExtentTest test = ExtentReportManager.getExtentReports().createTest(result.getMethod().getMethodName());
	          test.info("Running test on browser: " + browser);
          
	          // Attach group names to the test
	          String[] groups = result.getMethod().getGroups();
	          if (groups.length > 0) {
	              test.assignCategory(groups);  // Use assignCategory to display groups
	          }
	         
	          extentTest.set(test);	          
	          LogHelper.info("Test started: " + result.getName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        // Log the success status and any other information for the passed test
	        extentTest.get().log(Status.PASS, "Test Passed Successfully!");
	        extentTest.get().log(Status.INFO, "Execution Time: " + (result.getEndMillis() - result.getStartMillis()) + " ms");
	        LogHelper.info("Test Success: " + result.getName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        // Log the failure status and include exception details
	        String screenshotPath = ScreenshotUtil.captureScreenshot(DriverManager.getDriver(), result.getMethod().getMethodName());
	        extentTest.get().log(Status.FAIL, "Test Failed: " + result.getThrowable())
	                .addScreenCaptureFromPath(screenshotPath);
	        LogHelper.error("Test Failed: " + result.getName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        // Log skipped test with reason
	        extentTest.get().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
	        LogHelper.warn("Test Skipped: " + result.getName());
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Handle partial failure (not commonly used)
	        extentTest.get().log(Status.WARNING, "Test failed but within success percentage.");
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        // Before all tests start
	    	LogHelper.info("Test Suite Started: " + context.getName());	       
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        // Flush the report data once all tests are complete
	        ExtentReportManager.getExtentReports().flush();
	        LogHelper.info("Test Suite Finished : " + context.getName());
	    }

	}


