package org.mindtree.equifax.amazon.cart;

import org.mindtree.equifax.amazon.checkout.CheckoutPage;
import org.mindtree.equifax.amazon.checkout.CheckoutPageImpl;
import org.mindtree.equifax.amazon.seleniumlibrary.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPageImpl implements CartPage{
	private WebDriver driver;
	
	private By totalPriceLoc = By.xpath("//span[@class='a-color-price hlb-price a-inline-block a-text-bold']");
	private By proceedToCheckoutBtnLoc = By.id("hlb-ptc-btn-native");
	
	private SeleniumUtil seleniumUtil;
	public CartPageImpl(WebDriver driver){
		this.driver = driver;
		seleniumUtil = new SeleniumUtil(driver);
	}
	
	/**
	 * Get the price of the element from the Add to Cart Page
	 */
	@Override
	public String getTotalPrice() {
		return seleniumUtil.getElementText(totalPriceLoc);
	}

	/**
	 * Click the proceed to check out button on the Cart Page
	 */
	@Override
	public CheckoutPage clickProceedToCheckout() {
		seleniumUtil.clickElementLocatedBy(proceedToCheckoutBtnLoc);
		return new CheckoutPageImpl(driver);
	}

}
