package com.edu.java.concurrency.multithreading.foobar;

public class FooBarTest {

	public static void main(String[] args) {

		int target = 3;

		FooBar fooBar = new FooBar(target);
		Thread t1 = new Thread(() -> {
			try {
				fooBar.printFoo();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Thread-1");

		Thread t2 = new Thread(() -> {
			try {
				fooBar.printBar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Thread-2");

		t1.start();
		t2.start();
	}

}
