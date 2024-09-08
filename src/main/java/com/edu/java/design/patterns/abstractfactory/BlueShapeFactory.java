package com.edu.java.design.patterns.abstractfactory;

public class BlueShapeFactory implements AbstractFactory {

	@Override
	public Shape createShape() {
		return new Square(); // Creating a blue square
	}

	@Override
	public Color createColor() {
		return new Blue(); // Using blue color
	}

}
