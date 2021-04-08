package org.mindtree.equifax.drivermanager;

import org.mindtree.equifax.config.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
	private WebDriver driver;
	
	/**
	 * Create new webdriver
	 * Default Driver : chromedriver
	 * Current expected chrome version : 89
	 * @return webdriver instance
	 */
	public WebDriver getWebDriver() {
		String browser = "chrome";
		
		//Fetching browser value passed by user
		String commandLineBrowser = System.getProperty("browser");
		
		if(commandLineBrowser != null) {
			browser = commandLineBrowser;
		}
		
		//Verifying the OS version to get right WebDriver
		String os = System.getProperty("os.name").toLowerCase();
		
		if(browser.equalsIgnoreCase("chrome")) {
			String projectRootDir = System.getProperty("user.dir");
			String driverPath = "";
			if(os.contains("mac")) {
				driverPath = new ConfigFileReader().getProperty("driver.mac.path");
			} else {
				driverPath = new ConfigFileReader().getProperty("driver.windows.path");
			}
			
			System.setProperty("webdriver.chrome.driver", projectRootDir + driverPath);

			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			// to be implemented as per requirement
		}
		
		driver.manage().window().maximize();
		return driver;
	}
	
	/**
	 * Quit the WebDriver
	 */
	public void quit() {
		driver.quit();
	}
}
