package com.qde.exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.qde.exercises.geometry.Circle;

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
	
//	public static void main(String[] args){
////		Customer customer1 = new Customer();
////		customer1.setName("Smith");
////		customer1.setAddress("3 baker street");
////
////		Customer customer2 = new Customer("Higgins", "4 baker street");
////		
////		SavingsAccount account = new SavingsAccount();
////		account.setBalance(500);
////		account.setInterestRate(5);
////		Double balance = new Double(account.getBalance());
////		switch (balance.intValue()) {
////		case 200 :
////			System.out.println("You have 200 bucks");
////		case 500 :
////			System.out.println("You have 500 bucks");
////		}
////		
////		
////		System.out.println("Balance after interest computation : " + account.computeInterest());
////		
////		System.out.println("Balance before withdrawal : " + account.getBalance());
////		account.withdraw(50);
////		System.out.println("Balance after withdrawal : " + account.getBalance());
//
////		Circle bigCircle = new Circle();
////		bigCircle.setRadius(60); // the radius is set thanks to the setter
////		Circle smallCircle = new Circle(20); // the radius is set thanks to the constructor
////		System.out.println("The small circle radius is : " + smallCircle.getRadius());
////		System.out.println("The big circle radius is : " + bigCircle.getRadius());
////		System.out.println("Small circle area : " + smallCircle.getArea());
////		System.out.println("Small circle perimeter : " + smallCircle.getPerimeter());
////		System.out.println("Big circle area : " + bigCircle.getArea());
////		System.out.println("Big circle perimeter : " + bigCircle.getPerimeter());
//
//	
//	}
	

}
