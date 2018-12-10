package fr.epita.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import fr.epita.datamodel.Customer;
import fr.epita.services.dao.CustomerFileDAO;

public class TestDataAccessFromFile {

	public static void main(String[] args) throws IOException {
		// testWriteCustomer();

		// testReadCustomer();

		// read from the console then write the user inputs in the file
		boolean exit = false;
		Scanner scanner = new Scanner(System.in);
		CustomerFileDAO dao = new CustomerFileDAO();
		do {

			System.out.println("Please input Customer name");
			String name = scanner.nextLine();
			System.out.println("Please input Customer address");
			String address = scanner.nextLine();
			Customer customer = new Customer(name, address);
			dao.create(customer);
			System.out.println("Enter a City name to filter customers  :");
			String criterion = scanner.nextLine();
			System.out.println("Customer list is :");
			System.out.println(dao.search(criterion));
			System.out.println("Do you want to exit?");
			String answer = scanner.nextLine();
			exit = answer.equals("y");

		} while (!exit);

		scanner.close();

	}

	private static void testReadCustomer() throws FileNotFoundException {
		File file = new File("customer.db");

		Scanner scanner = new Scanner(file);
		Customer customer = readCustomer(scanner);
		System.out.println(customer);
	}

	private static Customer readCustomer(Scanner scanner) {
		Customer customer = new Customer();
		scanner.nextLine();

		String name = scanner.nextLine();
		String address = scanner.nextLine();
		customer.setName(name);
		customer.setAddress(address);
		scanner.nextLine();
		return customer;
	}

	private static void testWriteCustomer() throws IOException {
		File file = new File("customer.db");
		PrintWriter writer = new PrintWriter(new FileWriter(file, true));

		// writing a customer (second option)
		Customer customer = new Customer("Thomas", "Paris");
		writeCustomer(writer, customer);

		writer.close();
	}

	private static void writeCustomer(PrintWriter writer, Customer customer) {
		writer.println("--------------");
		writer.println(customer.getName());
		writer.println(customer.getAddress());
		writer.println("--------------");
		writer.flush();
	}

}
