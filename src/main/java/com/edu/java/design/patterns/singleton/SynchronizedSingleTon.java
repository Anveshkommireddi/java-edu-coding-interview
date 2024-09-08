package com.edu.java.design.patterns.singleton;

public class SynchronizedSingleTon {

	private static SynchronizedSingleTon multiThreadedSingleTon;

	private SynchronizedSingleTon() {
	}

	public static synchronized SynchronizedSingleTon getInstance() {
		if (null == multiThreadedSingleTon) {
			multiThreadedSingleTon = new SynchronizedSingleTon();
		}
		return multiThreadedSingleTon;
	}

}
