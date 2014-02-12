package com.common.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pages.HomePage;
import com.pages.Page;

public class HomePage_Common  extends Page implements HomePage{
	private String expectedTitle = "AKQA: Home";
	private final String path = "/";
	
	private static HomePage_Common instance = new HomePage_Common();

	public static HomePage_Common getInstance() {
		return instance;
	}
	
	public void navigateTo(WebDriver driver) {
		System.out.println("Common - navigate to home page");
		
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
		return driver.getCurrentUrl().contains(getPath());
	}
	
	public boolean isTitleAsExpected(WebDriver driver) {
		return driver.getTitle().equalsIgnoreCase(getExpectedTitle());
	}
	
	public void invvokeContactLink(WebDriver driver){
		System.out.println("Common - invoke Contact Link");
		
		String xpath = getPageElementsXpath("contact_link"); 
		waitForElementToBePresent(driver, By.xpath(xpath));
		invokeElementByXpath(driver, xpath);
	}
	
	public String getPageElementsXpath(String element){
		return getPageElementsXpath().get(element);
	}

	public Map<String, String> getPageElementsXpath() {
		Map<String, String> elements = new HashMap<String, String>();
		
		elements.put("contact_link",
				"//*[@href='/contact']");
		
		return elements;

	}
}
