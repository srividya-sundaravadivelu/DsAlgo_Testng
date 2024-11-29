package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	  private static ExtentReports extent;

	    public static ExtentReports getExtentReports() {
	        if (extent == null) {
	            extent = new ExtentReports();
	            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/SparkReport.html");
	            sparkReporter.config().setDocumentTitle("DSAlgo Automation Test Report");
	            sparkReporter.config().setReportName("DSAlgo functional testing");
	            
	            extent.setSystemInfo("Environment", "QA");
	            extent.setSystemInfo("OS", System.getProperty("os.name"));
	            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
	            
	            extent.attachReporter(sparkReporter);
	        }
	        return extent;
	    }
	    

}
