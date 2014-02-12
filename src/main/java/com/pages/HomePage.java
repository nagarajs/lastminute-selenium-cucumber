package com.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;

public interface HomePage {
	
	public void navigateTo(WebDriver driver);

	public String getExpectedTitle();

	public String getPath();

	public boolean isUrlAsExpected(WebDriver driver);
	
	public boolean isTitleAsExpected(WebDriver driver);
	
	public void invvokeContactLink(WebDriver driver);
	
	public String getPageElementsXpath(String element);

	public Map<String, String> getPageElementsXpath();
}
