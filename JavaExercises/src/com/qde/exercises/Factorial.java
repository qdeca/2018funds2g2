package com.qde.exercises;

public class Factorial {

	public static int factorialFirstWay(int number) {
		int result = 1;
		while (number > 1) {
			result = number * result;
			number--;
		}
		return result;
	}
	public static int factorialSecondWay(int number) {
		int result = 1;
		do {
			result = number * result;
			number--;
		} while (number > 1);
		return result;
	}
	public static int factorialThirdWay(int number) {
		int result = 1;
		for (int i=1; i<=number; i++) {
			result = result * i;
		}
		return result;
	}
	
	
	
//	public static int factorialHiddenWay(int number) {
//		//TODO ????
//	}
}
