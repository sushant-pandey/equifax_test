package org.mindtree.equifax.stepsdefinition;

import org.mindtree.equifax.amazon.data.PageObjectManager;
import org.mindtree.equifax.amazon.data.TestContext;
import org.mindtree.equifax.amazon.home.HomePage;
import org.mindtree.equifax.amazon.home.HomePageImpl;
import org.mindtree.equifax.drivermanager.DriverManager;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;

public class HomePageSteps {

	TestContext testContext;
	HomePage homePage;

	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("User visits the amazon home page")
	public void user_visits_the_amazon_home_page() {
		System.out.println("Inside this homepage flow" + testContext);
		homePage.navigateToHomePage();
	}

	@When("User searches for the book {string}")
	public void user_searches_for_the_book(String string) {
		homePage.enterSearchText("qa testing for beginners").submitSearch();
	}
}
