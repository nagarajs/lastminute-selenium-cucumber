package com.automated.acceptance.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.ContactPage;
import com.pages.PagesFactory;

import cucumber.annotation.en.Then;

public class ContactPageStepDefinitions {
	private final WebDriver driver;
	private ContactPage contactPage;
	
	public ContactPageStepDefinitions(SharedDriver driver) {
		this.driver = driver;
		PagesFactory f = PagesFactory.getInstance();
		contactPage = f.createContactPage();
	}
	
	@Then("^the contact page is displayed$")
	public void the_contact_page_is_displayed() throws Throwable {
		Assert.assertTrue("The contact page is not displayed as expected.",contactPage.isUrlAsExpected(driver));
	}
}
