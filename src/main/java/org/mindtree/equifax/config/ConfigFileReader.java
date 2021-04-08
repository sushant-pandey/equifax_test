package org.mindtree.equifax.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath= "src/test/resources/config/Configuration.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getProperty(String property) {
		String propertyValue = properties.getProperty(property);
		if(propertyValue!= null) return propertyValue;
		else throw new RuntimeException("Value for property "+property+" not specified in the Configuration.properties file.");
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("amazon.url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getBaseApiUrl() {
		String apiUrl = properties.getProperty("base.api.url");
		if(apiUrl != null) return apiUrl;
		else throw new RuntimeException("Api url not specified in the Configuration.properties file.");
	}
}
