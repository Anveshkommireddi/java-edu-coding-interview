package com.edu.java.misc;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
	/**
	 * requestCountMap: A map that stores the number of requests made for each API key. 
	 * requestTimeMap: A map that stores the time stamp of the last request made for each API key. 
	 * maxRequestsMap: A map that stores the maximum number of requests allowed for each API key. 
	 * timeIntervalMap: A map that stores the time interval (in seconds) for each API key.
	 */
	private Map<String, Long> requestCountMap = new HashMap<>();
	private Map<String, Long> requestTimeMap = new HashMap<>();
	private Map<String, Integer> maxRequestsMap = new HashMap<>();
	private Map<String, Integer> timeIntervalMap = new HashMap<>();

	public synchronized boolean isAllowed(String apiKey) {
		long currentTime = System.currentTimeMillis();
		long requestCount = requestCountMap.getOrDefault(apiKey, 0L);
		long requestTime = requestTimeMap.getOrDefault(apiKey, currentTime);
		int maxRequests = maxRequestsMap.getOrDefault(apiKey, 100);
		int timeInterval = timeIntervalMap.getOrDefault(apiKey, 60);

		if (requestCount < maxRequests && currentTime - requestTime < timeInterval * 1000) {
			requestCountMap.put(apiKey, requestCount + 1);
			return true;
		}

		requestCountMap.put(apiKey, 1L);
		requestTimeMap.put(apiKey, currentTime);
		return false;
	}

	public synchronized boolean isAllowed(String apiKey, int maxRequests, int timeInterval) {
		long currentTime = System.currentTimeMillis();
		long requestCount = requestCountMap.getOrDefault(apiKey, 0L);
		long requestTime = requestTimeMap.getOrDefault(apiKey, currentTime);

		if (requestCount < maxRequests && currentTime - requestTime < timeInterval * 1000) {
			requestCountMap.put(apiKey, requestCount + 1);
			return true;
		}

		requestCountMap.put(apiKey, 1L);
		requestTimeMap.put(apiKey, currentTime);
		return false;
	}

	public synchronized void setMaxRequests(String apiKey, int maxRequests) {
		maxRequestsMap.put(apiKey, maxRequests);
	}

	public synchronized void setTimeInterval(String apiKey, int timeInterval) {
		timeIntervalMap.put(apiKey, timeInterval);
	}
}
