package org.mindtree.equifax.amazon.productdetail;

import org.mindtree.equifax.amazon.cart.CartPage;

public interface ProductDetailPage {

	String getPrice();
	
	CartPage clickAddToCart();
	
}
