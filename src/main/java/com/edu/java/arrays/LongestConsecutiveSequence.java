package com.edu.java.arrays;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongestConsecutiveSequence {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongestConsecutiveSequence.class);

	public static void main(String[] args) {
		int[] arr = { 3, 5, 1 };
		int result = lcs(arr);
		LOGGER.info("Longest Consecutive Sequence Length is {}", result);
	}

	private static int lcs(int[] arr) {
		int maxLength = 1;
		Set<Integer> nums = new HashSet<>();
		for (int num : arr) {
			nums.add(num);
		}

		for (int num : nums) {
			if (nums.contains(num - 1))
				continue;
			int currLength = 1;
			int currNum = num;
			while (nums.contains(currNum + 1)) {
				currLength++;
				maxLength = Math.max(maxLength, currLength);
				currNum = currNum + 1;
			}
		}
		return maxLength;
	}

}
