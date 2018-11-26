package com.qde.exercises.geometry;

public class Triangle {
	private double height;
	private double base;
	private double sideA;
	private double sideB;
	
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getSideA() {
		return sideA;
	}
	public void setSideA(double sideA) {
		this.sideA = sideA;
	}
	public double getSideB() {
		return sideB;
	}
	public void setSideB(double sideB) {
		this.sideB = sideB;
	}
	
	
	public double getArea() {
		return this.getBase() * this.getHeight() / 2;
	}
	
	public double getPerimeter() {
		return this.getBase() + this.getSideA() + this.getSideB();
	}
	
}
