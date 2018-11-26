package com.qde.exercises.geometry;

public class Square extends Quadrilateral{
	private double side;

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}
	
	
	public double getArea() {
		return this.getSide() * this.getSide();
	}
	
	public double getPerimeter() {
		return this.getSide() *4;
	}
	
}
