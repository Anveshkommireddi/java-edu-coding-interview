package com.edu.java.concurrency.multithreading.ordered.printing;

public class OrderedPrintingTest {

	public static void main(String[] args) {

		OrderedPrinting orderedPrinting = new OrderedPrinting();
		OrderedPrintingUsingLatch orderPrintingLatch = new OrderedPrintingUsingLatch();

		Thread t1 = new Thread(() -> {
			try {
				//orderedPrinting.printFirst();
				orderPrintingLatch.printFirst();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Thread-1");

		Thread t2 = new Thread(() -> {
			try {
				//orderedPrinting.printSecond();
				orderPrintingLatch.printSecond();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Thread-2");

		Thread t3 = new Thread(() -> {
			try {
				//orderedPrinting.printThird();
				orderPrintingLatch.printThird();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Thread-3");

		t3.start();
		t1.start();
		t2.start();

	}

}
