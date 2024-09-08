package com.edu.java.sliding.window;

import java.util.Arrays;

public class CountTripletsWithSumLessThanK {

	public static void main(String[] args) {
		int sum = 12;
		int arr[] = { 5, 1, 3, 4, 7 };
		long result = countTriplets(arr, sum);
		System.out.println(result);
	}

	private static long countTriplets(int[] arr, int sum) {
		Arrays.sort(arr);
		long result = 0;
		for (int idx = 0; idx < arr.length - 2; idx++) {
			int currVal = arr[idx];
			int start = idx + 1;
			int end = arr.length - 1;
			while (start <= end) {
				int sVal = arr[start];
				int eVal = arr[end];
				if (sVal + eVal < sum - currVal) {
					result += end - start;
					start++;
				} else {
					end--;
				}
			}
		}
		return result;
	}
}
