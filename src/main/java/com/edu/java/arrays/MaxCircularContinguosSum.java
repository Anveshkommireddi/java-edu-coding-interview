package com.edu.java.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxCircularContinguosSum {

	private static final Logger LOGGER = LoggerFactory.getLogger(MaxCircularContinguosSum.class);

	public static void main(String... args) {
		int[] arr = { -5, -3, -5 };
		int result = maxCircularSum(arr);
		LOGGER.info("Max Circular Sum is {}", result);
	}

	private static int maxCircularSum(int[] arr) {

		int currMax = arr[0];
		int maxSum = arr[0];

		int currMin = arr[0];
		int minSum = arr[0];

		int totalSum = arr[0];

		for (int idx = 1; idx < arr.length; idx++) {
			currMax = Math.max(arr[idx], currMax + arr[idx]);
			maxSum = Math.max(currMax, maxSum);

			currMin = Math.min(arr[idx], currMin + arr[idx]);
			minSum = Math.min(minSum, currMin);

			totalSum += arr[idx];
		}
		return maxSum < 0 ? maxSum : Math.max(maxSum, totalSum - minSum);
	}

}
