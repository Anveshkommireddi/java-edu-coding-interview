package com.edu.zletter.test;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSum0 {

	public static void main(String[] args) {
		int[] arr = { 1, -1, 3, 2, -2, -3, 3 };
		int result = getLongestSubArray(arr);
		System.out.println(result);
	}

	private static int getLongestSubArray(int[] arr) {
		int result = Integer.MIN_VALUE;
		Map<Integer, Integer> prefixSumIdxInfo = new HashMap<>();
		prefixSumIdxInfo.put(0, -1);
		int prefixSum = 0;
		for (int idx = 0; idx < arr.length; idx++) {
			int currNum = arr[idx];
			prefixSum += currNum;
			int remVal = prefixSum - 0;
			if (prefixSumIdxInfo.containsKey(remVal)) {
				int length = idx - prefixSumIdxInfo.get(remVal);
				result = Math.max(length, result);
			} else {
				prefixSumIdxInfo.put(prefixSum, idx);
			}
		}
		return result;
	}
}
