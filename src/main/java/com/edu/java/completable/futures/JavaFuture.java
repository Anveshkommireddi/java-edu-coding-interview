package com.edu.java.completable.futures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaFuture {

	private static final Logger LOGGER = LoggerFactory.getLogger(JavaFuture.class);

	static ExecutorService executors = Executors.newFixedThreadPool(5);

	public static void main(String[] args) {
		Future<Integer> futureInteger = executors.submit(() -> {
			try {
				LOGGER.info("Thread started to sleep ......");
				Thread.sleep(5000l);
				LOGGER.info("Thread sleep completed ......");
			} catch (Exception exp) {
				LOGGER.error("Error is ", exp);
			}
			return 10;
		});

		Integer val = null;
		try {
			val = futureInteger.get(2l, TimeUnit.SECONDS);
		} catch (InterruptedException exp) {
			LOGGER.error("InterruptedException is ", exp);
			val = getFromFuture(futureInteger);
			LOGGER.error("InterruptedException Value is {}", val);
		} catch (ExecutionException exp) {
			LOGGER.error("ExecutionException is ", exp);
			val = getFromFuture(futureInteger);
			LOGGER.error("ExecutionException Value is {}", val);
		} catch (TimeoutException exp) {
			LOGGER.error("TimeoutException is ", exp);
			val = getFromFuture(futureInteger);
			LOGGER.error("TimeoutException Value is {}", val);
		}
	}

	private static Integer getFromFuture(Future<Integer> futureInteger) {
		try {
			return futureInteger.get();
		} catch (Exception e) {
		}
		return null;
	}

}
