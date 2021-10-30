package com.qa.steps;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

import cucumber.api.java.en.Given;

public class LoginPageTest extends TestUtil{

	LoginPage loginPage;
	HomePage homePage;

	@Given("^user opens the browser with url$")
	public void user_opens_the_browser_with_url(){
		initialization();

	}

	@Given("^user login with username and password$")
	public void user_login_with_username_and_password(){
		loginPage=new LoginPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Given("^validate the HomePage Title$")
	public void validate_the_HomePage_Title(){
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle,"Leaftaps - TestLeaf Automation Platform","Home Page Title is not matched");
	}
	
	

}
