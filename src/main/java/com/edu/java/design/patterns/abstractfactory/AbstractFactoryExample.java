package com.edu.java.design.patterns.abstractfactory;

public class AbstractFactoryExample {

	public static void main(String[] args) {
		// Create a factory for red shapes
		AbstractFactory redFactory = new RedShapeFactory();
		// Create a red circle
		Shape redCircle = redFactory.createShape();
		// Draw the red circle
		redCircle.draw();
		// Fill the red circle with red color
		redFactory.createColor().fill();

		// Create a factory for blue shapes
		AbstractFactory blueFactory = new BlueShapeFactory();
		// Create a blue square
		Shape blueSquare = blueFactory.createShape();
		// Draw the blue square
		blueSquare.draw();
		// Fill the blue square with blue color
		blueFactory.createColor().fill();
	}

}
