package com.edu.java.concurrency.multithreading.fizzbuzz;

public class FizzBuzzTest {

	public static void main(String[] args) {

		int targetNum = 15;

		FizzBuzz fizzBuzz = new FizzBuzz(targetNum);

		Thread fizzThread = new Thread(() -> {
			try {
				fizzBuzz.printFizz();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread buzzThread = new Thread(() -> {
			try {
				fizzBuzz.printBuzz();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread fizzBuzzThread = new Thread(() -> {
			try {
				fizzBuzz.printFizzBuzz();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread numThread = new Thread(() -> {
			try {
				fizzBuzz.printNum();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		fizzThread.start();
		buzzThread.start();
		fizzBuzzThread.start();
		numThread.start();
	}

}
