package com.edu.java.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxVowels {

	private static final Logger LOGGER = LoggerFactory.getLogger(MaxVowels.class);

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
		int k = 3;
		int result = longestOnes(nums, k);
		System.out.println(result);
	}

	public static int longestOnes(int[] nums, int k) {
		int start = 0;
		int result = Integer.MIN_VALUE;
		for (int end = 0; end < nums.length; end++) {
			if (nums[end] == 0) {
				k--;
			}
			while (start <= end && k < 0) {
				if (nums[start] == 0) {
					k++;
				}
				start++;
			}
			result = Math.max(result, end - start + 1);
		}
		return result;
	}
}
