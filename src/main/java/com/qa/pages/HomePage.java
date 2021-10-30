package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='Logout']") WebElement logout;
	@FindBy(linkText="CRM/SFA") WebElement crmsfaLink;
	
	public MyHomePage VerifyCRMSFALink() {
		crmsfaLink.click();
		return new MyHomePage();
	}
	
	public LoginPage Logout() {
		logout.click();
		return new LoginPage();
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

}