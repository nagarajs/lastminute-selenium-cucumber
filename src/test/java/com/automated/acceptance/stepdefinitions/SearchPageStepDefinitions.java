package com.automated.acceptance.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.common.pages.HotelSearchPage;
import com.pages.PagesFactory;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;

public class SearchPageStepDefinitions {
	
	private final WebDriver driver;
	private HotelSearchPage hotelSearchPage;

	
	public SearchPageStepDefinitions(SharedDriver driver) {
		this.driver = driver;
		PagesFactory f = PagesFactory.getInstance();
		hotelSearchPage = f.createHotelSearchPage();
	}
	
	
	@Given("^I am on the Hotels Search page$")
	public void gotoHotelSearchPage() throws Throwable {
		hotelSearchPage.navigateTo(driver,"51.46008931999998","-0.3489240807142856");   
	}

	@When("^I search for hotels in city or current location \"([^\"]*)\"$")
	public void searchForHotels(String arg1) throws Throwable {
	    
	}

	@Then("^Hotel results are displayed$")
	public void getResults() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}



}
