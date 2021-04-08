package org.mindtree.equifax.stepsdefinition;

import org.junit.Assert;
import org.mindtree.equifax.amazon.cart.CartPage;
import org.mindtree.equifax.amazon.data.TestContext;

import io.cucumber.java.en.*;

public class CartPageSteps {
	private TestContext testContext;
	private CartPage cartPage;

	public CartPageSteps(TestContext context) {
		testContext = context;
		cartPage = testContext.getPageObjectManager().getCartPage();
	}
	
	@Then("Price on checkout page should match the search result page")
	public void price_on_checkout_page_should_match_the_search_result_page() {
		String beforeCheckoutPrice = cartPage.getTotalPrice();
		String priceOfFirstSearchedResult = (String) testContext
				.getStoredValue("priceOfFirstSearchedResult");
				
				Assert.assertEquals("Price on the Product List Page and Product Cart"
						+ " page does not match",priceOfFirstSearchedResult, beforeCheckoutPrice);
	}

	@Then("User clicks on proceed to checkout")
	public void user_clicks_on_proceed_to_checkout() {
		cartPage.clickProceedToCheckout();
	}
}
