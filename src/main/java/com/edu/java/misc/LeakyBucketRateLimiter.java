package com.edu.java.misc;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class LeakyBucketRateLimiter {
	private final int capacity; // Maximum number of tokens the bucket can hold
	private int tokens; // Current number of tokens in the bucket
	private Instant lastLeakTime; // Time of the last token leak
	private final long leakInterval; // Interval between token leaks in milliseconds
	private final int leakAmount; // Number of tokens leaked per interval

	public LeakyBucketRateLimiter(int capacity, int leakAmount, long leakInterval) {
		this.capacity = capacity;
		this.leakAmount = leakAmount;
		this.leakInterval = leakInterval;
		this.tokens = capacity; // Start with a full bucket
		this.lastLeakTime = Instant.now();
	}

	public synchronized boolean allowRequest(int tokensRequired) {
		// Perform token leak
		leakTokens();

		// Check if there are enough tokens in the bucket
		if (tokens >= tokensRequired) {
			tokens -= tokensRequired; // Consume tokens
			return true; // Request allowed
		} else {
			return false; // Request denied due to insufficient tokens
		}
	}

	private synchronized void leakTokens() {
		// Calculate time elapsed since last token leak
		Instant now = Instant.now();
		long timeSinceLastLeak = now.toEpochMilli() - lastLeakTime.toEpochMilli();

		// Calculate number of leak intervals that have passed
		long numLeakIntervals = timeSinceLastLeak / leakInterval;

		System.out.println("leakInterval: " + leakInterval + " numLeakIntervals: " + numLeakIntervals
				+ " timeSinceLastLeak: " + timeSinceLastLeak);
		// Calculate number of tokens to be refilled since the last leak
		long tokensToAdd = numLeakIntervals * leakAmount;
		System.out.println("tokensToAdd: " + tokensToAdd);
		// Refill tokens, but ensure it doesn't exceed the capacity
		tokens = Math.min(tokens + (int) tokensToAdd, capacity);

		// Update the last leak time
		lastLeakTime = now;
	}

	public static void main(String[] args) {
		// Example usage
		LeakyBucketRateLimiter rateLimiter = new LeakyBucketRateLimiter(10, 1, TimeUnit.SECONDS.toMillis(1));

		// Simulate requests
		for (int i = 0; i < 20; i++) {
			boolean allowed = rateLimiter.allowRequest(1);
			System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed" : "Denied"));
			try {
				Thread.sleep(1100); // Simulate delay between requests
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
