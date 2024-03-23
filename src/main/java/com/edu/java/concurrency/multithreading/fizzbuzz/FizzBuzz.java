package com.edu.java.concurrency.multithreading.fizzbuzz;

public class FizzBuzz {

	private int maxVal;

	private int currNum;

	public FizzBuzz(int maxVal) {
		this.maxVal = maxVal;
		this.currNum = 1;
	}

	public synchronized void printFizz() throws InterruptedException {
		while (currNum <= maxVal) {
			if (currNum % 3 == 0 && currNum % 5 != 0) {
				System.out.println("Fizz");
				currNum++;
				this.notifyAll();
			} else {
				this.wait();
			}
		}
	}

	public synchronized void printBuzz() throws InterruptedException {
		while (currNum <= maxVal) {
			if (currNum % 5 == 0 && currNum % 3 != 0) {
				System.out.println("Buzz");
				currNum++;
				this.notifyAll();
			} else {
				this.wait();
			}
		}
	}

	public synchronized void printFizzBuzz() throws InterruptedException {
		while (currNum <= maxVal) {
			if (currNum % 5 == 0 && currNum % 3 == 0) {
				System.out.println("FizzBuzz");
				currNum++;
				this.notifyAll();
			} else {
				this.wait();
			}
		}
	}

	public synchronized void printNum() throws InterruptedException {
		while (currNum <= maxVal) {
			if (currNum % 3 != 0 && currNum % 5 != 0) {
				System.out.println(currNum);
				currNum++;
				this.notifyAll();
			} else {
				this.wait();
			}
		}
	}

}
