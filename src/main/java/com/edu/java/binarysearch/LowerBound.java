package com.edu.java.binarysearch;

public class LowerBound {

	public static void main(String[] args) {
		int[] nums = { 3, 5, 8, 15, 19 };
		int target = 10;
		int resIdx = lowerBound(nums, target);
		System.out.println(nums[resIdx]);
	}

	private static int lowerBound(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return high > 0 ? low : nums.length;
	}

}
