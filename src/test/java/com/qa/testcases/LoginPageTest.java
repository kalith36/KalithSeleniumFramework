package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class LoginPageTest extends TestUtil{
	
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage =new LoginPage();
	}

	@Test(priority=1)
	public void loginTest() {
		homePage = loginPage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=2)
	public void loginPageTitletest() {
		String loginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Leaftaps - TestLeaf Automation Platform","Login Page title is not matched");
		
	}
	
	@Test(priority=3)
	public void loginPageLogoTest() {
		boolean logoValidation = loginPage.logoValidation();
		Assert.assertEquals(logoValidation, true,"Login page logo is not displayed");
	}
	
	/*@AfterMethod
	public void tearDown() {
		driver.close();
	}*/
}
