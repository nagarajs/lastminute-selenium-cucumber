package com.common.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.pages.ContactPage;
import com.pages.Page;

public class ContactPage_Common extends Page implements ContactPage {
	private String expectedTitle = "AKQA: Contact - London";
	private final String path = "/#/contact";
	
	private static ContactPage_Common instance = new ContactPage_Common();

	public static ContactPage_Common getInstance() {
		return instance;
	}
		
	public void navigateTo(WebDriver driver) {
		String url = System.getProperty("test.baseUrl") + getPath();
		driver.get(url);
	}

	public String getExpectedTitle() {
		return this.expectedTitle;
	}

	public String getPath() {
		return this.path;
	}

	public boolean isUrlAsExpected(WebDriver driver) {
		System.out.println("Common - contact page url");
		return driver.getCurrentUrl().contains(getPath());
	}
	
	public boolean isTitleAsExpected(WebDriver driver) {
		return driver.getTitle().equalsIgnoreCase(getExpectedTitle());
	}
	
	public String getPageElementsXpath(String element){
		return getPageElementsXpath().get(element);
	}

	public Map<String, String> getPageElementsXpath() {
		Map<String, String> elements = new HashMap<String, String>();
				
		return elements;

	}
}
