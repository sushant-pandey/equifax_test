package org.mindtree.equifax.stepsdefinition;

import org.mindtree.equifax.amazon.data.TestContext;

import io.cucumber.java.After;

public class Hooks {
	
	private TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}
	
	/**
	 * Hook will quit the webdriver
	 */
	@After("@AmazonCheckout")
    public void afterScenario(){
		testContext.getDriverManager().quit();
    }
}
