package com.edu.java.arrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Utility {

	public static int[] findProduct(int arr[]) {
		int[] result = new int[arr.length];
		// prepare left produces array
		int[] larr = new int[result.length];
		Arrays.fill(larr, 1);
		for (int idx = 1; idx < arr.length; idx++) {
			int prevIdx = idx - 1;
			larr[idx] = arr[prevIdx] * larr[prevIdx];
		}
		// prepare right produces array
		int[] rarr = new int[result.length];
		Arrays.fill(rarr, 1);
		for (int idx = arr.length - 2; idx >= 0; idx--) {
			int nextIdx = idx - 1;
			rarr[idx] = arr[nextIdx] * rarr[nextIdx];
		}
		for (int idx = 0; idx < arr.length; idx++) {
			result[idx] = larr[idx] * rarr[idx];
		}
		return result;
	}

	public static int findFirstUnique(int[] arr) {
		Map<Integer, Integer> numCountMap = new LinkedHashMap<>();
		for (int idx = 0; idx < arr.length; idx++) {
			numCountMap.put(arr[idx], numCountMap.getOrDefault(arr[idx], 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
			if (entry.getValue() == 1)
				return entry.getKey();
		}
		return -1;
	}

	public int findSecondMaximum(int[] arr) {
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for (int idx = 0; idx < arr.length; idx++) {
			if (arr[idx] > firstMax) {
				secondMax = firstMax;
				firstMax = arr[idx];
			} else if (arr[idx] > secondMax && arr[idx] != firstMax) {
				secondMax = arr[idx];
			}
		}
		return secondMax;
	}

}
