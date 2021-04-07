package org.mindtree.equifax.amazon.data;

import org.mindtree.equifax.amazon.cart.CartPage;
import org.mindtree.equifax.amazon.cart.CartPageImpl;
import org.mindtree.equifax.amazon.checkout.CheckoutPage;
import org.mindtree.equifax.amazon.checkout.CheckoutPageImpl;
import org.mindtree.equifax.amazon.home.HomePage;
import org.mindtree.equifax.amazon.home.HomePageImpl;
import org.mindtree.equifax.amazon.productdetail.ProductDetailPage;
import org.mindtree.equifax.amazon.productdetail.ProductDetailPageImpl;
import org.mindtree.equifax.amazon.searchresult.ProductListingPage;
import org.mindtree.equifax.amazon.searchresult.ProductListingPageImpl;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	private WebDriver driver;
	
	private ProductListingPage productListingPage;
	
	private ProductDetailPage productDetailPage;

	private CartPage cartPage;

	private HomePage homePage;

	private CheckoutPage checkoutPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePageImpl(driver) : homePage;
	}

	public ProductListingPage getProductListingPage() {
		return (productListingPage == null) ? productListingPage = new ProductListingPageImpl(driver) : productListingPage;
	}
	
	public ProductDetailPage getProductDetailPage() {
		return (productDetailPage == null) ? productDetailPage = new ProductDetailPageImpl(driver) : productDetailPage;
	}

	public CartPage getCartPage() {
		return (cartPage == null) ? cartPage = new CartPageImpl(driver) : cartPage;
	}

	public CheckoutPage getCheckoutPage() {
		return (checkoutPage == null) ? checkoutPage = new CheckoutPageImpl(driver) : checkoutPage;
	}
}
