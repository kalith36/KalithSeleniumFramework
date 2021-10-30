package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class MyHomePage extends TestBase{
	
	public MyHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Contacts") WebElement contactsLink;
	@FindBy(linkText="Leads") WebElement leadsLink;
	@FindBy(linkText="Accounts") WebElement accountsLink;
	
	public String verifyMyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage validateContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public My_LeadsPage validateLeadsLink() {
		leadsLink.click();
		return new My_LeadsPage();
	}
	
	public AccountPage validateAccountsLink() {
		accountsLink.click();
		return new AccountPage();
	}

}
