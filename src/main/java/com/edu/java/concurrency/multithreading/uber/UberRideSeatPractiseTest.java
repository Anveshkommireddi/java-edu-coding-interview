package com.edu.java.concurrency.multithreading.uber;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;

public class UberRideSeatPractiseTest {

	public static void main(String[] args) throws InterruptedException {

		final UberRiderSeatProblem uberSeatingProblem = new UberRiderSeatProblem();
		Set<Thread> allThreads = new HashSet<Thread>();

		for (int i = 0; i < 10; i++) {

			Thread thread = new Thread(new Runnable() {
				public void run() {
					try {
						uberSeatingProblem.seatDemocrat();
					} catch (InterruptedException ie) {
						System.out.println("We have a problem");

					} catch (BrokenBarrierException bbe) {
						System.out.println("We have a problem");
					}

				}
			});
			thread.setName("Democrat_" + (i + 1));
			allThreads.add(thread);

			Thread.sleep(50);
		}

		for (int i = 0; i < 14; i++) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					try {
						uberSeatingProblem.seatRepublican();
					} catch (InterruptedException ie) {
						System.out.println("We have a problem");

					} catch (BrokenBarrierException bbe) {
						System.out.println("We have a problem");
					}
				}
			});
			thread.setName("Republican_" + (i + 1));
			allThreads.add(thread);
			Thread.sleep(20);
		}

		for (Thread t : allThreads) {
			t.start();
		}

		for (Thread t : allThreads) {
			t.join();
		}
	}

}
