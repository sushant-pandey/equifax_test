package org.mindtree.equifax.amazon.searchresult;

import org.mindtree.equifax.amazon.productdetail.ProductDetailPage;
import org.mindtree.equifax.amazon.productdetail.ProductDetailPageImpl;
import org.mindtree.equifax.amazon.seleniumlibrary.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductListingPageImpl implements ProductListingPage{
	private WebDriver driver;
	private By firstSearchResultLoc = By.xpath("//div[@data-index='1']");
	private String priceOfFirstItem;
	
	public ProductListingPageImpl(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * Select the first result on the products list
	 */
	@Override
	public ProductDetailPage selectFirstSearchResult() {
		new WaitUtils(driver).waitTillPresenceOfElement(firstSearchResultLoc);
		WebElement firstSearchResult = driver.findElement(firstSearchResultLoc);
		firstSearchResult.findElement(By.xpath("descendant::a")).click();
		return new ProductDetailPageImpl(driver);
	}
	
	/**
	 * Retrieve the price of the first search result from the UI
	 */
	@Override
	public String getPriceOfFirstSearchResult() {
		priceOfFirstItem = driver.findElement(firstSearchResultLoc)
				.findElement(By.xpath("descendant::span[@class='a-price']"))
				.getText().replace('\n', '.');
		return priceOfFirstItem;
	}
	
	
	
	
}
