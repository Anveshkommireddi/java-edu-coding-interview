package com.edu.java.completable.futures;

import java.util.concurrent.CompletableFuture;

public class Java8CompletetableFutures {

	public static void main(String[] args) {
		CompletableFuture cf = create()
				.thenApply(Java8CompletetableFutures::transform)
				.exceptionally(throwable -> handleException(throwable))
				.thenApply(data -> data + 1)
				.thenAccept(data -> System.out.println(data));
		/*
		 * System.out.println(cf); try { Thread.sleep(1000); } catch (Exception exp) { }
		 * System.out.println(cf);
		 */
	}

	private static Integer handleException(Throwable throwable) {
		System.out.println("Handling Exception .... " + throwable);
		return 100;
	}
	
	public static int transform(int number) {
		System.out.println("Transform Called .....");
		try {
			Thread.currentThread().sleep(1000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number * 10;
	}

	public static int transformExceptionally(int number) {
		System.out.println("Transform Called .....");
		if (Math.random() > 0.5) {
			System.out.println("Transform Failed .........");
			throw new RuntimeException("Something went wrong !!!!!!");
		}
		return number * 10;
	}

	private static CompletableFuture<Integer> create() {
		return CompletableFuture.supplyAsync(() -> compute());
	}

	private static int compute() {
		return 2;
	}

}
