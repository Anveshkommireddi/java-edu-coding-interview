package com.edu.java.concurrency.multithreading;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

	ThreadLocal<LocalDateTime> localDateTimeThreadLocal = ThreadLocal.withInitial(() -> LocalDateTime.now());

	public void test1() {
		ExecutorService threadpool = Executors.newFixedThreadPool(5);
		try {
			for (int i = 0; i < 5; i++) {
				threadpool.execute(() -> {
					System.out.println("Thread print with name " + localDateTimeThreadLocal.get());
				});
			}
		} catch (Exception exp) {
			threadpool.shutdown();
		}
	}

}
