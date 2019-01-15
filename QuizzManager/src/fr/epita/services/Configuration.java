package fr.epita.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration { // singleton class

	private Properties properties; // loaded with constructor 
	
	public static Configuration configuration; // initialized the 
											 //first time you call getInstance
	
	private Configuration() throws FileNotFoundException, IOException {
		File file = new File("database.properties");
		properties = new Properties();
		properties.load(new FileInputStream(file));
	}
	
	public static Configuration getInstance() throws FileNotFoundException, IOException {
		if (configuration == null) { // if there is no instance created yet
			configuration = new Configuration(); // initialize configuration
		}
		return configuration;
	}
	
	public String getPropertyValue(String property) {
		return properties.getProperty(property);
	}
	
}
