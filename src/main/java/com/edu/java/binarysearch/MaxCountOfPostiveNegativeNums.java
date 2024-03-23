package com.edu.java.binarysearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxCountOfPostiveNegativeNums {

	private static final Logger LOGGER = LoggerFactory.getLogger(MaxCountOfPostiveNegativeNums.class);

	public static void main(String[] args) {
		//int[] nums = { -2, -1, -1, 1, 2, 3 };
		// int[] nums = {-3,-2,-1,0,0,1,2};
		int[] nums = {-2,-1,-1,1,2,3};
		int result = maximumCount(nums);
		LOGGER.info("Result is {}", result);
	}

	private static int maximumCount(int[] nums) {
		if(nums[0] > 0 || nums[nums.length-1] < 0) return nums.length; 
        int ceil = ceil(nums, 0);
        System.out.println("positive "+ ceil);
        int floor = floor(nums, 0);
        System.out.println("negative "+ floor);
        int positiveNumsCount = nums.length - ceil;
        int negativeNumsCount = floor + 1;
        return Math.max(positiveNumsCount, negativeNumsCount);
	}

	private static int ceil(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	private static int floor(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] >= target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return high;
	}

}
