package com.edu.java.concurrency.multithreading;

public class WaitNotifyExample {

	public static void main(String[] args) {
		final Object lock = new Object();

		Thread thread1 = new Thread(() -> {
			synchronized (lock) {
				try {
					System.out.println("Thread 1 is waiting...");
					lock.wait();
					System.out.println("Thread 1 came after waiting...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread 1 is awake!");
			}
		});

		Thread thread2 = new Thread(() -> {
			synchronized (lock) {
				System.out.println("Thread 2 is doing some work.");
				lock.notify(); // Notify the waiting thread
				System.out.println("Thread 2 after notify...");
			}
		});

		thread1.start();
		thread2.start();
	}

}
