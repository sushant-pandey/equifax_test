package org.mindtree.equifax.amazon.data;

import java.util.HashMap;
import java.util.Map;

import org.mindtree.equifax.drivermanager.DriverManager;

public class TestContext {
	public Map<String, Object> tempDataMap;
	private DriverManager driverManager;
	private PageObjectManager pageObjectManager;
	
	public TestContext(){
		tempDataMap = new HashMap<>();
//		driverManager = getDriverManager();
//		pageObjectManager =  new PageObjectManager(driverManager.getWebDriver());
	}
	
	public DriverManager getDriverManager() {
		return (driverManager == null) ? driverManager = new DriverManager() : driverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return (pageObjectManager == null) ? 
				pageObjectManager = new PageObjectManager(getDriverManager().getWebDriver()) : 
					pageObjectManager;
	}
	
	public void storeObjectInTestDataMap(String strKey, Object objectToStore) {
		tempDataMap.put(strKey, objectToStore);
	}
	
	public Object getStoredValue(String strKey) {
		return tempDataMap.get(strKey);
	}
}
