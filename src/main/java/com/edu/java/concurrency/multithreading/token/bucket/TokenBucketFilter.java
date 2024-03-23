package com.edu.java.concurrency.multithreading.token.bucket;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenBucketFilter {

	private int MAX_TOKENS;
	private long lastRequestTime = System.currentTimeMillis();
	long possibleTokens = 0;

	private static final Logger LOGGER = LoggerFactory.getLogger(TokenBucketFilter.class);

	public TokenBucketFilter(int maxTokens) {
		MAX_TOKENS = maxTokens;
	}

	synchronized void getToken() throws InterruptedException {

		possibleTokens += (System.currentTimeMillis() - lastRequestTime) / 1000;

		if (possibleTokens > MAX_TOKENS) {
			possibleTokens = MAX_TOKENS;
		}

		if (possibleTokens == 0) {
			Thread.sleep(1000);
		} else {
			possibleTokens--;
		}
		lastRequestTime = System.currentTimeMillis();

		System.out.println(
				"Granting " + Thread.currentThread().getName() + " token at " + (System.currentTimeMillis() / 1000));
	}

	public static void runTestMaxTokenIs1() throws InterruptedException {

		Set<Thread> allThreads = new HashSet<>();
		final TokenBucketFilter tokenBucketFilter = new TokenBucketFilter(1);

		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(() -> {
				try {
					tokenBucketFilter.getToken();
				} catch (InterruptedException ie) {
					LOGGER.error("Interrupted Exception is ", ie);
				}
			});
			thread.setName("Thread_" + (i + 1));
			allThreads.add(thread);
		}

		for (Thread t : allThreads) {
			t.start();
		}

		for (Thread t : allThreads) {
			t.join();
		}
	}

	public static void main(String... args) throws InterruptedException {
		TokenBucketFilter.runTestMaxTokenIs1();
	}

}
