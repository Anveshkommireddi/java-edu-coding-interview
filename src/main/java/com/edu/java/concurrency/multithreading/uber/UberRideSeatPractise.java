package com.edu.java.concurrency.multithreading.uber;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class UberRideSeatPractise {

	private int democrats;
	private int repulicans;
	private CyclicBarrier cyclicBarrier;
	private Semaphore waitingDemocrats;
	private Semaphore waitingRepublicans;
	private ReentrantLock lock;

	public UberRideSeatPractise() {
		this.democrats = 0;
		this.repulicans = 0;
		this.cyclicBarrier = new CyclicBarrier(4);
		this.waitingDemocrats = new Semaphore(0);
		this.waitingRepublicans = new Semaphore(0);
		this.lock = new ReentrantLock();
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
			rideLeader = true;
			waitingDemocrats.release(3);
			democrats -= 4;
		} else if (democrats == 2 && repulicans >= 2) {
			rideLeader = true;
			waitingDemocrats.release(2);
			waitingRepublicans.release(2);
			democrats -= 2;
			repulicans -= 2;
		} else {
			lock.unlock();
			waitingDemocrats.acquire();
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
		repulicans++;
		if (repulicans == 4) {
			rideLeader = true;
			waitingRepublicans.release(3);
			repulicans -= 4;
		} else if (repulicans == 2 && democrats >= 2) {
			rideLeader = true;
			waitingDemocrats.release(2);
			waitingRepublicans.release(2);
			democrats -= 2;
			repulicans -= 2;
		} else {
			lock.unlock();
			waitingRepublicans.acquire();
		}

		seated();
		cyclicBarrier.await();

		if (rideLeader) {
			drive();
			lock.unlock();
		}
	}

}
