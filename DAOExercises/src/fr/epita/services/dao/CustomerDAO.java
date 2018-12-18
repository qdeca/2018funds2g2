package fr.epita.services.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.epita.datamodel.Customer;

public class CustomerDAO {
	
	private static final String DB_PASSWORD = "";
	private static final String DB_USERNAME = "sa";
	private static final String DB_URL = "jdbc:h2:C:/Formation/db/h2DS";

	
	public void create(Customer customer) {
		Connection connection;
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			PreparedStatement statement = connection.prepareStatement("INSERT INTO CUSTOMER VALUES(?,?)");
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getAddress());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Customer read(String name) {
		
	}
}
