package com.qa.steps;

import org.testng.annotations.Test;

import com.qa.pages.CreateContactPage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CreateConactTest extends TestUtil{
	LoginPage loginPage;
	CreateContactPage createContactPage;
	
	@Given("^user login into Application and enters create contact page$")
	public void user_login_into_Application_and_enters_create_contact_page() {
		initialization();
		createContactPage = new LoginPage().validateLogin(prop.getProperty("username"), prop.getProperty("password"))
		.VerifyCRMSFALink().validateContactsLink().clickOnCreateContact();
	}
	@Test(dataProvider="fetchData")
	@Then("^user enter the contact details and click the submit button$")
	public void user_enter_the_contact_details_and_click_the_submit_button(String Fname,String Lname, String curr) {
		createContactPage.createNewContact(Fname, Lname, curr);
	}

}
