package com.edu.java.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubArrayProductLessThanK {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubArrayProductLessThanK.class);

	//count number of subarrays less than k
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int k = 10;
		int result = count(arr, k);
		LOGGER.info("Result is {}", result);
	}

	private static int count(int[] arr, int k) {
		int start = 0;
		int currProduct = 1;
		int res = 0;
		for (int end = 0; end < arr.length; end++) {
			currProduct *= arr[end];
			while (start <= end && currProduct >= k) {
				currProduct = currProduct / arr[start];
				start++;
			}
			if (currProduct < k) {
				res += end - start + 1;
			}
		}
		return res;
	}

}
