package org.mindtree.equifax.stepsdefinition;

import org.mindtree.equifax.amazon.data.TestContext;
import org.mindtree.equifax.amazon.home.HomePage;

import io.cucumber.java.en.*;

public class HomePageSteps {

	private TestContext testContext;
	private HomePage homePage;

	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("User visits the amazon home page")
	public void user_visits_the_amazon_home_page() {
		homePage.navigateToHomePage();
	}

	@When("User searches for the book {string}")
	public void user_searches_for_the_book(String searchString) {
		homePage.enterSearchText(searchString).submitSearch();
	}
}
