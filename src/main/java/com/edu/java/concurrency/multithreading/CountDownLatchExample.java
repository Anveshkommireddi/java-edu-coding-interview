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
			System.out.println(name + " is performing the task with a latch count:: " + latch.getCount());
			long startTime = System.currentTimeMillis();
			if (latch.getCount() > 0) {
				try {
					// Simulate some work
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			int timeTaken = (int) ((System.currentTimeMillis() - startTime) / 1000);
			System.out.println(name + " completed the task in " + timeTaken + " seconds.");
			latch.countDown(); // Worker completed its task, decrement the latch count
		}
	}

	public static void main(String[] args) {
		Worker worker1 = new Worker("Worker 1");
		Worker worker2 = new Worker("Worker 2");
		Worker worker3 = new Worker("Worker 3");
		// Worker worker4 = new Worker("Worker 4");

		worker1.start();
		worker2.start();
		// worker4.start();

		try {
			// Main thread waits until latch count becomes zero
			latch.await();
			worker3.start();
			System.out.println("All workers have completed their tasks. Main thread continues.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
