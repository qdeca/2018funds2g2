package com.qde.exercises.geometry;

public class Circle implements Shape{
	
	private double radius;
	
	public Circle() {
		
	}
	
	public Circle(double inputRadius) {
		this.radius = inputRadius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
	public double getArea() {
		return Math.PI * this.getRadius() * this.getRadius();
	}
	
	public double getPerimeter() {
		return 2 * Math.PI * this.getRadius();
	}
	
}
