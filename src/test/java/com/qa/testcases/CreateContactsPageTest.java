package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pages.CreateContactPage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class CreateContactsPageTest extends TestUtil {
	CreateContactPage createContactpage;
	
	public CreateContactsPageTest() {
		super();
	}
	
	@BeforeTest
	public void set() {
		excelfileName="file";
	}
	@BeforeMethod
	public void setup() {
		
		initialization();
		new LoginPage().validateLogin(prop.getProperty("username"), prop.getProperty("password"))
		.VerifyCRMSFALink()
		.validateContactsLink().clickOnCreateContact();
		createContactpage=new CreateContactPage();
	}
	
	@Test(dataProvider="fetchData")
	public void validateCreateContactTest(String Fname,String Lname,String curr)  {
		createContactpage.createNewContact(Fname, Lname, curr);
		
	}
	
	/*@AfterMethod
	public void tearDown() {
		driver.close();
	}*/

}
