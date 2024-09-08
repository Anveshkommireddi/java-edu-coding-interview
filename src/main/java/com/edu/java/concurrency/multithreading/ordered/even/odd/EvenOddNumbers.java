package com.edu.java.concurrency.multithreading.ordered.even.odd;

public class EvenOddNumbers {

	private int val;

	private int maxVal;

	public EvenOddNumbers(int maxVal) {
		this.maxVal = maxVal;
		this.val = 1;
	}

	public void printOddNumber() throws InterruptedException {
		for (int i = 1; i <= maxVal && val < maxVal; i++) {
			synchronized (this) {
				while (val % 2 == 0) {
					wait();
				}
				System.out.println("Odd Number Value " + val);
				val++;
				notifyAll();
			}
		}
	}

	public void printEvenNumber() throws InterruptedException {
		for (int i = 1; i <= maxVal && val < maxVal; i++) {
			synchronized (this) {
				while (val % 2 != 0) {
					wait();
				}
				System.out.println("Even Number Value " + val);
				val++;
				notifyAll();
			}
		}
	}

}
