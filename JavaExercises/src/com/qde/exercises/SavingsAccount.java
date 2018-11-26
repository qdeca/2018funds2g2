package com.qde.exercises;

public class SavingsAccount extends Account {
	private double interestRate;
	
	public double computeInterest() {
		double finalInterestRate;
		finalInterestRate =  this.balance * this.interestRate;
		return finalInterestRate;
	}
}
