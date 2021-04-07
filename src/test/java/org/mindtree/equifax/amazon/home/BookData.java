package org.mindtree.equifax.amazon.home;

public class BookData {
	private String searchResultPagePrice;
	
	private String itemPagePrice;
	
	private String checkoutPageItemPrice;

	public String getSearchResultPagePrice() {
		return searchResultPagePrice;
	}

	public void setSearchResultPagePrice(String searchResultPagePrice) {
		this.searchResultPagePrice = searchResultPagePrice;
	}

	public String getItemPagePrice() {
		return itemPagePrice;
	}

	public void setItemPagePrice(String itemPagePrice) {
		this.itemPagePrice = itemPagePrice;
	}

	public String getCheckoutPageItemPrice() {
		return checkoutPageItemPrice;
	}

	public void setCheckoutPageItemPrice(String checkoutPageItemPrice) {
		this.checkoutPageItemPrice = checkoutPageItemPrice;
	}
}
