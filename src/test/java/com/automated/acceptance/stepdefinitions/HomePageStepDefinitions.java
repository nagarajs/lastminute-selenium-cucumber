package com.automated.acceptance.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.HomePage;
import com.pages.PagesFactory;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;

public class HomePageStepDefinitions {
	private final WebDriver driver;
	private HomePage homePage;
	
	
	
	public HomePageStepDefinitions(SharedDriver driver) {
		this.driver = driver;
		PagesFactory f = PagesFactory.getInstance();
		homePage = f.createHomePage();
		
	}
	
	@Given("^I am viewing the AKQA landing page$")
	public void I_am_viewing_the_AKQA_landing_page() throws Throwable {
		homePage.navigateTo(driver);
		Assert.assertTrue("Landing Page title is not as expected", homePage.isTitleAsExpected(driver));
		
	}

	@When("^I invoke the contact link$")
	public void I_invoke_the_contact_link() throws Throwable {
		homePage.invvokeContactLink(driver);
	}
}
