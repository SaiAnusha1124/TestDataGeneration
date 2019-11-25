//package com.atmecs.testscripts;
//
//import java.io.IOException;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import com.atmecs.actions.ClickOnElementAction;
//import com.atmecs.actions.SendKeysAction;
//import com.atmecs.constants.ConstantsFilePaths;
//import com.atmecs.reports.ExtentReport;
//import com.atmecs.testbase.TestBase;
//import com.atmecs.utils.LocatorType;
//import com.atmecs.utils.ReadExcelFile;
//import com.atmecs.utils.ReadLocatorsFile;
//import com.atmecs.validation.VerifyNSProducts;
//
//public class TestNinjaStoreProducts extends TestBase {
//	String firstproduct, firstquantity, secondproduct, secondquantity, nagative, ninjastore;
//	Properties properties, properties1;
//	ClickOnElementAction click = new ClickOnElementAction();
//	SendKeysAction sendkeys = new SendKeysAction();
//	ReadExcelFile readexcel = new ReadExcelFile();
//	String browserUrl;
//
//	@BeforeClass
//	public void launchingUrl() throws IOException {
//		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.CONFIG_FILE);
//		browserUrl = properties.getProperty("url");
//		driver.get(browserUrl);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}
//
//	@DataProvider
//	public Object[][] inputValues() {
//		Object data[][] = readexcel.readExcel("inputs-NinjaStore", ConstantsFilePaths.TESTDATA_FILE1);
//		return data;
//	}
//
//	@Test(dataProvider = "inputValues")
//	public void selectingNSProducts(String firstproduct, String quantity1, String secondproduct, String quantity2,
//			String NegativeProduct) {
//
//		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);
//		properties1 = ReadLocatorsFile.loadProperty(ConstantsFilePaths.TESTDATA_FILE);
//
//		VerifyNSProducts.verifyingHomePage();
//		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-bttn-search"));
//		sendkeys.sendKeys(driver, LocatorType.XPATH, properties.getProperty("loc-click-bttn-search"), firstproduct);
//		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-search"));
//		log.info("Selected Iphone Product");
//		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-iphone"));
//		VerifyNSProducts.verifyingFirstProduct();
//		driver.findElement(By.xpath(properties.getProperty("loc-sendkeys-quantity1"))).clear();
//		sendkeys.sendKeys(driver, LocatorType.XPATH, properties.getProperty("loc-sendkeys-quantity1"), quantity1);
//		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-addcart1"));
//		log.info("Added product to cart");
//		log.info("Successfully selected and validate for first product");
//		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-bttn-search"));
//		driver.findElement(By.xpath(properties.getProperty("loc-click-bttn-search"))).clear();
//		sendkeys.sendKeys(driver, LocatorType.XPATH, properties.getProperty("loc-click-bttn-search"), secondproduct);
//		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-search"));
//		log.info("Selected MacBook Air Product");
//		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-macbookair"));
//		VerifyNSProducts.verifyingSecondProduct();
//		driver.findElement(By.xpath(properties.getProperty("loc-sendkeys-quantity2"))).clear();
//		sendkeys.sendKeys(driver, LocatorType.XPATH, properties.getProperty("loc-sendkeys-quantity2"), quantity2);
//		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-addcart2"));
//		log.info("Added product to cart");
//		log.info("Successfully selected and validate for second product");
//		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-gotocart2"));
//		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-viewcart"));
//		VerifyNSProducts.verifyingCartList();
//		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-removeproduct"));
//		VerifyNSProducts.afterUpdateGrandTotal();
//		log.info("Sucessfulyy selected and validated both iphone and macbook air products");
//		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-bttn-search"));
//		sendkeys.sendKeys(driver, LocatorType.XPATH, properties.getProperty("loc-click-bttn-search"), NegativeProduct);
//		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-search"));
//		log.info("Selected Chairs as Negative Product");
//		VerifyNSProducts.verifyingNegativeCase();
//		ExtentReport.reportLog("selectingHSProduct", "failed");
//	}
//}