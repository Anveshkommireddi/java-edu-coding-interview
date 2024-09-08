package com.edu.java.design.patterns.factory;

public class FactoryPatternTest {

	public static void main(String[] args) {

		// Create different shapes using the factory method
		Shape circle = ShapeFactory.createShape(ShapeType.CIRCLE);
		Shape square = ShapeFactory.createShape(ShapeType.SQUARE);
		Shape rectangle = ShapeFactory.createShape(ShapeType.RECTANGLE);

		// Draw the shapes
		circle.draw();
		square.draw();
		rectangle.draw();
	}

}
