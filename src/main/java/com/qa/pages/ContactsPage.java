package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Create Contact") WebElement createContact;
	
	
	public CreateContactPage clickOnCreateContact() {
		createContact.click();
		return new CreateContactPage();
	}
	
	

}
