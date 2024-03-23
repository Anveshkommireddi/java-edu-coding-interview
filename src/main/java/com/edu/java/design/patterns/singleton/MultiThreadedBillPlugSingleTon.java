package com.edu.java.design.patterns.singleton;

public class MultiThreadedBillPlugSingleTon {

	private static volatile MultiThreadedBillPlugSingleTon multiThreadedBillPlugSingleTon;

	private MultiThreadedBillPlugSingleTon() {
	}

	public static MultiThreadedBillPlugSingleTon getInstance() {
		if (null == multiThreadedBillPlugSingleTon) {
			synchronized (MultiThreadedBillPlugSingleTon.class) {
				if (null == multiThreadedBillPlugSingleTon) {
					multiThreadedBillPlugSingleTon = new MultiThreadedBillPlugSingleTon();
				}
			}
		}
		return multiThreadedBillPlugSingleTon;
	}

}
