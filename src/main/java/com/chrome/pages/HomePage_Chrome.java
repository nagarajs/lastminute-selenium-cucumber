package com.chrome.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.common.pages.HomePage_Common;

public class HomePage_Chrome  extends HomePage_Common {
	private static HomePage_Chrome instance = new HomePage_Chrome();

	public static HomePage_Chrome getInstance() {
		return instance;
	}
	
	public void invvokeContactLink(WebDriver driver){
		System.out.println("Chrome - invoke Contact Link");
		
		String xpath = getPageElementsXpath("contact_link"); 
		waitForElementToBePresent(driver, By.xpath(xpath));
		invokeElementByXpath(driver, xpath);
	}
}
