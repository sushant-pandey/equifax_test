package org.mindtree.equifax.amazon.searchresult;

import org.mindtree.equifax.amazon.productdetail.ProductDetailPage;

public interface ProductListingPage {

	ProductDetailPage selectFirstSearchResult();
	
	String getPriceOfFirstSearchResult();
	
}
