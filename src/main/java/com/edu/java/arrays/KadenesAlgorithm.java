package com.edu.java.arrays;

import java.util.Arrays;

public class KadenesAlgorithm {

	public static void main(String... args) {
		int[] arr1 = { 1, 7, -2, -5, 10, -1 };
		System.out.println("Array: " + Arrays.toString(arr1));
		System.out.println("Sum: " + findMaxSumSubArray(arr1));
	}

	private static int findMaxSumSubArray(int[] arr) {
		int maxSum = arr[0];
		int currSum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			currSum = Math.max(currSum + arr[i], arr[i]);
			maxSum = Math.max(maxSum, currSum);
		}
		return maxSum;
	}

}
