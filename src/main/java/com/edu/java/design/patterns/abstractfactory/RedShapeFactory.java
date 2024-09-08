package com.edu.java.design.patterns.abstractfactory;

public class RedShapeFactory implements AbstractFactory {

	@Override
	public Shape createShape() {
		return new Circle(); // Creating a red circle
	}

	@Override
	public Color createColor() {
		return new Red(); // Using red color
	}

}
