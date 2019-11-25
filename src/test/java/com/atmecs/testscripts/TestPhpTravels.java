package com.atmecs.testscripts;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.actions.ClickOnElementAction;
import com.atmecs.actions.PageActions;
import com.atmecs.actions.SendKeysAction;
import com.atmecs.constants.ConstantsFilePaths;
import com.atmecs.dataproviders.ReadExcelFile;
import com.atmecs.reports.ExtentReport;
import com.atmecs.testbase.TestBase;
import com.atmecs.utils.LocatorType;
import com.atmecs.utils.ReadLocatorsFile;
import com.atmecs.validation.VerifyPhpTravels;

public class TestPhpTravels extends TestBase {

	String actualhome, actualdefaultbooking, actualdate;
	Properties properties, properties1;
	ClickOnElementAction click = new ClickOnElementAction();
	SendKeysAction sendkeys = new SendKeysAction();
	ReadExcelFile readexcel = new ReadExcelFile();
	VerifyPhpTravels verify = new VerifyPhpTravels();
	String browserUrl;
	String username, password;
	PageActions page = new PageActions();

	@BeforeClass
	public void launchingUrl() throws IOException {
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.CONFIG_FILE);
		browserUrl = properties.getProperty("phptravels_url");
		driver.get(browserUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginHomePage() {
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);
		click.clickElement(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc.sendkey.mailid"));
		username = page.getdata_fromExcel("inputs-phptravels", "data", "mailid");
		sendkeys.sendKeys(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc.sendkey.mailid"), username);
		click.clickElement(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc.sendkey.password"));
		password = page.getdata_fromExcel("inputs-phptravels", "data", "password");
		sendkeys.sendKeys(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc.sendkey.password"), password);
		click.clickElement(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc.click.login"));
		log.info("Succesfully loged in");
		verify.verifyingHomePage();
		log.info("Validated Travels Home Page");
		verify.verifyingbooking();
		log.info("Validated default Bookings and date");
		ExtentReport.reportLog("loginHomePage", "failed");
	}
}
