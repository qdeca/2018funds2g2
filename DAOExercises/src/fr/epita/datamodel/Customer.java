package fr.epita.datamodel;

public class Customer {
	
	// CREATE TABLE CUSTOMER(ID INT PRIMARY KEY, NAME VARCHAR(255), AGE INT);
	
	private String name;
	private String address;
	
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
