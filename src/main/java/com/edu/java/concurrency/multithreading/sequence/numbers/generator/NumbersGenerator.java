package com.edu.java.concurrency.multithreading.sequence.numbers.generator;

public class NumbersGenerator {

	int number = 1;
	int totalNumbers;
	int totalNumberOfThreads;

	public NumbersGenerator(int totalNumberOfThreads, int totalNumbers) {
		this.totalNumbers = totalNumbers;
		this.totalNumberOfThreads = totalNumberOfThreads;
	}

	public void printNumbers(int remainder) {
		synchronized (this) {
			while (number < totalNumbers - 1) {
				while (number % totalNumberOfThreads != remainder) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number++);
				notifyAll();
			}
		}
	}

}
