package com.atmecs.reports;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import com.atmecs.constants.ConstantsFilePaths;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
	public static WebDriver driver;
	static ExtentReports extent = new ExtentReports();

	public static void reportLog(String testname, String Failuremsg) {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter(ConstantsFilePaths.EXTENT_REPORTFILE);

		extent.attachReporter(reporter);

		ExtentTest logger = extent.createTest(testname);
		logger.log(Status.INFO, testname);
		logger.log(Status.PASS, testname);

	}

	@AfterSuite
	public void closeExtent() {
		extent.flush();
	}
}
