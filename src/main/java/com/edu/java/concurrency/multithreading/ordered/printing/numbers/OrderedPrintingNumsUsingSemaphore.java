package com.edu.java.concurrency.multithreading.ordered.printing.numbers;

import java.util.concurrent.Semaphore;

public class OrderedPrintingNumsUsingSemaphore {

	private int maxVal;
	private Semaphore zeroSemaphore;
	private Semaphore oddSemaphore;
	private Semaphore evenSemaphore;

	public OrderedPrintingNumsUsingSemaphore(int maxVal) {
		this.maxVal = maxVal;
		zeroSemaphore = new Semaphore(1);
		oddSemaphore = new Semaphore(0);
		evenSemaphore = new Semaphore(0);
	}

	public void printZero() throws InterruptedException {
		for (int i = 0; i < maxVal; i++) {
			zeroSemaphore.acquire();
			System.out.print(0 + " ");
			if (i % 2 == 0) {
				oddSemaphore.release();
			} else {
				evenSemaphore.release();
			}
		}
	}

	public void printOdd() throws InterruptedException {
		for (int i = 1; i < maxVal; i += 2) {
			oddSemaphore.acquire();
			System.out.print(i + " ");
			zeroSemaphore.release();
		}
	}

	public void printEven() throws InterruptedException {
		for (int i = 0; i < maxVal; i += 2) {
			evenSemaphore.acquire();
			System.out.print(i + " ");
			zeroSemaphore.release();
		}
	}

}
