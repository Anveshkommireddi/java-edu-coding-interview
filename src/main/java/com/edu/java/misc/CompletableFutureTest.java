package com.edu.java.misc;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

	public static void main(String[] args) {
		CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
			sleep(1000);
			String stringToPrint = "Educative";
			System.out.println("----\nsupplyAsync first future - " + stringToPrint);
			executionThread();
			return stringToPrint;
		});

		completableFuture1.thenAccept(res -> System.out.println("Future result - " + res));
		sleep(2000);
	}

	static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static void executionThread() {
		System.out.println("Thread execution - " + Thread.currentThread().getName());
	}

}
