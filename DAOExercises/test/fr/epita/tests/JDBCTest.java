package fr.epita.tests;

import java.util.List;

import fr.epita.datamodel.Customer;
import fr.epita.services.dao.CustomerDAO;

public class JDBCTest {

	private static final String DB_PASSWORD = "";
	private static final String DB_USERNAME = "sa";
	private static final String DB_URL = "jdbc:h2:C:/Formation/db/h2DS";

	public static void main(String[] args) {
		Customer customerJohn1 = new Customer();
		customerJohn1.setName("John");		// customer name
		customerJohn1.setAddress("2, avenue des champs Elysees");	// customer address

		Customer customerRichard = new Customer();
		customerRichard.setName("Richard");		// customer name
		customerRichard.setAddress("222, rue de la paix");	// customer address

		CustomerDAO dao = new CustomerDAO();
		//dao.create(customerJohn1);
		//dao.create(customerRichard);
		
		List<Customer> customers = dao.read("John");
		for (Customer customer : customers) {
			System.out.println(customer.getName());
			System.out.println(customer.getAddress());
		}
		
		
//		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){
//			// customer creation
//			   // set up connection with database using URL, username and password
//			PreparedStatement statement = connection.prepareStatement("INSERT INTO CUSTOMER VALUES(?,?)");	// create SQL instruction
//			statement.setString(1, customer.getName()); // fill parameter 1 (first ? in the previous line)
//			statement.setString(2, customer.getAddress()); // fill parameter 2 (second ? in the instruction)
//			statement.execute(); // execute instruction
//			
//			
//			//customer read by name
//			PreparedStatement statement2 = connection.prepareStatement("SELECT NAME, ADDRESS FROM CUSTOMER WHERE NAME = ? "); // write query but dont specify parameters yet
//			statement2.setString(1, customer.getName());  // add name parameter to query
//			ResultSet result = statement2.executeQuery(); // get query result (list of names and adresses)
//			while(result.next()) { // for each element of the list
//				System.out.println(result.getString("NAME"));  // get the name...
//				System.out.println(result.getString("ADDRESS")); // ...and the address
//			}
//			connection.close();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	
}
