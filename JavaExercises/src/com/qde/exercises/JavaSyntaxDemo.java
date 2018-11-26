package com.qde.exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaSyntaxDemo {
	
	private String version = "DEMO_V00.01";
	
	public JavaSyntaxDemo() {
		
	}
	
	public JavaSyntaxDemo(String version) {
		this.version = version;
	}



	public String getVersion() {
		return this.version;
	}
	
	public static void main(String[] args){
		Customer customer1 = new Customer();
		customer1.setName("Smith");
		customer1.setAddress("3 baker street");

		Customer customer2 = new Customer("Higgins", "4 baker street");
		
		SavingsAccount account = new SavingsAccount();
		account.setBalance(500);
		account.setInterestRate(5);
		
		System.out.println("Balance after interest computation : " + account.computeInterest());
		
		System.out.println("Balance before withdrawal : " + account.getBalance());
		account.withdraw(50);
		System.out.println("Balance after withdrawal : " + account.getBalance());

    }
	

}
