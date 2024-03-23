package com.edu.java.concurrency.multithreading.ordered.printing.numbers;

public class OrderedPrintingNumbersTest {

	public static void main(String[] args) {

		OrderedPrintingNumbers opn = new OrderedPrintingNumbers(10);

		Thread zeroThread = new Thread(() -> {
			try {
				opn.printZero();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Thread-0");
		Thread oddThread = new Thread(() -> {
			try {
				opn.printOddNum();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Thread-odd");
		Thread evenThread = new Thread(() -> {
			try {
				opn.printEvenNum();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Thread-even");

		zeroThread.start();
		oddThread.start();
		evenThread.start();
	}

}
