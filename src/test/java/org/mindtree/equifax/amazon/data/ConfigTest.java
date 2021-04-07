package org.mindtree.equifax.amazon.data;

import org.mindtree.equifax.config.ConfigFileReader;

public class ConfigTest {

	public static void main(String[] args) {
		ConfigFileReader configFileReader = new ConfigFileReader();
		System.out.println(configFileReader.getApplicationUrl());
		System.out.println(configFileReader.getProperty("driver.mac.path"));
		
		System.out.println(System.getProperty("os.name").toLowerCase());
	}

}
