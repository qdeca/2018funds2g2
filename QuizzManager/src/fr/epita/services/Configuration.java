package fr.epita.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	private Properties properties;
	
	public Configuration() throws FileNotFoundException, IOException {
		// TODO load database.properties file
		File file = new File("database.properties");
		properties.load(new FileInputStream(file));
	}
	
	
	public String getPropertyValue(String property) {
		return properties.getProperty(property);
	}
	
}
