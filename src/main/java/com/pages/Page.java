package com.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.common.pages.HomePage_Common;

public class Page {
	public final int DEFAULT_WAIT = 20;
	
	public boolean isTitleCorrect(WebDriver driver, Page page) {
		return page.isTitleAsExpected(driver);
	}
	
	public boolean isTitleAsExpected(WebDriver driver) {
		return driver.getTitle().equalsIgnoreCase("Title");
	}
	
	public void navigateToPage(WebDriver driver, Page page){
		page.navigateTo(driver);
	}
	
	public void navigateTo(WebDriver driver) {
		driver.get(System.getProperty("test.baseUrl"));
	}
	
	public void sendTabKey(WebElement element){
		element.sendKeys(Keys.TAB);
	}
	
	public boolean waitForElementToBePresent(WebDriver driver, By by){
		
		for(int i = DEFAULT_WAIT; i >= 0; i--){
			if(driver.findElements(by).size() > 0){
				if(driver.findElements(by).get(0).isDisplayed()){
					return true;
				}
			}
			
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
		}
		
		return false;
			
//		try{
//		WebDriverWait wait = new WebDriverWait(driver, 5000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//		return true;
//		} catch(Exception e){
//			return false;
//		}
	}
	
	public String getDropDownSelectedValue(WebDriver driver, By by){
		Select select = new Select(driver.findElement(by));
		return select.getFirstSelectedOption().getAttribute("value");
	}
	
	
	// elements present
	public boolean isElementPresent(WebDriver driver, By by){
		return driver.findElements(by).size() > 0;
	}
	
	public boolean isElementByXpathPresent(WebDriver driver, String xpath){
		return this.isElementPresent(driver, By.xpath(xpath));
	}
	
	public boolean isElementByIdPresent(WebDriver driver, String id){
		return this.isElementPresent(driver, By.id(id));
	}
	
	public boolean isElementByClassNamePresent(WebDriver driver, String className){
		return this.isElementPresent(driver, By.className(className));
	}
	
	public boolean isElementByCSSSelectorNamePresent(WebDriver driver, String selector){
		return this.isElementPresent(driver, By.cssSelector(selector));
	}
	
	// get elements text
	public String getElementsText(WebDriver driver, By by){
		return getElelment(driver, by).getText();
	}
	
	public String getElementsTextByXpath(WebDriver driver, String xpath){
		return getElelmentByXpath(driver, xpath).getText();
	}
	
	public String getElementsTextByID(WebDriver driver, String id){
		return getElelmentByID(driver, id).getText();
	}
	
	public String getElementsTextByClassName(WebDriver driver, String className){
		return getElelmentByClassName(driver, className).getText();
	}
	
	public String getElementsTextByCSSSelector(WebDriver driver, String selector){
		return getElelmentByCSSSelector(driver, selector).getText();
	}
	
	// checking elements text is correct
	public boolean isElementTextAsExpected(WebDriver driver, By by, String expectedText){
		return expectedText.equalsIgnoreCase(getElelment(driver, by).getText());
	}
	
	public boolean isElementTextAsExpectedByXpath(WebDriver driver, String xpath, String expectedText){
		return expectedText.equalsIgnoreCase(getElelmentByXpath(driver, xpath).getText());
	}
	
	public boolean isElementTextAsExpectedByID(WebDriver driver, String id, String expectedText){
		return expectedText.equalsIgnoreCase(getElelmentByID(driver, id).getText());
	}
	
	public boolean isElementTextAsExpectedByClassName(WebDriver driver, String className, String expectedText){
		return expectedText.equalsIgnoreCase(getElelmentByClassName(driver, className).getText());
	}
	
	public boolean isElementTextAsExpectedByCSSSelector(WebDriver driver, String selector, String expectedText){
		return expectedText.equalsIgnoreCase(getElelmentByCSSSelector(driver, selector).getText());
	}
	
	// finding/getting elements
	public WebElement getElelment(WebDriver driver, By by){
		return driver.findElement(by);
	}
	
	public WebElement getElelmentByXpath(WebDriver driver, String xpath){
		return getElelment(driver, By.xpath(xpath));
	}
	
	public WebElement getElelmentByLinkText(WebDriver driver, String linkText){
		return getElelment(driver, By.linkText(linkText));
	}
	
	public WebElement getElelmentByID(WebDriver driver, String id){
		return getElelment(driver, By.id(id));
	}
	
	public WebElement getElelmentByClassName(WebDriver driver, String className){
		return getElelment(driver, By.className(className));
	}
	
	public WebElement getElelmentByCSSSelector(WebDriver driver, String selector){
		return getElelment(driver, By.cssSelector(selector));
	}
	
	
	
	// inputing text
	public void enterTextToField(WebDriver driver, By by, String text){
		driver.findElement(by).sendKeys(text);
	}
	
	public void enterTextToFieldByXpath(WebDriver driver, String xpath, String text){
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}
	
	public void enterTextToFieldById(WebDriver driver, String id, String text){
		driver.findElement(By.id(id)).sendKeys(text);
	}
	
	public void enterTextToFieldByClassName(WebDriver driver, String className, String text){
		driver.findElement(By.className(className)).sendKeys(text);
	}
	
	public void enterTextToFieldByCSSSelectorName(WebDriver driver, String selector, String text){
		driver.findElement(By.cssSelector(selector)).sendKeys(text);
	}
	
	
	// invoking elements
	public void invokeElement(WebDriver driver, By by){
		driver.findElement(by).click();
	}
	
	public void invokeElementByXpath(WebDriver driver, String xpath){
		this.invokeElement(driver, By.xpath(xpath));
	}
	
	public void invokeElementById(WebDriver driver, String id){
		this.invokeElement(driver, By.id(id));
	}
	
	public void invokeElementByClassName(WebDriver driver, String className){
		this.invokeElement(driver, By.className(className));
	}
	
	public void invokeElementByCSSSelectorName(WebDriver driver, String selector){
		this.invokeElement(driver, By.cssSelector(selector));
	}
	
	public Map<String,Page> getPages(){
		Map<String,Page> pages = new HashMap<String, Page>();
		pages.put("home page", new HomePage_Common());
		// Add pages to Map here
		
		return pages;
		
	}
	
	public String getElementAttributeValueByXpath(WebDriver driver, String xpath, String attribute){
		return getElelmentByXpath(driver, xpath).getAttribute(attribute);
	}
	
	public String getElementAttributeValueByID(WebDriver driver, String id, String attribute){
		return getElelmentByID(driver, id).getAttribute(attribute);
	}
	
	public String getElementAttributeValueByClassName(WebDriver driver, String className, String attribute){
		return getElelmentByClassName(driver, className).getAttribute(attribute);
	}
	
	public String getElementAttributeValueByCSSSelector(WebDriver driver, String selector, String attribute){
		return getElelmentByCSSSelector(driver, selector).getAttribute(attribute);
	}


}
