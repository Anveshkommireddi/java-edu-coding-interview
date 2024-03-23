package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleElementInSortedArray {

	private static final Logger LOGGER = LoggerFactory.getLogger(SingleElementInSortedArray.class);

	public static void main(String[] args) {
		int[] nums = { 3, 3, 7, 7, 10, 11, 11 };
		int result = findSingle(nums);
		LOGGER.info("Result is {}", result);
	}

	private static int findSingle(int[] nums) {
		int low = 0;
		int high = nums.length -1;
		int result = 0;
		while(low <= high) {
			
		}
		return result;
	}

}
