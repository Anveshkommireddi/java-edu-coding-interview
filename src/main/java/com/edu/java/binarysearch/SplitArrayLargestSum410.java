package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SplitArrayLargestSum410 {

	private static final Logger LOGGER = LoggerFactory.getLogger(SplitArrayLargestSum410.class);

	public static void main(String[] args) {
		int[] nums = {10, 20, 30, 40};
		int m = 2;
		int result = minOfMaxArraySumWithMSubArrays(nums, m);
		LOGGER.info("Minimum Max Window Sum with M {} subArrays is :: {}", m, result);
	}

	private static int minOfMaxArraySumWithMSubArrays(int[] nums, int targetNumOfSubArrays) {
		int minSum = Integer.MIN_VALUE;
		int maxSum = 0;
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			minSum = Math.max(minSum, nums[i]);
			maxSum += nums[i];
		}
		while (minSum <= maxSum) {
			int mid = minSum + (maxSum - minSum) / 2;
			if (isPossible(nums, mid, targetNumOfSubArrays)) {
				result = Math.min(result, mid);
				maxSum = mid - 1;
			} else {
				minSum = mid + 1;
			}
		}
		return result != Integer.MAX_VALUE ? result : -1;
	}

	private static boolean isPossible(int[] nums, int targetSum, int targetCount) {
		int numOfSubArrays = 1;
		int currSum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > targetSum)
				return false;
			currSum += nums[i];
			if (currSum > targetSum) {
				numOfSubArrays++;
				currSum = nums[i];
			}
		}
		return numOfSubArrays <= targetCount;
	}
}
