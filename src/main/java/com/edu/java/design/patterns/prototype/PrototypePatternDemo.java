package com.edu.java.design.patterns.prototype;

public class PrototypePatternDemo {

	public static void main(String[] args) {
		// Create prototype objects
		Shape circlePrototype = new Circle();
		Shape rectanglePrototype = new Rectangle();

		// Clone objects
		Shape clonedCircle = circlePrototype.clone();
		Shape clonedRectangle = rectanglePrototype.clone();

		// Draw cloned objects
		clonedCircle.draw();
		clonedRectangle.draw();
	}

}
