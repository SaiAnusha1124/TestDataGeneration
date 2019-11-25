package com.atmecs.validation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.atmecs.actions.ClickOnElementAction;
import com.atmecs.actions.PageActions;
import com.atmecs.constants.ConstantsFilePaths;
import com.atmecs.testbase.TestBase;
import com.atmecs.utils.DateConversion;
import com.atmecs.utils.LocatorType;
import com.atmecs.utils.ReadLocatorsFile;

public class VerifyPhpTravels extends TestBase {
	String expectedhomepage, expecteddefaultbooking, expecteddate, expectedbookingid;
	String actualhome, actualdefaultbooking, actualdate, actualtime, actualbookingid;
	Properties properties, properties1;
	String parentWindowHandler, subWindowHandler;
	ClickOnElementAction click = new ClickOnElementAction();
	PageActions page = new PageActions();

	public void verifyingHomePage() {
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);

		actualhome = driver.findElement(By.cssSelector(properties.getProperty("validate.homepage"))).getText();
		expectedhomepage = page.getdata_fromExcel("inputs-phptravels", "data", "expectedhomepage");
		ValidationResult.validateData(actualhome, expectedhomepage);
	}

	public void verifyingbooking() {
		actualdefaultbooking = driver.findElement(By.cssSelector(properties.getProperty("validate.defaultbooking"))).getText();
		expecteddefaultbooking = page.getdata_fromExcel("inputs-phptravels", "data", "expecteddefaultbooking");
		ValidationResult.validateData(actualdefaultbooking, expecteddefaultbooking);

		String date = driver.findElement(By.cssSelector(properties.getProperty("validate.date"))).getText();
		List<String> expecteddates = DateConversion.convertDate(date);
		Assert.assertEquals(expecteddates.get(0), expecteddates.get(1));
		actualtime = driver.findElement(By.cssSelector(properties.getProperty("validate.time"))).getText();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String time = dtf.format(now);
		ValidationResult.validateData(actualtime, time);
		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc.click.invoice"));
		parentWindowHandler = driver.getWindowHandle();
		subWindowHandler = null;
		for (String childWindowHandle : driver.getWindowHandles()) {
			if (!childWindowHandle.equals(parentWindowHandler)) {
				driver.switchTo().window(childWindowHandle);
				actualbookingid = driver.findElement(By.cssSelector(properties.getProperty("validate.bookingid"))).getText();
				expectedbookingid = page.getdata_fromExcel("inputs-phptravels", "data", "expectedbookingid");
				ValidationResult.validateData(actualbookingid, expectedbookingid);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandler);
	}
}
