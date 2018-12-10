package fr.epita.services.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epita.datamodel.Customer;

public class CustomerFileDAO {
	
	private PrintWriter writer;
	private Scanner scanner;
	
	public CustomerFileDAO() throws IOException {
		File file = new File("customer.db");
		this.writer = new PrintWriter(new FileWriter(file, true));
		this.scanner = new Scanner(file);

	}
	
	public void create(Customer customer) {
		writer.println("--------------");
		writer.println(customer.getName());
		writer.println(customer.getAddress());
		writer.println("--------------");
		writer.flush();
	}
	public Customer read() {
		
			Customer customer = new Customer();
			scanner.nextLine();

			String name = scanner.nextLine();
			String address = scanner.nextLine();
			customer.setName(name);
			customer.setAddress(address);
			scanner.nextLine();
			return customer;
	

	}
	
	public List<Customer> search(String criterion) throws FileNotFoundException{
		List<Customer> customers = new ArrayList<Customer>();
		this.scanner = new Scanner(new File("customer.db"));
		while (this.scanner.hasNext()) {
			Customer currentCustomer = read();
			//display only customers whose adresses are like the filter
			if (currentCustomer.getAddress().equals(criterion)) {
				customers.add(currentCustomer);
			}
		}
		return customers;
	}
	
	
}
