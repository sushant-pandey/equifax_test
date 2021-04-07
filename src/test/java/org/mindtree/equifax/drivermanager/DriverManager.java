package org.mindtree.equifax.drivermanager;

import org.mindtree.equifax.config.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
	private WebDriver driver;
	
	public WebDriver getWebDriver() {
		String browser = "chrome";
		
		String commandLineBrowser = System.getProperty("browser");
		System.out.println("Command Line Browser = " + commandLineBrowser);
		String os = System.getProperty("os.name").toLowerCase();
		
		if(browser.equalsIgnoreCase("chrome")) {
			String projectRootDir = System.getProperty("user.dir");
			String driverPath = "";
			ConfigFileReader configFileReader = new ConfigFileReader();
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
	
	public void quit() {
		driver.quit();
	}
}
