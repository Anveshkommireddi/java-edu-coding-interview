package com.edu.java.design.patterns.singleton;

public class MultiThreadedSingleTon {

	private static MultiThreadedSingleTon multiThreadedSingleTon;

	private MultiThreadedSingleTon() {
	}

	public static synchronized MultiThreadedSingleTon getInstance() {
		if (null == multiThreadedSingleTon) {
			multiThreadedSingleTon = new MultiThreadedSingleTon();
		}
		return multiThreadedSingleTon;
	}

}
