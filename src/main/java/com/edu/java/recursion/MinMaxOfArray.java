package com.edu.java.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinMaxOfArray {

	private static final Logger LOGGER = LoggerFactory.getLogger(MinMaxOfArray.class);

	public static void main(String[] args) {
		int[] arr = { 4, 2, 3, 5, 1, 7, 6 };
		int maxNum = findMax(arr, arr.length - 1);
		LOGGER.info("Maximum of the Array is {}", maxNum);
		int minimum = findMin(arr, arr.length - 1);
		LOGGER.info("Minimum of the Array is {}", minimum);

	}

	private static int findMax(int[] arr, int idx) {
		if (idx < 0)
			return Integer.MIN_VALUE;
		return Math.max(arr[idx], findMax(arr, idx - 1));
	}

	private static int findMin(int[] arr, int idx) {
		if (idx < 0)
			return Integer.MAX_VALUE;
		return Math.min(arr[idx], findMin(arr, idx - 1));
	}

}
