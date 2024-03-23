package com.edu.java.concurrency.multithreading.unisex.bathroom;

import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniSexBathRoomPractise {

	private Semaphore bathroom;

	private String inUseBy;

	private int empUsingBathRoom;

	private static final Logger LOGGER = LoggerFactory.getLogger(UniSexBathRoomPractise.class);

	public UniSexBathRoomPractise(int maxPeopleAllowed) {
		this.inUseBy = "NONE";
		this.bathroom = new Semaphore(maxPeopleAllowed);
		this.empUsingBathRoom = 0;
	}

	private void useBathRoom(String name) {
		LOGGER.info("{} started using bathroom. Number of employess using bathroom are {}", name, empUsingBathRoom);
		try {
			Thread.sleep(5000l);
		} catch (InterruptedException exp) {
			LOGGER.error("Exception while using bath room for the user {} ", name, exp);
		}
		LOGGER.info("{} completed using bathroom", name);
	}

	public void femaleUseBathRoom(String name) throws InterruptedException {

		synchronized (this) {
			while (inUseBy.equals("MALE")) {
				this.wait();
			}
			bathroom.acquire();
			empUsingBathRoom++;
			inUseBy = "FEMALE";
		}

		useBathRoom(name);
		bathroom.release();

		synchronized (this) {
			empUsingBathRoom--;
			if (empUsingBathRoom == 0) {
				inUseBy = "NONE";
			}
			this.notifyAll();
		}
	}

	public void maleUseBathRoom(String name) throws InterruptedException {

		synchronized (this) {
			while (inUseBy.equals("FEMALE")) {
				this.wait();
			}
			bathroom.acquire();
			empUsingBathRoom++;
			inUseBy = "MALE";
		}

		useBathRoom(name);
		bathroom.release();

		synchronized (this) {
			empUsingBathRoom--;
			if (empUsingBathRoom == 0) {
				inUseBy = "NONE";
			}
			this.notifyAll();
		}
	}

}
