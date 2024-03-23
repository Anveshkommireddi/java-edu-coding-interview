package com.edu.java.concurrency.multithreading.uber;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;

public class UberRiderSeatProblemTest {

	public static void main(String[] args) throws InterruptedException {

		final UberRideSeatPractise uberSeatingProblem = new UberRideSeatPractise();
		Set<Thread> allThreads = new HashSet<>();

		for (int i = 0; i < 10; i++) {

			Thread thread = new Thread(() -> {
				try {
					uberSeatingProblem.seatDemocrat();
				} catch (InterruptedException ie) {
					System.out.println("We have a problem");

				} catch (BrokenBarrierException bbe) {
					System.out.println("We have a problem");
				}
			});
			thread.setName("Democrat_" + (i + 1));
			allThreads.add(thread);

			Thread.sleep(50);
		}

		for (int i = 0; i < 14; i++) {
			Thread thread = new Thread(() -> {
				try {
					uberSeatingProblem.seatRepublican();
				} catch (InterruptedException ie) {
					System.out.println("We have a problem");

				} catch (BrokenBarrierException bbe) {
					System.out.println("We have a problem");
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
