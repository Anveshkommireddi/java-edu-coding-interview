package com.edu.java.design.patterns.singleton;

public class MultiThreadedSimpleSingleTon {

	private static MultiThreadedSimpleSingleTon multiThreadedSimpleSingleTon = new MultiThreadedSimpleSingleTon();

	private MultiThreadedSimpleSingleTon() {
	}

	public MultiThreadedSimpleSingleTon getInstance() {
		return multiThreadedSimpleSingleTon;
	}

}
