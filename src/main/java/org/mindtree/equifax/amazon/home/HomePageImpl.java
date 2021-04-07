package org.mindtree.equifax.amazon.home;

import org.mindtree.equifax.amazon.searchresult.ProductListingPage;
import org.mindtree.equifax.amazon.searchresult.ProductListingPageImpl;
import org.mindtree.equifax.amazon.seleniumlibrary.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageImpl implements HomePage{
	
	private String amazonHomePageUrl = "https://www.amazon.com/";
	
	private WebDriver driver;
	private By searchBox = By.id("twotabsearchtextbox");
	private By searchButton = By.id("nav-search-submit-button");
	private SeleniumUtil seleniumUtil;
	
	public HomePageImpl(WebDriver driver) {
		this.driver = driver;
		seleniumUtil = new SeleniumUtil(driver);
	}
	
	/**
	 *  Navigate to the home page url
	 */
	public HomePageImpl navigateToHomePage() {
		driver.get(amazonHomePageUrl);
		return this;
	}

	/**
	 * Enter the text in the search box
	 */
	public HomePageImpl enterSearchText(String searchText) {
		seleniumUtil.enterText(searchText, searchBox);
		return this;
	}
	
	/**
	 * Click on the search button
	 */
	public ProductListingPage submitSearch() {
		seleniumUtil.clickElementLocatedBy(searchButton);
		return new ProductListingPageImpl(driver);
	}
}
