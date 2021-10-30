package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.MyHomePage;
import com.qa.util.TestListener;
import com.qa.util.TestUtil;


public class HomePageTest extends TestUtil{

	LoginPage loginPage;
	HomePage homePage;
	MyHomePage myHomePage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initialization();
		loginPage=new LoginPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
		homePage=new HomePage();
		myHomePage=new MyHomePage();
	}

	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "Leaftap - TestLeaf Automation Platform","Home Page Title is not matched");
	}

	@Test(priority=2)
	public void verifyLogoutTest() {
		loginPage = homePage.Logout();
		
	}

	@Test(priority=3)
	public void verifyCRMSFALinkTest() {
		myHomePage = homePage.VerifyCRMSFALink();
	}


	/*@AfterMethod
	public void tearDown() {
		driver.close();
	}*/


}
