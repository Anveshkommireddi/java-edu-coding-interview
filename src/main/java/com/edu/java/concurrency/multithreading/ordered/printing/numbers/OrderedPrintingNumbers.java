package com.edu.java.concurrency.multithreading.ordered.printing.numbers;

public class OrderedPrintingNumbers {

	int maxVal;

	boolean printZero;

	int currNum;

	public OrderedPrintingNumbers(int maxVal) {
		this.maxVal = maxVal;
		printZero = true;
		currNum = 0;
	}

	public synchronized void printZero() throws InterruptedException {
		for (int i = 0; i < maxVal; i++) {
			while (!printZero) {
				this.wait();
			}
			System.out.print(0 + " ");
			printZero = false;
			currNum++;
			this.notifyAll();

		}
	}

	public synchronized void printOddNum() throws InterruptedException {
		for (int i = 1; i < maxVal; i += 2) {
			while (printZero || currNum % 2 == 0) {
				this.wait();
			}
			System.out.print(currNum + " ");
			printZero = true;
			this.notifyAll();

		}
	}

	public synchronized void printEvenNum() throws InterruptedException {
		for (int i = 0; i < maxVal; i += 2) {
			while (printZero || currNum % 2 != 0) {
				this.wait();
			}
			System.out.print(currNum + " ");
			printZero = true;
			this.notifyAll();
		}
	}

}
