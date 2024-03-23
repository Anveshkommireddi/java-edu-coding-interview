package com.edu.java.arrays;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongestSubArrayDivisibleByK {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongestSubArrayDivisibleByK.class);

	public static void main(String[] args) {
		int k = 8;
		int[] arr = { -9, 0, 0, 0, 9 };
		int result = longSubarrWthSumDivByK(arr, k);
		LOGGER.info("Result is {}", result);
	}

	private static int longSubarrWthSumDivByK(int[] arr, int k) {
		int result = Integer.MIN_VALUE;
		Map<Integer, Integer> remIdxMap = new HashMap<>();
		int currSum = 0;
		remIdxMap.put(0, -1);
		for (int idx = 0; idx < arr.length; idx++) {
			// currSum += ((arr[idx] % k) + k);
			currSum += arr[idx];
			int rem = ((currSum % k) + k) % k;
			if (remIdxMap.containsKey(rem)) {
				result = Math.max(result, idx - remIdxMap.get(rem));
			} else {
				remIdxMap.put(rem, idx);
			}
		}
		return result;
	}

}
