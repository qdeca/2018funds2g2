package fr.epita.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import fr.epita.services.Configuration;

public class ConfigTest {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Configuration configuration = Configuration.getInstance(); // load properties file
		String username = configuration.getPropertyValue("jdbc.username"); // get the username value from the username key
		System.out.println(username);
		String password = configuration.getPropertyValue("jdbc.password");
		System.out.println(password);
	}

}
