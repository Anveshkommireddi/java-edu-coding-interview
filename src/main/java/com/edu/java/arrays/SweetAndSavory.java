package com.edu.java.arrays;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SweetAndSavory {

	private static final Logger LOGGER = LoggerFactory.getLogger(SweetAndSavory.class);

	public static void main(String[] args) {
		int[] dishes = { -3, -5, 1, 7 };
		int target = 0;
		int[] result = sweetAndSavory(dishes, target);
		LOGGER.info("Sweet Dish is {} and Savory Dish is {}", result[0], result[1]);
	}

	private static int[] sweetAndSavory(int[] dishes, int target) {
		int[] result = null;
		Arrays.sort(dishes);
		if (dishes.length == 0 || isSameSign(dishes, 0, dishes.length - 1))
			return new int[2];
		int start = 0;
		int end = dishes.length - 1;
		while (start < end) {
			if (isSameSign(dishes, start, end))
				break;
			int currSum = dishes[start] + dishes[end];
			if (currSum == target) {
				return new int[] { dishes[start], dishes[end] };
			} else if (currSum < target) {
				if (null == result) {
					result = new int[2];
					result[0] = dishes[start];
					result[1] = dishes[end];
				} else if (currSum >= result[1] + result[0]) {
					result[0] = dishes[start];
					result[1] = dishes[end];
				}
				start++;
			} else {
				end--;
			}
		}
		return null == result ? new int[2] : result;
	}

	private static boolean isSameSign(int[] arr, int idx1, int idx2) {
		return ((arr[idx1] > 0 && arr[idx2] > 0) || (arr[idx1] < 0 && arr[idx2] < 0));
	}

}
