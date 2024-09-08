package com.edu.java.concurrency.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	public static void main(String[] args) {

		Semaphore semaphore = new Semaphore(0); // Initialized with 0 permits

		Thread thread1 = new Thread(() -> {
			try {
				System.out.println(Thread.currentThread().getName() + " is trying to acquire a permit.");
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName() + " acquired a permit.");
				Thread.sleep(1000); // Sleep for 1 second to ensure thread1 tries to acquire first
				semaphore.release();
				System.out.println(Thread.currentThread().getName() + " released a permit.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Thread-1");

		Thread thread2 = new Thread(() -> {
			try {
				Thread.sleep(1000); // Sleep for 1 second to ensure thread1 tries to acquire first
				semaphore.release(); // Release a permit after 1 second
				System.out.println(Thread.currentThread().getName() + " released a permit.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Thread-2");

		thread1.start();
		thread2.start();
	}
}
