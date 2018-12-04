package com.qde.exercises.login;

import java.util.Scanner;

public class Login {

	private static final String CORRECT_LOGIN = "admin";
	private static final String CORRECT_PASSWORD = "password";

	public static void main(String[] args) {
		login();
//		System.out.println(Factorial.factorialFirstWay(5));
//		System.out.println(Factorial.factorialSecondWay(5));
//		System.out.println(Factorial.factorialThirdWay(5));

	}

	private static void login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your login : ");
		String userLoginInput = scanner.nextLine();
		System.out.println("Please enter your password : ");
		String userPasswordInput = scanner.nextLine();
		if (CORRECT_LOGIN.equals(userLoginInput) && CORRECT_PASSWORD.equals(userPasswordInput)) {

			System.out.println("Congratulations, you are authenticated !");

			menuNavigation(scanner);

		} else {
			System.out.println("Authentication failed.");
		}
	}

	private static void menuNavigation(Scanner scanner) {
		boolean exit = false;
		do {
			System.out.println("Please choose one of the 3 following options : \n 1.Create, \n 2.Modify, \n 3.Delete, \n 4.Exit");
			String userMenuInput = scanner.nextLine();
			switch (userMenuInput) {
			case "1":
				System.out.println("You've entered the Create menu");
				break;
			case "2":
				System.out.println("You've entered the Modify menu");
				break;
			case "3":
				System.out.println("You've entered the Delete menu");
				break;
				
			case "4":
				System.out.println("You've selected to exit the application");
				exit = true;
				break;
			default:
				System.out.println("Incorrect input");
			}
		} while (!exit);
	}
}
