package com.edu.java.lld.ratelimiting;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TokenBucketRateLimiter {

	private final int maxTokens;
	private final int refillRate; // tokens per second
	private final Map<String, UserBucket> userBuckets;

	public TokenBucketRateLimiter(int maxTokens, int refillRate) {
		this.maxTokens = maxTokens;
		this.refillRate = refillRate;
		this.userBuckets = new ConcurrentHashMap<>();
		startRefilling();
	}

	private void startRefilling() {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(() -> {
			for (UserBucket bucket : userBuckets.values()) {
				bucket.refillTokens(refillRate);
			}
		}, 1, 1, TimeUnit.SECONDS);
	}

	public boolean allowRequest(String userId) {
		UserBucket bucket = userBuckets.computeIfAbsent(userId, id -> new UserBucket(maxTokens));
		return bucket.consumeToken();
	}

	private static class UserBucket {
		private int tokens;
		private final int maxTokens;

		public UserBucket(int maxTokens) {
			this.tokens = maxTokens;
			this.maxTokens = maxTokens;
		}

		public synchronized boolean consumeToken() {
			if (tokens > 0) {
				tokens--;
				return true;
			}
			return false;
		}

		public synchronized void refillTokens(int tokensToAdd) {
			tokens = Math.min(maxTokens, tokens + tokensToAdd);
		}
	}

	public static void main(String[] args) {
		TokenBucketRateLimiter rateLimiter = new TokenBucketRateLimiter(5, 2); // 5 max tokens, 2 tokens per second

		Runnable requestTask = () -> {
			String userId = "user1"; // Simulating requests from user1
			if (rateLimiter.allowRequest(userId)) {
				System.out.println("Request allowed for " + userId + " at " + System.currentTimeMillis() / 1000);
			} else {
				System.out.println("Request denied for " + userId + " at " + System.currentTimeMillis() / 1000);
			}
		};

		ScheduledExecutorService requestScheduler = Executors.newScheduledThreadPool(1);
		requestScheduler.scheduleAtFixedRate(requestTask, 0, 500, TimeUnit.MILLISECONDS); // Sending requests every 500ms
	}
}
