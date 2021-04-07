package org.mindtree.equifax.amazon.checkout;

import org.openqa.selenium.WebDriver;

public class CheckoutPageImpl implements CheckoutPage{

	private WebDriver driver;
	
	public CheckoutPageImpl(WebDriver driver) {
		this.driver = driver;
	}
	
	@Override
	public String getPrice() {
		return null;
	}

}
