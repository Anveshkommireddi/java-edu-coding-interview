package com.edu.java.concurrency.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.naming.TimeLimitExceededException;

public class ExecutorService1 {

	public static void main(String[] args) {

		int preferredThreadCount = Runtime.getRuntime().availableProcessors();
		ExecutorService executorService = Executors.newFixedThreadPool(preferredThreadCount);
		try {
			for (int i = 0; i < preferredThreadCount; i++) {
				executorService.execute(() -> {
					System.out.println("Thread name ::: " + Thread.currentThread().getName());
				});
			}
		} finally {
			executorService.shutdown();
		}

		List<Future<Integer>> futuresList = new ArrayList<>();
		ExecutorService futureExecutorService = Executors.newFixedThreadPool(preferredThreadCount);
		ExecutorService virtualThreadService = Executors.newVirtualThreadPerTaskExecutor();
		try {
			for (int i = 0; i < preferredThreadCount; i++) {
				Future<Integer> integerFuture = futureExecutorService.submit(new CallableTask<Integer>(i));
				futuresList.add(integerFuture);
			}
		} finally {
			futureExecutorService.shutdown();
		}
		for(Future<Integer> future : futuresList) {
			try {
				Integer value = future.get(1, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				try {
					Integer value = future.get();
				} catch (InterruptedException | ExecutionException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	static class CallableTask<V> implements Callable<V> {

		private V value;

		public CallableTask(V value) {
			this.value = value;
		}

		@Override
		public V call() throws Exception {
			return null;
		}

	}

}
