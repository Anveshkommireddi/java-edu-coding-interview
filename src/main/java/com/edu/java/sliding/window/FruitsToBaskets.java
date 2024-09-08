package com.edu.java.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class FruitsToBaskets {

	public static void main(String[] args) {
		int[] arr = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
		int k = 2;
		int result = maxFruits(arr, k);
		System.out.println(result);
	}

	private static int maxFruits(int[] arr, int k) {
		Map<Integer, Integer> numFreqInfo = new HashMap<>();
		int start = 0;
		int result = Integer.MIN_VALUE;
		for (int end = 0; end < arr.length; end++) {
			numFreqInfo.put(arr[end], numFreqInfo.getOrDefault(arr[end], 0) + 1);
			while (numFreqInfo.size() > k) {
				int se = arr[start];
				if (numFreqInfo.get(se) == 1) {
					numFreqInfo.remove(se);
				} else {
					numFreqInfo.put(se, numFreqInfo.getOrDefault(se, 0) - 1);
				}
				start++;
			}
			result = Math.max(result, end - start + 1);
		}
		return result;
	}

}
