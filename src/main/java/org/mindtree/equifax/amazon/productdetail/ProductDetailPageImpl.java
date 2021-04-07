package org.mindtree.equifax.amazon.productdetail;

import org.mindtree.equifax.amazon.cart.CartPage;
import org.mindtree.equifax.amazon.cart.CartPageImpl;
import org.mindtree.equifax.amazon.seleniumlibrary.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPageImpl implements ProductDetailPage{
	
	private WebDriver driver;
	
	private By newBuyPriceLoc = By.id("newBuyBoxPrice");
	private By addToCardBtnLoc = By.id("add-to-cart-button");
	
	private SeleniumUtil seleniumUtil;
	
	public ProductDetailPageImpl(WebDriver driver) {
		this.driver = driver;
		seleniumUtil = new SeleniumUtil(driver);
	}
	
	/**
	 * Retrieve the price of the product from the product detail page
	 */
	public String getPrice() {
		return seleniumUtil.getElementText(newBuyPriceLoc);
	}
	
	/**
	 * Click on the add to cart button on the product detail page
	 */
	public CartPage clickAddToCart() {
		seleniumUtil.clickElementLocatedBy(addToCardBtnLoc);
		return new CartPageImpl(driver);
		
	}
}
