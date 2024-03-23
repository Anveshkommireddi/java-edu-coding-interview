package com.edu.java.concurrency.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	static CountDownLatch latch = new CountDownLatch(2);

	static class Worker extends Thread {
		private String name;

		public Worker(String name) {
			this.name = name;
		}

		public void run() {
			System.out.println(name + " is performing the task.");
			try {
				// Simulate some work
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " completed the task.");
			latch.countDown(); // Worker completed its task, decrement the latch count
		}
	}

	public static void main(String[] args) {
		Worker worker1 = new Worker("Worker 1");
		Worker worker2 = new Worker("Worker 2");
		// Worker worker3 = new Worker("Worker 3");
		// Worker worker4 = new Worker("Worker 4");

		worker1.start();
		worker2.start();
		// worker3.start();
		// worker4.start();

		try {
			// Main thread waits until latch count becomes zero
			latch.await();
			System.out.println("All workers have completed their tasks. Main thread continues.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
