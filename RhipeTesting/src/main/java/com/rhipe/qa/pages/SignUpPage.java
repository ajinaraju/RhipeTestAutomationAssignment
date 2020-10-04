/*  Page class for SignUp page*/

package com.rhipe.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.rhipe.qa.base.TestBase;

public class SignUpPage extends TestBase {


	@FindBy(id="CustomerName")
	WebElement customerName;


	@FindBy(id="RegistrationNumber")
	WebElement registrationNumber;

	@FindBy(id="Street1")
	WebElement street1;

	@FindBy(id="Street2")
	WebElement street2;

	@FindBy(id="Street3")
	WebElement street3;


	@FindBy(id="City")
	WebElement city;

	@FindBy(id="State")
	WebElement state;

	@FindBy(id="Country")
	WebElement country;


	@FindBy(id="Postcode")
	WebElement postCode;

	@FindBy(id="MainPhone")
	WebElement mainPhone;

	@FindBy(id="WebUrl")
	WebElement webUrl;

	@FindBy(id="Email")
	WebElement email;

	@FindBy(id="Fax")
	WebElement fax;

	@FindBy(id="Source")
	WebElement source;

	@FindBy(id="IndustryType")
	WebElement industryType;

	@FindBy(id="useanotheraddress")
	WebElement useAnotherAddress;

	@FindBy(id="PrimaryContactFirstName")
	WebElement primaryContactFirstName;

	@FindBy(id="PrimaryContactLastName")
	WebElement primaryContactLastName;

	@FindBy(id="PrimaryContactPhone")
	WebElement primaryContactPhone;

	@FindBy(id="PrimaryContactJobTitle")
	WebElement primaryContactJobTitle;

	@FindBy(id="PrimaryContactEmail")
	WebElement primaryContactEmail;

	@FindBy(id="usesamecontact")
	WebElement useSameContact;
	
	
	@FindBy(className="entry-title")
	WebElement className;
	
	@FindBy(id="submitbutton")
	WebElement submitButton;
	
	
	public boolean verifyCustomerNameField(){
		return customerName.isDisplayed();
	}

	public boolean verifyRegistrationNumberField(){
		return registrationNumber.isDisplayed();
	}

	public boolean verifyFirstStreetField(){
		return street1.isDisplayed();
	}

	public boolean verifySecondStreetField(){
		return street2.isDisplayed();
	}

	public boolean verifyThirdStreetField(){
		return street3.isDisplayed();
	}

	public boolean verifyCityDataField(){
		return city.isDisplayed();
	}

	public boolean verifyStateDataField(){
		return state.isDisplayed();
	}

	public boolean verifyCountryDataField(){
		return country.isDisplayed();
	}


    // Prefilling the signup page fields
	public void createNewContact(String name, String id, String firstStreet, String secondStreet, String thirdStreet,
			String cityName,String stateName,String countryName,String postCodeNumber,String phone,String faxNumber,
			String webSite,String emailId,String infoSource,String industry,String billingAddress,String signatoryFirstName,
			String signatoryLastName,String signatoryPhone,String signatoryEmail,String signatoryJob,String signatoryAlternateAddress)
	{
		 // System.out.println(className.getText());
		//Sign up with Rhipe

		customerName.sendKeys(name);
		registrationNumber.sendKeys(id);
		street1.sendKeys(firstStreet);
		street2.sendKeys(secondStreet);
		street3.sendKeys(thirdStreet);
		city.sendKeys(cityName);
		state.sendKeys(stateName);
		country.sendKeys(countryName);
		postCode.sendKeys(postCodeNumber);
		mainPhone.sendKeys(phone);
		email.sendKeys(emailId);
		webUrl.sendKeys(webSite);
		fax.sendKeys(faxNumber);
		source.sendKeys(infoSource);
		industryType.sendKeys(industry);
		useAnotherAddress.sendKeys(billingAddress);
		primaryContactFirstName.sendKeys(signatoryFirstName);
		primaryContactLastName.sendKeys(signatoryLastName);
		primaryContactPhone.sendKeys(signatoryPhone);
		primaryContactJobTitle.sendKeys(signatoryJob);
		primaryContactEmail.sendKeys(signatoryEmail);
		useSameContact.sendKeys(signatoryAlternateAddress);

	}
	
	public boolean verifyTitleOfThePage() {
		
		return (className.getText().equals("Sign up with Rhipe"));
	}
	
	public boolean verifySubmitButtonIsDisplayed() {
		
		
		return (submitButton.isDisplayed());
	}


//	public boolean verifyContactsLabel(){
//		return customerName.isDisplayed();
//	}

	public SignUpPage(){
		PageFactory.initElements(TestBase.driver, this);


	}
}
