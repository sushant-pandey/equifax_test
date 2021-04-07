package org.mindtree.equifax.amazon.home;

import org.mindtree.equifax.amazon.searchresult.ProductListingPage;

public interface HomePage {

	HomePageImpl navigateToHomePage();
	
	HomePageImpl enterSearchText(String searchText);
	
	ProductListingPage submitSearch();
}
