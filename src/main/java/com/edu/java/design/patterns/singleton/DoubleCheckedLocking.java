package com.edu.java.design.patterns.singleton;

public class DoubleCheckedLocking {

	private static DoubleCheckedLocking multiThreadedBillPlugSingleTon;

	private DoubleCheckedLocking() {
	}

	public static DoubleCheckedLocking getInstance() {
		if (null == multiThreadedBillPlugSingleTon) {
			synchronized (DoubleCheckedLocking.class) {
				if (null == multiThreadedBillPlugSingleTon) {
					multiThreadedBillPlugSingleTon = new DoubleCheckedLocking();
				}
			}
		}
		return multiThreadedBillPlugSingleTon;
	}

}
