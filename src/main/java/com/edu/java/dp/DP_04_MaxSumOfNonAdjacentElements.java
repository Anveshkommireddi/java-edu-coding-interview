package com.edu.java.dp;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_04_MaxSumOfNonAdjacentElements {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_04_MaxSumOfNonAdjacentElements.class);

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1, 3, 5, 8, 1, 9 };
		int[] mem = new int[nums.length];
		Arrays.fill(mem, -1);
		int res = maxSumOfNonAdjacentElements(nums, nums.length - 1, mem);
		LOGGER.info("Max Sum is:: {}", res);
	}

	private static int maxSumOfNonAdjacentElements(int[] nums, int currIdx, int[] mem) {
		if (currIdx < 0)
			return 0;
		if (currIdx == 0)
			return nums[currIdx];
		if (mem[currIdx] != -1)
			return mem[currIdx];
		int noPickMax = maxSumOfNonAdjacentElements(nums, currIdx - 1, mem) + 0;
		int pickMax = maxSumOfNonAdjacentElements(nums, currIdx - 2, mem) + nums[currIdx];
		return mem[currIdx] = Math.max(noPickMax, pickMax);
	}
	
	private static int maxSumOfNonAdj(int[] nums) {
		int[] result = new int[nums.length];
		result[0] = nums[0];
		for (int currIdx = 1; currIdx < result.length; currIdx++) {
			int noPickMax = result[currIdx - 1] + 0;
			int pickMax = nums[currIdx];
			pickMax += currIdx > 1 ? result[currIdx - 2] : 0;
			result[currIdx] = Math.max(noPickMax, pickMax);
		}
		return result[result.length - 1];
	}

}
