package org.mindtree.equifax.amazon.cart;

import org.mindtree.equifax.amazon.checkout.CheckoutPage;

public interface CartPage {
	String getTotalPrice();
	
	CheckoutPage clickProceedToCheckout();
}
