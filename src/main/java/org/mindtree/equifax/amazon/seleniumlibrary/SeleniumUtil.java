package org.mindtree.equifax.amazon.seleniumlibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumUtil {
	private WebDriver driver;
	
	public SeleniumUtil(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * Generic method to click web element locator
	 * @param locator
	 */
	public void clickElementLocatedBy(By locator) {
		new WaitUtils(driver).waitTillPresenceOfElement(locator);
		driver.findElement(locator).click();
	}
	
	/**
	 * Enter the text into input box identified by locator
	 * @param text
	 * @param locator
	 */
	public void enterText(String text, By locator) {
		new WaitUtils(driver).waitTillPresenceOfElement(locator);
		driver.findElement(locator).sendKeys(text);
	}
	
	/**
	 * Read the text of the element identified by locator
	 * @param locator
	 * @return
	 */
	public String getElementText(By locator) {
		return driver.findElement(locator).getText();
	}
}
