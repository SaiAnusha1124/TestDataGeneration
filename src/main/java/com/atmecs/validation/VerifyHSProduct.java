/*package com.atmecs.validation;

import java.util.Properties;
import org.openqa.selenium.By;
import com.atmecs.actions.ClickOnElementAction;
import com.atmecs.constants.ConstantsFilePaths;
import com.atmecs.testbase.TestBase;
import com.atmecs.utils.LocatorType;
import com.atmecs.utils.ReadLocatorsFile;

public class VerifyHSProduct extends TestBase {
	static String actualhomepage, actualshirtsize, actualname, actualshirtcolor, actualprice, actualtotal,
			actualtotalafterupdate, actualitemname, actualmensactualhomepage, actualhotsauce, actualmerchandise,
			actualclearance, actualnewtohotsauce, actualfaq;
	static Properties properties, properties1;
	static ClickOnElementAction click = new ClickOnElementAction();

	public static void validatingProduct() {
		actualitemname = driver.findElement(By.xpath((properties.getProperty("loc-verify-itemname")))).getText();
		ValidationResult.validateData(actualitemname, properties1.getProperty("expecteditemname"));

		actualshirtsize = driver.findElement(By.xpath((properties.getProperty("loc-verify-shirtsize")))).getText();
		ValidationResult.validateData(actualshirtsize, properties1.getProperty("expectedshirtsize"));

		actualname = driver.findElement(By.cssSelector((properties.getProperty("loc-verify-name")))).getText();
		ValidationResult.validateData(actualname, properties1.getProperty("expectedname"));

		actualshirtcolor = driver.findElement(By.cssSelector((properties.getProperty("loc-verify-shirtcolor")))).getText();
		ValidationResult.validateData(actualshirtcolor, properties1.getProperty("expectedshirtcolor"));

		actualprice = driver.findElement(By.xpath((properties.getProperty("loc-verify-price")))).getText();
		ValidationResult.validateData(actualprice, properties1.getProperty("expectedprice"));

		actualtotal = driver.findElement(By.xpath((properties.getProperty("loc-verify-price")))).getText();
		ValidationResult.validateData(actualtotal, properties1.getProperty("expectedtotal"));
		log.info("Validated Product Details");
	}

	public static void validatingAfterUpdate() {
		actualtotalafterupdate=driver.findElement(By.xpath((properties.getProperty("loc-verify-totalafterupdate")))).getText();
		ValidationResult.validateData(actualtotalafterupdate,properties1.getProperty("expectedtotalafterupdate"));
		log.info("Completed Selecting Shirt and validating all details");
	}

	public static void testingHomePageTabs() {
		
		log.info("Validated Home Page");
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);
		properties1 = ReadLocatorsFile.loadProperty(ConstantsFilePaths.TESTDATA_FILE);

		click.clickElement(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc-click-hotsauces"));
		actualhotsauce = driver.findElement(By.cssSelector((properties.getProperty("loc-click-hotsauces")))).getText();
		ValidationResult.validateData(actualhotsauce, properties1.getProperty("expectedhotsauce"));

		click.clickElement(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc-click-merchandise"));
		actualmerchandise = driver.findElement(By.cssSelector((properties.getProperty("loc-click-merchandise")))).getText();
		ValidationResult.validateData(actualmerchandise, properties1.getProperty("expectedmerchandise"));

		click.clickElement(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc-click-clearance"));
		actualclearance = driver.findElement(By.cssSelector((properties.getProperty("loc-click-clearance")))).getText();
		ValidationResult.validateData(actualclearance, properties1.getProperty("expectedclearance"));

		click.clickElement(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc-click-newtohotsauce"));
		actualnewtohotsauce = driver.findElement(By.cssSelector((properties.getProperty("loc-verify-newtohotsauce")))).getText();
		ValidationResult.validateData(actualnewtohotsauce, properties1.getProperty("expectednewtohotsauce"));

		click.clickElement(driver, LocatorType.CSSSELECTOR, properties.getProperty("loc-click-faq"));
		actualfaq = driver.findElement(By.cssSelector((properties.getProperty("loc-verify-faq")))).getText();
		ValidationResult.validateData(actualfaq, properties1.getProperty("expectedfaq"));
		log.info("Successfully Validated all tabs in a Home Page");
	}
}
*/
