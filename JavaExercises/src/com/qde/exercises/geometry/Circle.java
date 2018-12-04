package com.qde.exercises.geometry;

public class Circle extends Ellipse implements Shape{
	
	
	public Circle() {
		super(0,0);
	}
	
	public Circle(double inputRadius) {
		super(inputRadius, inputRadius);
	}

	public double getRadius() {
		return getSemiMajor();
	}

	public void setRadius(double radius) {
		this.setSemiMajor(radius);
	}
	
	
	public double getArea() {
		return Math.PI * this.getRadius() * this.getRadius();
	}
	
	public double getPerimeter() {
		return 2 * Math.PI * this.getRadius();
	}
	
}
