package com.edu.java.design.patterns.factory;

import java.util.Arrays;

public enum ShapeType {

	CIRCLE("Circle"),

	SQUARE("Square"),

	RECTANGLE("Rectangle");

	private final String displayName;

	ShapeType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public ShapeType getShapeByDisplayName(String displayName) {
		return Arrays.stream(ShapeType.values()).filter(shape -> shape.getDisplayName().equals(displayName)).findFirst()
				.orElseThrow(() -> new RuntimeException("No Shape present fo the displayName " + displayName));
	}

}
