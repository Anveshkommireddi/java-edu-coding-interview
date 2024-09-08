package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleElementInSortedArray {

	private static final Logger LOGGER = LoggerFactory.getLogger(SingleElementInSortedArray.class);

	public static void main(String[] args) {
		int[] nums = { 3, 3, 7, 7, 10, 10, 11 };
		int result = findSingle(nums);
		LOGGER.info("Result is {}", result);
	}

	private static int findSingle(int[] nums) {
		int lIdx = 0;
		int rIdx = nums.length - 1;
		int result = 0;
		while (lIdx <= rIdx) {
			int mIdx = lIdx + (rIdx - lIdx) / 2;
			if ((mIdx == 0 || nums[mIdx] != nums[mIdx - 1])
					&& (mIdx == nums.length - 1 || nums[mIdx] != nums[mIdx + 1])) {
				return nums[mIdx];
			} else if (mIdx % 2 == 0) {
				if (nums[mIdx] == nums[mIdx - 1]) {
					rIdx = mIdx - 2;
				} else {
					lIdx = mIdx + 2;
				}
			} else if (mIdx % 2 != 0) {
				if (nums[mIdx] == nums[mIdx - 1]) {
					lIdx = mIdx + 1;
				} else {
					rIdx = mIdx - 1;
				}
			}
		}
		return result;
	}

}
