package com.edu.java.hashing;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongestSubArrayWithSumK {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongestSubArrayWithSumK.class);

	public static void main(String[] args) {
		int[] arr = { 10, 2, -2, -20, 30 };
		int sum = 10;
		int result = longestSubArraysWithSumK(arr, sum);
		LOGGER.info("Result is {}", result);
	}

	private static int longestSubArraysWithSumK(int[] arr, int sum) {
		Map<Integer, Integer> prefixSumIdxMap = new HashMap<>();
		int prefixSum = 0;
		int result = 0;
		for (int idx = 0; idx < arr.length; idx++) {
			int currNum = arr[idx];
			prefixSum += currNum;
			int rem = prefixSum - sum;
			if (rem == 0) {
				result = Math.max(result, idx + 1);
			}
			if (prefixSumIdxMap.containsKey(rem)) {
				result = Math.max(result, idx - prefixSumIdxMap.get(rem));
			}
			if (!prefixSumIdxMap.containsKey(prefixSum)) {
				prefixSumIdxMap.put(prefixSum, idx);
			}
		}
		return result;
	}
}
