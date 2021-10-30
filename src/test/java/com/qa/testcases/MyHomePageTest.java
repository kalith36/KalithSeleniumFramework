package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.MyHomePage;
import com.qa.util.TestUtil;

public class MyHomePageTest extends TestUtil {
	MyHomePage myHomePage;
	ContactsPage contactsPage;
	LoginPage loginPage;
	HomePage homePage;
	
	
	public MyHomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		new LoginPage().validateLogin(prop.getProperty("username"),prop.getProperty("password")).VerifyCRMSFALink();
		myHomePage=new MyHomePage();

	}
	
	@Test(priority=1)
	public void verifyMyHomePageTitleTest() {
		String myHomePageTitle = myHomePage.verifyMyHomePageTitle();
		Assert.assertEquals(myHomePageTitle, "My Home | opentaps CRM","MyHomePage title is not matched");
	}
	
	@Test(priority=2)
	public void verifyContactsLinkTest() {
		contactsPage = myHomePage.validateContactsLink();
	}
	
	
	
	/*@AfterMethod
	public void tearDown() {
		driver.close();
	}*/
	
	

}
