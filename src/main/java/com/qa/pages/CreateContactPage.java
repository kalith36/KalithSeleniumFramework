package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class CreateContactPage extends TestBase {
	
	public CreateContactPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='firstNameField']") WebElement firstNameInContact;
	@FindBy(xpath="//input[@id='lastNameField']") WebElement lastNameInContact;
	@FindBy(id="createContactForm_preferredCurrencyUomId") WebElement preferredCurrency;
	@FindBy(xpath="//input[@value='Create Contact']") WebElement createContactBTN;
	
	public ViewContactsPage createNewContact(String firstname,String lastname,String currency)  {
		
		firstNameInContact.sendKeys(firstname);
		lastNameInContact.sendKeys(lastname);
		selectDropDownUsingValue(preferredCurrency, currency);
		createContactBTN.click();
		return new ViewContactsPage();
	}

}
