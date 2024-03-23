package com.edu.java.binarysearch;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AggresiveCows {

	private static final Logger LOGGER = LoggerFactory.getLogger(AggresiveCows.class);

	public static void main(String[] args) {
		int[] stalls = { 0, 3, 4, 7, 10, 9 };
		int numOfCows = 4;
		int result = aggressiveCows(stalls, numOfCows);
		LOGGER.info("Result is {}", result);
	}

	private static int aggressiveCows(int[] stalls, int numOfCows) {
		Arrays.sort(stalls);
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int stall : stalls) {
			min = Math.min(min, stall);
			max = Math.max(max, stall);
		}
		int low = 1;
		int high = max - min;
		int result = Integer.MIN_VALUE;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (isPossible(stalls, numOfCows, mid)) {
				result = Math.max(result, mid);
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return result;
	}

	private static boolean isPossible(int[] stalls, int numOfCows, int currDistance) {
		int currCows = 1;
		int prev = stalls[0];
		for (int i = 1; i < stalls.length; i++) {
			int curr = stalls[i];
			if (curr - prev >= currDistance) {
				currCows++;
				prev = curr;
			}
		}
		return currCows >= numOfCows;
	}

}
