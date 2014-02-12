package com.common.pages;

import org.openqa.selenium.WebDriver;

import com.pages.Page;



public class HotelSearchPage extends Page {
	
	private String expectedTitle = "AKQA: Home";
	private final String path = "/hotels/results?";
	private final String location = "Current+location";
	private final String queryParameteres = "checkInDate=2014-02-12&checkOutDate=2014-02-13&numberOfNights=1&numberOfAdults=2&ageOfChild1=&ageOfChild2=&ageOfChild3=&city=&country=&hotelTonight=Y&landingpage=&landing-page=&hotelType=";
	
	private static HotelSearchPage instance = new HotelSearchPage();

	public static HotelSearchPage getInstance() {
		return instance;
	}
	
	public void navigateTo(WebDriver driver, String lat, String lng) throws InterruptedException {
		System.out.println("Navigate to Hotel Search page");
		String url = System.getProperty("test.baseUrl") + getPath()
											+ "location=" + getLocation() + "&"
											+ "latitude=" + lat + "&"
											+ "longitude=" + lng + "&"
											+ getQueryParameters();
										
										
		driver.get(url);
		Thread.sleep(5000);
	}
	
	
	public String getLocation() {
		return this.location;
	}
	
	public String getQueryParameters() {
		return this.queryParameteres;
	}
	
	

	
	public String getPath() {
		return this.path;
	}

}
