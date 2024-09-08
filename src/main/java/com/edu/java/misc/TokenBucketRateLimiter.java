package com.edu.java.misc;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class TokenBucketRateLimiter {

	private final int capacity; // Maximum number of tokens in the bucket
	private int tokens; // Current number of tokens in the bucket
	private Instant lastRefillTime; // Time when tokens were last refilled
	private final long refillInterval; // Interval between refills in milliseconds
	private final int refillAmount; // Number of tokens to refill per interval

	public TokenBucketRateLimiter(int capacity, int refillAmount, long refillInterval) {
		this.capacity = capacity;
		this.refillAmount = refillAmount;
		this.refillInterval = refillInterval;
		this.tokens = capacity;
		this.lastRefillTime = Instant.now();
	}

	public synchronized boolean allowRequest(int tokensRequired) {
		refillTokens();
		if (tokens >= tokensRequired) {
			tokens -= tokensRequired;
			return true; // Request allowed
		} else {
			return false; // Request denied due to insufficient tokens
		}
	}

	private synchronized void refillTokens() {
		Instant now = Instant.now();
		long timeSinceLastRefill = now.toEpochMilli() - lastRefillTime.toEpochMilli();
		long numRefills = timeSinceLastRefill / refillInterval;
		if (numRefills > 0) {
			// Limit the number of tokens added based on a maximum refill rate
			int tokensToAdd = (int) Math.min(numRefills * refillAmount, capacity - tokens);
			tokens += tokensToAdd;
			lastRefillTime = now;
		}
	}

	public static void main(String[] args) {
		// Example usage
		TokenBucketRateLimiter rateLimiter = new TokenBucketRateLimiter(10, 5, TimeUnit.SECONDS.toMillis(1));

		// Simulate requests
		for (int i = 0; i < 20; i++) {
			boolean allowed = rateLimiter.allowRequest(1);
			System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed" : "Denied"));
			try {
				Thread.sleep(500); // Simulate delay between requests
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
