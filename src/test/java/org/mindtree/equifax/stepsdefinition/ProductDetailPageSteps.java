package org.mindtree.equifax.stepsdefinition;

import org.junit.Assert;
import org.mindtree.equifax.amazon.data.TestContext;
import org.mindtree.equifax.amazon.productdetail.ProductDetailPage;

import io.cucumber.java.en.*;

public class ProductDetailPageSteps {
	private TestContext testContext;
	private ProductDetailPage productDetailPage;

	public ProductDetailPageSteps(TestContext context) {
		testContext = context;
		productDetailPage = testContext.getPageObjectManager().getProductDetailPage();
	}
	
	@Then("Price on Add to cart page should match the search result page")
	public void price_on_add_to_cart_page_should_match_the_search_result_page() {
		String bookPagePrice = productDetailPage.getPrice();
		String priceOfFirstSearchedResult = (String) testContext
		.getStoredValue("priceOfFirstSearchedResult");
		
		Assert.assertEquals("Price on the Product List Page and Product details"
				+ " page does not match",priceOfFirstSearchedResult, bookPagePrice);
	}

	@When("User clicks on Add to Cart")
	public void user_clicks_on_add_to_cart() {
		productDetailPage.clickAddToCart();
	}
}
