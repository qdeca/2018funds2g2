package fr.epita.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.epita.datamodel.Customer;

public class JDBCTest {

	private static final String DB_PASSWORD = "";
	private static final String DB_USERNAME = "sa";
	private static final String DB_URL = "jdbc:h2:C:/Formation/db/h2DS";

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setName("Bob");		// customer name
		customer.setAddress("1, avenue des champs Elysees");	// customer address

		try {
			// customer creation
			Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);   // set up connection with database using URL, username and password
			PreparedStatement statement = connection.prepareStatement("INSERT INTO CUSTOMER VALUES(?,?)");	// create SQL instruction
			statement.setString(1, customer.getName()); // fill parameter 1 (first ? in the previous line)
			statement.setString(2, customer.getAddress()); // fill parameter 2 (second ? in the instruction)
			statement.execute(); // execute instruction
			
			
			//customer read by name
			PreparedStatement statement2 = connection.prepareStatement("SELECT NAME, ADDRESS FROM CUSTOMER WHERE NAME = ? "); // write query but dont specify parameters yet
			statement2.setString(1, customer.getName());  // add name parameter to query
			ResultSet result = statement2.executeQuery(); // get query result (list of names and adresses)
			while(result.next()) { // for each element of the list
				System.out.println(result.getString("NAME"));  // get the name...
				System.out.println(result.getString("ADDRESS")); // ...and the address
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
