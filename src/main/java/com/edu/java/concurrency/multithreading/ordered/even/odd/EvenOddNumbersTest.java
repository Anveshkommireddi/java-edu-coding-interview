package com.edu.java.concurrency.multithreading.ordered.even.odd;

public class EvenOddNumbersTest {

	public static void main(String[] args) {

		EvenOddNumbers evenOddNumbers = new EvenOddNumbers(10);

		Thread oddThread = new Thread(() -> {
			try {
				evenOddNumbers.printOddNumber();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "odd-thread");

		Thread evenThread = new Thread(() -> {
			try {
				evenOddNumbers.printEvenNumber();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "even-thread");

		oddThread.start();
		evenThread.start();
	}

}
