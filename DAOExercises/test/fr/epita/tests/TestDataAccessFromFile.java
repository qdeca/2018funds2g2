package fr.epita.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import fr.epita.datamodel.Customer;

public class TestDataAccessFromFile {

	public static void main(String[] args) throws IOException {
		//testWriteCustomer();
		
		File file = new File("customer.db");
		
		Scanner scanner = new Scanner(file);
		Customer customer = readCustomer(scanner);
		System.out.println(customer);
		
		
	}

	private static Customer readCustomer(Scanner scanner) {
		Customer customer = new Customer();
		scanner.nextLine();
		
		String address = scanner.nextLine();
		String name =scanner.nextLine();
		customer.setName(name);
		customer.setAddress(address);
		scanner.nextLine();
		return customer;
	}

	private static void testWriteCustomer() throws IOException {
		File file = new File("customer.db");
		PrintWriter writer = new PrintWriter(new FileWriter(file, true));
				
		//writing a customer (second option)
		Customer customer = new Customer("Thomas", "Paris");
		writeCustomer(writer, customer);
		
		writer.close();
	}

	private static void writeCustomer(PrintWriter writer, Customer customer) {
		writer.println("--------------");
		writer.println(customer.getName());
		writer.println(customer.getAddress());
		writer.println("--------------");
	}

}
