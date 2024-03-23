package com.edu.java.design.patterns.prototype;

public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}

	@Override
	public Shape clone() {
		return new Circle();
	}

}
