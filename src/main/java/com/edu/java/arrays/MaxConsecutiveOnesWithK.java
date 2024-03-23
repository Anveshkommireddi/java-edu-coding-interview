package com.edu.java.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxConsecutiveOnesWithK {

	private static final Logger LOGGER = LoggerFactory.getLogger(MaxConsecutiveOnesWithK.class);

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 0, 1, 0 };
		int k = 3;
		int result = maxOnesWithKReplacements(arr, k);
		//int result = maxConsecOnes(arr, k);
		LOGGER.info("Result is {}", result);
	}

	private static int maxOnesWithKReplacements(int[] arr, int maxZeroCount) {
		int start = 0;
		int result = 0;
		int currZeroCount = 0;
		for (int end = 0; end < arr.length; end++) {
			if (arr[end] == 0) {
				currZeroCount++;
			}
			while (currZeroCount > maxZeroCount) {
				if (arr[start] == 0) {
					currZeroCount--;
				}
				start++;
			}
			result = Math.max(result, end - start + 1);
		}
		return result;
	}

	private static int maxConsecOnes(int[] arr, int maxZerosCount) {
		int result = 0;
		int cres = 0;
		int start = 0;
		for (int end = 0; end < arr.length && maxZerosCount >= 0; end++) {
			if (arr[end] == 0)
				maxZerosCount--;
			while (maxZerosCount < 0) {
				if (arr[start] == 0) {
					maxZerosCount++;
				}
				start++;
			}
			result = Math.max(result, end - start + 1);

		}
		return result;
	}

}
