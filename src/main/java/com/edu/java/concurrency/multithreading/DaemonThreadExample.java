package com.edu.java.concurrency.multithreading;

import java.time.Duration;

public class DaemonThreadExample {

	public static void main(String[] args) {

		Thread thread = Thread.ofPlatform().unstarted(() -> {
			while(true) {
				System.out.println("Thread Running...");
				try {
					Thread.sleep(Duration.ofSeconds(1));
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					break;
				}
			}
		});

		thread.setDaemon(true);
		
		thread.start();

		try {
			Thread.sleep(Duration.ofSeconds(3));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("Main Thread Execution Completed");
	}

}
