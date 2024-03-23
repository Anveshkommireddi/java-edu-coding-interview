package com.edu.java.concurrency.multithreading.sequence.numbers.generator;

public class SequenceNumberGeneratorTest {

	private static final int TOTAL_NUMBER_IN_SEQUENCE = 10;
	private static final int TOTAL_NUMBER_OF_THREADS = 3;

	public static void main(String[] args) {

		NumbersGenerator numbersGenerator = new NumbersGenerator(TOTAL_NUMBER_OF_THREADS, TOTAL_NUMBER_IN_SEQUENCE);

		// Created three Threads
		Thread t1 = new Thread(new SequenceGeneratorTask(numbersGenerator, 1), "Thread-1");
		Thread t2 = new Thread(new SequenceGeneratorTask(numbersGenerator, 2), "Thread-2");
		Thread t3 = new Thread(new SequenceGeneratorTask(numbersGenerator, 0), "Thread-3");

		// Start all three threads
		t1.start();
		t2.start();
		t3.start();
	}

}
