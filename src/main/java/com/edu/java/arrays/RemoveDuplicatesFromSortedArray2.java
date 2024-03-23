package com.edu.java.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoveDuplicatesFromSortedArray2 {

	private static final Logger LOGGER = LoggerFactory.getLogger(RemoveDuplicatesFromSortedArray2.class);

	public static void main(String[] args) {
		int[] arr = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		int k = 2;
		int result = removeDuplicates(arr, k);
		LOGGER.info("Result is {}", result);
	}

	private static int removeDuplicates(int[] arr, int k) {
		if (arr.length < k + 1) return arr.length;
		int lp = k;
		for (int rp = k; rp < arr.length; rp++) {
			if (arr[rp] != arr[lp - k]) {
				arr[lp++] = arr[rp];
			}
		}
		return lp;
	}

}
