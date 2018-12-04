package com.qde.exercises.geometry;

public class Ellipse {
	private double semiMajor;
	private double semiMinor;
	
	
	public Ellipse(double semiMajor, double semiMinor) {
		this.semiMajor = semiMajor;
		this.semiMinor = semiMinor;
	}


	public double getSemiMajor() {
		return semiMajor;
	}


	public void setSemiMajor(double semiMajor) {
		this.semiMajor = semiMajor;
	}


	public double getSemiMinor() {
		return semiMinor;
	}


	public void setSemiMinor(double semiMinor) {
		this.semiMinor = semiMinor;
	}

	
}
