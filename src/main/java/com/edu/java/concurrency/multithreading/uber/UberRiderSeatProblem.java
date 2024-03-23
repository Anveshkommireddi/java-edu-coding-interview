package com.edu.java.concurrency.multithreading.uber;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class UberRiderSeatProblem {

	private CyclicBarrier cyclicBarrier;

	private Semaphore democratsWaitingSemaphore;

	private Semaphore republicansWaitingSemaphore;

	private int republicans;

	private int democrats;

	private ReentrantLock lock = new ReentrantLock();

	public UberRiderSeatProblem() {
		cyclicBarrier = new CyclicBarrier(4);
		democratsWaitingSemaphore = new Semaphore(0);
		republicansWaitingSemaphore = new Semaphore(0);
		republicans = 0;
		democrats = 0;
	}

	public void seated() {
		System.out.println(Thread.currentThread().getName() + "  seated");
		System.out.flush();
	}

	public void drive() {
		System.out.println("Uber Ride on Its wayyyy... with ride leader " + Thread.currentThread().getName());
		System.out.flush();
	}

	public void seatDemocrat() throws InterruptedException, BrokenBarrierException {

		boolean rideLeader = false;

		lock.lock();

		democrats++;

		if (democrats == 4) {
			democratsWaitingSemaphore.release(3);
			rideLeader = true;
			democrats -= 4;
		} else if (republicans >= 2 && democrats == 2) {
			democratsWaitingSemaphore.release(1);
			republicansWaitingSemaphore.release(2);
			democrats -= 2;
			republicans -= 2;
			rideLeader = true;
		} else {
			lock.unlock();
			democratsWaitingSemaphore.acquire();
		}

		seated();
		cyclicBarrier.await();

		if (rideLeader) {
			drive();
			lock.unlock();
		}

	}

	public void seatRepublican() throws InterruptedException, BrokenBarrierException {

		boolean rideLeader = false;

		lock.lock();

		republicans++;

		if (republicans == 4) {
			republicansWaitingSemaphore.release(3);
			rideLeader = true;
			republicans -= 4;
		} else if (democrats >= 2 && republicans == 2) {
			republicansWaitingSemaphore.release(1);
			democratsWaitingSemaphore.release(2);
			democrats -= 2;
			republicans -= 2;
			rideLeader = true;
		} else {
			lock.unlock();
			republicansWaitingSemaphore.acquire();
		}

		seated();
		cyclicBarrier.await();

		if (rideLeader) {
			drive();
			lock.unlock();
		}

	}

}
