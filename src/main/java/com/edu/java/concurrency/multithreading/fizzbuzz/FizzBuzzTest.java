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
		}, "++Fizz++");
		Thread buzzThread = new Thread(() -> {
			try {
				fizzBuzz.printBuzz();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "++Buzz++");
		Thread fizzBuzzThread = new Thread(() -> {
			try {
				fizzBuzz.printFizzBuzz();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "++FizzBuzz++");
		Thread numThread = new Thread(() -> {
			try {
				fizzBuzz.printNum();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "++Number++");

		fizzThread.start();
		buzzThread.start();
		fizzBuzzThread.start();
		numThread.start();
	}

}
