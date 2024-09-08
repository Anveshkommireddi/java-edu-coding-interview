package com.edu.java.design.patterns.factory;

public class ShapeFactory {

	public static Shape createShape(ShapeType type) {

		switch (type) {
		case CIRCLE:
			return new Circle();
		case SQUARE:
			return new Square();
		case RECTANGLE:
			return new Rectangle();
		default:
			throw new IllegalArgumentException("Unsupported shape type: " + type);
		}
	}

}
