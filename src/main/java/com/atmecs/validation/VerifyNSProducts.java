/*package com.atmecs.validation;

import java.util.Properties;
import org.openqa.selenium.By;
import com.atmecs.constants.ConstantsFilePaths;
import com.atmecs.testbase.TestBase;
import com.atmecs.utils.ReadLocatorsFile;

public class VerifyNSProducts extends TestBase {
	static Properties properties,properties1;
	static String actualhomepage, actualstock, productprice, actualextax, actualdescription, actualsubtotal,
			actualecotax, actualvat, actualhomepage2, actualstock2, productprice2, actualextax2, actualdescription2,
			actualcartproduct1, actualcartproduct2, actualgrandtotal, actualgrandtotal1, actualgrandtotal2,
			actualnegativecase;

	public static void verifyingHomePage() {
		try {
			properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);
			properties1 = ReadLocatorsFile.loadProperty(ConstantsFilePaths.TESTDATA_FILE);
			ValidationResult.validateData( driver.findElement(By.cssSelector((properties.getProperty("loc-verify-homepage-content")))).getText(), properties1.getProperty("expectedhomepage"));
			log.info("Successfully Validated Home Page");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void verifyingFirstProduct() {
		actualstock=driver.findElement(By.xpath((properties.getProperty("loc-verify-availability1")))).getText();
		ValidationResult.validateData(actualstock, properties1.getProperty("expectedstock1"));
		ValidationResult.validateData(driver.findElement(By.xpath((properties.getProperty("loc-verify-productprice1")))).getText(), properties1.getProperty("expectedprice1"));
		ValidationResult.validateData(driver.findElement(By.xpath((properties.getProperty("loc-verify-extax1")))).getText(), properties1.getProperty("expectedextax1"));
		ValidationResult.validateData(driver.findElement(By.xpath((properties.getProperty("loc-verify-description1")))).getText(), properties1.getProperty("expecteddescription1"));
	}
	public static void verifyingSecondProduct() {
		ValidationResult.validateData(driver.findElement(By.xpath((properties.getProperty("loc-verify-availability2")))).getText(), properties1.getProperty("expectedstock2"));
		ValidationResult.validateData(driver.findElement(By.xpath((properties.getProperty("loc-verify-productprice2")))).getText(), properties1.getProperty("expectedprice2"));
		ValidationResult.validateData(driver.findElement(By.xpath((properties.getProperty("loc-verify-extax2")))).getText(), properties1.getProperty("expectedextax2"));
		ValidationResult.validateData(driver.findElement(By.xpath((properties.getProperty("loc-verify-description2")))).getText(), properties1.getProperty("expecteddescription2"));
	}
	public static void verifyingCartList() {
		
		ValidationResult.validateData(driver.findElement(By.xpath((properties.getProperty("loc-verify-cartproduct1")))).getText(), properties1.getProperty("expectedcartproduct1"));		
		ValidationResult.validateData(driver.findElement(By.xpath((properties.getProperty("loc-verify-cartproduct2")))).getText(), properties1.getProperty("expectedcartproduct2"));
		ValidationResult.validateData(driver.findElement(By.xpath((properties.getProperty("loc-verify-grandtotal")))).getText(), properties1.getProperty("expectedgrandtotal"));
	}
	public static void afterUpdateGrandTotal() {
		ValidationResult.validateData(driver.findElement(By.xpath((properties.getProperty("loc-click-afterremoveproducttotal")))).getText(), properties1.getProperty("expectedafterremovegrandtotal"));
	}
	public static void verifyingNegativeCase() {
		ValidationResult.validateData(driver.findElement(By.xpath((properties.getProperty("loc-verify-negativecase")))).getText(), properties1.getProperty("expectednegativecase"));
	}
}
*/