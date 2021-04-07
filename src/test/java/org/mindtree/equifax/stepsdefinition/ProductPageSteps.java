package org.mindtree.equifax.stepsdefinition;

import org.mindtree.equifax.amazon.data.TestContext;
import org.mindtree.equifax.amazon.searchresult.ProductListingPage;

import io.cucumber.java.en.When;

public class ProductPageSteps {
	TestContext testContext;
	ProductListingPage productListingPage;

	public ProductPageSteps(TestContext context) {
		testContext = context;
		productListingPage = testContext.getPageObjectManager().getProductListingPage();
	}
	
	@When("User selects the first item in the listed results")
	public void user_selects_the_first_item_in_the_listed_results() {
		String priceOfFirstSearchedResult = 
				productListingPage.getPriceOfFirstSearchResult();
		testContext.storeObjectInTestDataMap("priceOfFirstSearchedResult", 
				priceOfFirstSearchedResult);
		productListingPage.selectFirstSearchResult();
	}
}
