package org.mindtree.equifax.stepsdefinition;

import org.mindtree.equifax.amazon.cart.CartPage;
import org.mindtree.equifax.amazon.data.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	TestContext testContext;
	CartPage cartPage;

	public Hooks(TestContext context) {
		testContext = context;
	}
	
	@Before
    public void beforeScenario(){
        
    }	
	
	/**
	 * Hook will quit the webdriver
	 */
	@After("@AmazonCheckout")
    public void afterScenario(){
		testContext.getDriverManager().quit();
    }
}
