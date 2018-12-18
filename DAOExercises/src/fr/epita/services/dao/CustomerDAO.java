package fr.epita.services.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.datamodel.Customer;

public class CustomerDAO {
	
	private static final String DB_PASSWORD = "";
	private static final String DB_USERNAME = "sa";
	private static final String DB_URL = "jdbc:h2:C:/Formation/db/h2DS";

	
	public void create(Customer customer) {
		// create a customer in the H2 database of the DB_URL (with username and password)
		Connection connection;
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			PreparedStatement statement = connection.prepareStatement("INSERT INTO CUSTOMER VALUES(?,?)");
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getAddress());
			statement.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Customer> read(String name) {
		// return a list of customer of any given name
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			PreparedStatement statement = connection.prepareStatement("SELECT NAME, ADDRESS FROM CUSTOMER WHERE NAME = ?");
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			List<Customer> matchingCustomers = new ArrayList<Customer>();
			while(result.next()) {
				Customer matchingCustomer = new Customer();
				matchingCustomer.setName(result.getString("NAME"));
				matchingCustomer.setAddress(result.getString("ADDRESS"));
				matchingCustomers.add(matchingCustomer);
				
			}
			connection.close();
			return matchingCustomers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void update(String newAddress, String name) {
		// modify address of a given customer name with the new address
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			PreparedStatement statement = connection.prepareStatement("UPDATE CUSTOMER SET ADDRESS = ? WHERE NAME = ?");
			statement.setString(1, newAddress);
			statement.setString(2, name);
			statement.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	private void delete(Customer customer) {
		// delete customer from database
		
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			PreparedStatement statement = connection.prepareStatement("DELETE FROM CUSTOMER WHERE NAME = ?");
			statement.setString(1, customer.getName());
			statement.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
