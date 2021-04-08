package org.mindtree.equifax.amazon.seleniumlibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	private WebDriver driver;
	
	public WaitUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitTillPresenceOfElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.withMessage("Element to be searched not present on page.")
			.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
