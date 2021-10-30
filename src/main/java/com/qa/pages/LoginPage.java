package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Driver initialization
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Object Repository
	
	@FindBy(id="username") WebElement userName;
	@FindBy(id="password") WebElement password;
	@FindBy(xpath="//input[@type='submit']") WebElement loginBTN;
	@FindBy(xpath="//div[@id='logo']/img") WebElement logo;
	
	//Page functions
	
	public HomePage validateLogin(String Uname,String pwd) {
		userName.sendKeys(Uname);
		password.sendKeys(pwd);
		loginBTN.click();
		return new HomePage();
		
	}
	
	public boolean logoValidation() {
		 return logo.isDisplayed();
		
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
}
