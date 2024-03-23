package com.edu.java.concurrency.multithreading.barrier;

public class Barrier {

	private int currTasksCount;

	private int totalTasksToExecute;

	private int released;

	public Barrier(int totalTasksToExecute) {
		this.totalTasksToExecute = totalTasksToExecute;
		this.currTasksCount = 0;
		this.released = 0;
	}

	public synchronized void execute() throws InterruptedException {
		currTasksCount++;
		while (currTasksCount < totalTasksToExecute) {
			wait();
		}
		if (currTasksCount == totalTasksToExecute) {
			notifyAll();
			released++;
			if (released == totalTasksToExecute) {
				released = 0;
				currTasksCount = 0;
			}
			System.out.println(Thread.currentThread().getName() + " started execution. ");
			try {
				Thread.sleep(5000l);
			} catch (InterruptedException iexp) {
			}
			System.out.println(Thread.currentThread().getName() + " completed execution. ");
		}
	}

	// new method barrier
	public static void runTest() throws InterruptedException {
		final Barrier barrier = new Barrier(3);

		Thread p1 = new Thread(new Runnable() {
			public void run() {
				try {
					System.out.println("Thread 1");
					barrier.await();
					System.out.println("Thread 1");
					barrier.await();
					System.out.println("Thread 1");
					barrier.await();
				} catch (InterruptedException ie) {
				}
			}
		});

		Thread p2 = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(500);
					System.out.println("Thread 2");
					barrier.await();
					Thread.sleep(500);
					System.out.println("Thread 2");
					barrier.await();
					Thread.sleep(500);
					System.out.println("Thread 2");
					barrier.await();
				} catch (InterruptedException ie) {
				}
			}
		});

		Thread p3 = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(1500);
					System.out.println("Thread 3");
					barrier.await();
					Thread.sleep(1500);
					System.out.println("Thread 3");
					barrier.await();
					Thread.sleep(1500);
					System.out.println("Thread 3");
					barrier.await();
				} catch (InterruptedException ie) {
				}
			}
		});

		p1.setName("Thread 1");
		p2.setName("Thread 2");
		p3.setName("Thread 3");

		p1.start();
		p2.start();
		p3.start();

		p1.join();
		p2.join();
		p3.join();
	}

	public synchronized void await() throws InterruptedException {

		// to avoid spurios wake ups
		while (currTasksCount == totalTasksToExecute) {
			wait();
		}

		currTasksCount++;

		if (currTasksCount == totalTasksToExecute) {
			notifyAll();
			released = totalTasksToExecute;
		} else {

			while (currTasksCount < totalTasksToExecute)
				wait();
		}

		released--;
		if (released == 0) {
			currTasksCount = 0;
			// remember to wake up any threads waiting on line 107
			notifyAll();
		}
	}

}
