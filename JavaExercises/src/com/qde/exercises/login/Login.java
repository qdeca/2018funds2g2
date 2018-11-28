package com.qde.exercises.login;

import java.util.ArrayList;
import java.util.Scanner;

import com.qde.exercises.Factorial;

public class Login {

	
	private static final String CORRECT_LOGIN = "admin";
	private static final String CORRECT_PASSWORD = "password";

	public static void main(String[] args) {
		//login();
		System.out.println(Factorial.factorialFirstWay(5));
		System.out.println(Factorial.factorialSecondWay(5));
		System.out.println(Factorial.factorialThirdWay(5));

	}

	private static void login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your login : ");
		String userLoginInput = scanner.nextLine();
		System.out.println("Please enter your password : ");
		String userPasswordInput = scanner.nextLine();
		if (CORRECT_LOGIN.equals(userLoginInput) 
			&& CORRECT_PASSWORD.equals(userPasswordInput)) {
			System.out.println("Congratulations, you are authenticated !");
			
			menuNavigation(scanner);
			
		} else {
			System.out.println("Authentication failed.");
		}
	}

	private static void menuNavigation(Scanner scanner) {
		System.out.println("Please choose one of the 3 following options : Create, Modify, Delete");
		String userMenuInput = scanner.nextLine();
		switch(userMenuInput) {
		case "Create" : 
			System.out.println("You've entered the Create menu");
			break;
		case "Modify" :
			System.out.println("You've entered the Modify menu");
			break;
		case "Delete" :
			System.out.println("You've entered the Delete menu");
			break;
		default :
			System.out.println("Incorrect input");
		}
	}
}
