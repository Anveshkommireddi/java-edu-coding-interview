package com.edu.java.arrays;

import java.util.Arrays;

public class SearchRotated {

	public static void main(String[] args) {
		int[] targetList = { 3, 6, 3, 6 };
		int[][] numsList = { { 6, 7, 1, 2, 3, 4, 5 }, { 6, 7, 1, 2, 3, 4, 5 }, { 4, 5, 6, 1, 2, 3 },
				{ 4, 5, 6, 1, 2, 3 } };

		for (int i = 0; i < targetList.length; i++) {
			System.out.println((i + 1) + ". Rotated array: " + Arrays.toString(numsList[i]));
			System.out.println("   target " + targetList[i] + " found at index "
					+ binarySearchRotated(numsList[i], targetList[i]));
			System.out.println(
					"----------------------------------------------------------------------------------------------------\n");
		}
	}

	private static int binarySearchRotated(int[] nums, int target) {
		int peakIdx = findPeakIndex(nums);
		int res = binarySearch(nums, 0, peakIdx, target);
		if (res == -1) {
			return binarySearch(nums, peakIdx + 1, nums.length - 1, target);
		}
		return res;
	}

	private static int findPeakIndex(int[] nums) {
		int target = nums[0];
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if ((mid == 0 && nums[mid] > nums[mid + 1]) || (mid == nums.length - 1 && nums[mid] > nums[mid - 1])
					|| (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1])) {
				return mid;
			} else if (nums[mid] < target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	private static int binarySearch(int[] arr, int start, int end, int target) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] < target) {
				start = mid + 1;
			} else if (arr[mid] > target) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
