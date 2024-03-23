package com.edu.java.design.patterns.prototype;

public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}

	@Override
	public Shape clone() {
		return new Rectangle();
	}

}
