package com.pages;
import com.chrome.pages.HomePage_Chrome;
import com.common.pages.ContactPage_Common;
import com.common.pages.HomePage_Common;
import com.common.pages.HotelSearchPage;

public class PagesFactory {
	private final String platform = System.getProperty("test.browserName");
	
	private static PagesFactory instance = new PagesFactory();

	public static PagesFactory getInstance() {
		return instance;
	}

	public ContactPage createContactPage() {
		
		return ContactPage_Common.getInstance();
	}
	
	public HomePage createHomePage() {
		if ("chrome".equalsIgnoreCase(platform)) {
			return HomePage_Chrome.getInstance();
		}
		
		return HomePage_Common.getInstance();
	}
	
	public HotelSearchPage createHotelSearchPage() {
		if ("chrome".equalsIgnoreCase(platform)) {
			return  HotelSearchPage.getInstance();
		}
		
		return  HotelSearchPage.getInstance();
	}
	
	
	
}
