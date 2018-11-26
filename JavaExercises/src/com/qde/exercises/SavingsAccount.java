package com.qde.exercises;

public class SavingsAccount extends Account {
	private double interestRate;
	
	public double computeInterest() {
		double finalInterestRate;
		finalInterestRate =  this.balance * this.interestRate;
		return finalInterestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	
	public static double returntwo() {
		return 2;
	}
}
