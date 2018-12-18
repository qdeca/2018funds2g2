package fr.epita.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.epita.datamodel.Customer;

public class JDBCTest {

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setName("Bob");		// customer name
		customer.setAddress("1, avenue des champs Elysees");	// customer address

		try {
			// customer creation
			Connection connection = DriverManager.getConnection("jdbc:h2:C:/Formation/db/h2DS", "sa", "");   // set up connection with database using URL, username and password
			PreparedStatement statement = connection.prepareStatement("INSERT INTO CUSTOMER VALUES(?,?)");	// create SQL instruction
			statement.setString(1, customer.getName()); // fill parameter 1 (first ? in the previous line)
			statement.setString(2, customer.getAddress()); // fill parameter 2 (second ? in the instruction)
			statement.execute(); // execute instruction
			
			
			//customer read by name
			PreparedStatement statement2 = connection.prepareStatement("SELECT NAME, ADDRESS FROM CUSTOMER WHERE NAME = ? ");
			statement2.setString(1, customer.getName());
			ResultSet result = statement2.executeQuery();
			while(result.next()) {
				System.out.println(result.getString("NAME"));
				System.out.println(result.getString("ADDRESS"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
