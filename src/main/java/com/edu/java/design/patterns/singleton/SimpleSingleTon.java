package com.edu.java.design.patterns.singleton;

public class SimpleSingleTon {

	private static SimpleSingleTon simpleSingleTon;

	private SimpleSingleTon() {
	}

	public static SimpleSingleTon getInstance() {
		if (null == simpleSingleTon) {
			simpleSingleTon = new SimpleSingleTon();
		}
		return simpleSingleTon;
	}

}
