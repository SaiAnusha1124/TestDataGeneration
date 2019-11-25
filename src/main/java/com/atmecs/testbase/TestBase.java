package com.atmecs.testbase;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.atmecs.constants.ConstantsFilePaths;
import com.atmecs.reports.LogReports;
import com.atmecs.utils.ReadLocatorsFile;

public class TestBase{

	Properties baseProperty;
	String url, browser, normal;
	public static WebDriver driver;
	public static LogReports log = new LogReports();
	@BeforeTest
	public void initializeBrowser() {
		baseProperty = ReadLocatorsFile.loadProperty(ConstantsFilePaths.CONFIG_FILE);
		url = baseProperty.getProperty("url");
		browser = baseProperty.getProperty("browsertype");
		// browser = System.getenv("browserName");
		normal = baseProperty.getProperty("normal");
		if (normal.equalsIgnoreCase("normal")) {

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", ConstantsFilePaths.CHROME_FILE);

				driver = new ChromeDriver();
				log.info("Chrome is Started");

			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", ConstantsFilePaths.FIREFOX_FILE);
				driver = new FirefoxDriver();
				log.info("Firefox is Started");

			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", ConstantsFilePaths.IE_FILE);
				driver = new InternetExplorerDriver();
				log.info("IE is Started");
			}
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}