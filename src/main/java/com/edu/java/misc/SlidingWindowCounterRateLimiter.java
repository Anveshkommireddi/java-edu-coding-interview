package com.edu.java.misc;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowCounterRateLimiter {
    private final int maxRequests;  // Maximum requests allowed in the sliding window
    private final long windowSizeInMillis;  // Total sliding window size (e.g., 1 minute)
    private final int subWindowCount;  // Number of sub-windows (e.g., 5 sub-windows within the 1 minute window)
    private final long subWindowSizeInMillis;  // Size of each sub-window
    private final Map<Long, Integer> subWindowCounts;  // Map to store the request count per sub-window

    public SlidingWindowCounterRateLimiter(int maxRequests, long windowSizeInMillis, int subWindowCount) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
        this.subWindowCount = subWindowCount;
        this.subWindowSizeInMillis = windowSizeInMillis / subWindowCount;  // Size of each sub-window
        this.subWindowCounts = new HashMap<>();
    }

    private long getCurrentSubWindow() {
        return System.currentTimeMillis() / subWindowSizeInMillis;  // Get the current sub-window based on time
    }

    public synchronized boolean allowRequest() {
        long currentSubWindow = getCurrentSubWindow();

        // Remove old sub-windows that are out of the current sliding window
        subWindowCounts.keySet().removeIf(subWindow -> subWindow <= currentSubWindow - subWindowCount);

        // Calculate total requests in the current sliding window
        int totalRequests = subWindowCounts.values().stream().mapToInt(Integer::intValue).sum();

        // If total requests are less than the limit, allow the request
        if (totalRequests < maxRequests) {
            subWindowCounts.put(currentSubWindow, subWindowCounts.getOrDefault(currentSubWindow, 0) + 1);
            return true;
        }

        // Otherwise, reject the request
        return false;
    }
    
    public static void main(String[] args) throws InterruptedException {
    	SlidingWindowCounterRateLimiter rateLimiter = new SlidingWindowCounterRateLimiter(10, 60000, 6);  // 10 requests per 60 seconds, 6 sub-windows
        
        // Test case: Simulate 12 requests
        for (int i = 1; i <= 12; i++) {
            if (rateLimiter.allowRequest()) {
                System.out.println("Request " + i + ": Allowed");
            } else {
                System.out.println("Request " + i + ": Denied (Rate limit exceeded)");
            }
            Thread.sleep(5000);  // Wait for 5 seconds between requests
        }
    }
}

