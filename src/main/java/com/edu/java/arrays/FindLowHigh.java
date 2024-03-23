package com.edu.java.arrays;

import java.util.Arrays;

public class FindLowHigh {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6 };
		System.out.println("Original List: " + Arrays.toString(nums) + "\n");

		int target = 5;
		int low = findLowIndex(nums, target);
		int high = findHighIndex(nums, target);
		System.out.println("Low Index of " + target + ": " + low);
		System.out.println("High Index of " + target + ": " + high);

		System.out.println();

		target = -2;
		low = findLowIndex(nums, target);
		high = findHighIndex(nums, target);
		System.out.println("Low Index of " + target + ": " + low);
		System.out.println("High Index of " + target + ": " + high);
	}

	private static int findHighIndex(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int num = nums[mid];
			if (num <= target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return end > 0 && nums[end] == target ? end : -1;
	}

	private static int findLowIndex(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int num = nums[mid];
			if (num >= target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start < nums.length && nums[start] == target ? start : -1;
	}

}
