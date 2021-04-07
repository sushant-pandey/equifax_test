Feature: Testing the amazon checkout

	@AmazonCheckout @UITest
  Scenario: Assert the prices for single item checkout
    Given User visits the amazon home page
    When User searches for the book "qa testing for beginners"
    And User selects the first item in the listed results
    Then Price on Add to cart page should match the search result page
    When User clicks on Add to Cart
    Then Price on checkout page should match the search result page
    And User clicks on proceed to checkout
