package com.rhipe.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.rhipe.qa.base.TestBase;
import com.rhipe.qa.pages.SignUpPage;
import com.rhipe.qa.util.TestUtil;

public class SignUpPageTest extends TestBase {

	SignUpPage signUpPage;
	String sheetName = "Contacts";

	public SignUpPageTest(){
		super();
	}

	@BeforeClass
	public void beforMethod() {
		initialization();
		signUpPage = new SignUpPage();
	}

	@AfterClass()
	public void tearDown() {
		driver.quit();
	}

	
	/*Check the data Fields are present*/
	@Test(priority = 1)
	public void verifyDataFieldsInSignUp(){
		Assert.assertTrue(signUpPage.verifyCustomerNameField(), "CustomerName Field is missing on the page");
		Assert.assertTrue(signUpPage.verifyRegistrationNumberField(), "Registration Number Field  is missing on the page");
		Assert.assertTrue(signUpPage.verifyFirstStreetField(), "First Street Field label is missing on the page");
		Assert.assertTrue(signUpPage.verifySecondStreetField(), "Second Street Field is missing on the page");
		Assert.assertTrue(signUpPage.verifyThirdStreetField(), "Third Street Field  is missing on the page");
		Assert.assertTrue(signUpPage.verifyCityDataField(), "City Field is missing on the page");
		Assert.assertTrue(signUpPage.verifyStateDataField(), "State Field is missing on the page");
		Assert.assertTrue(signUpPage.verifyCountryDataField(), "Country Field is missing on the page");
	}
	
	/*Check the Title of the page is same as expected*/
	@Test(priority = 3)
	public void verifyTitleOfThePage(){
	
		Assert.assertTrue(signUpPage.verifyTitleOfThePage(), "Title name is displayed as expected");		
		
	}
	
	/*Verify Submit button is present*/
	@Test(priority = 4)
	public void verifySubmitButtonIsDisplayed(){
	
		Assert.assertTrue(signUpPage.verifySubmitButtonIsDisplayed(), "Captcha label is displayed");		
		
	}

	/* PreFill the SignUp form */
	@Test(priority =2, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String name, String id, String firstStreet, String secondStreet,
			String thirdStreet, String cityName, String stateName, String countryName, String postCodeNumber,
			String phone, String faxNumber, String webSite, String emailId, String infoSource, String industry,
			String billingAddress, String signatoryFirstName, String signatoryLastName, String signatoryPhone,
			String signatoryEmail, String signatoryJob, String signatoryAlternateAddress) {

		signUpPage.createNewContact(name, id, firstStreet, secondStreet, thirdStreet, cityName, stateName, countryName,
				postCodeNumber, phone, faxNumber, webSite, emailId, infoSource, industry, billingAddress,
				signatoryFirstName, signatoryLastName, signatoryPhone, signatoryEmail, signatoryJob,
				signatoryAlternateAddress);
	}

	@DataProvider
	public Object[][] getCRMTestData() throws InterruptedException, InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

}
