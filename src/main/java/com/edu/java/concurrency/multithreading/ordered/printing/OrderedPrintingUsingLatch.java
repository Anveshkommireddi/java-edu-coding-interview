package com.edu.java.concurrency.multithreading.ordered.printing;

import java.util.concurrent.CountDownLatch;

public class OrderedPrintingUsingLatch {

	private CountDownLatch firstCountDown;
	private CountDownLatch secondCountDown;

	public OrderedPrintingUsingLatch() {
		firstCountDown = new CountDownLatch(1);
		secondCountDown = new CountDownLatch(1);
	}

	public void printFirst() throws InterruptedException {
		System.out.println("first");
		firstCountDown.countDown();
	}

	public void printSecond() throws InterruptedException {
		firstCountDown.await();
		System.out.println("second");
		secondCountDown.countDown();
	}

	public void printThird() throws InterruptedException {
		firstCountDown.await();
		secondCountDown.await();
		System.out.println("third");
	}

}
