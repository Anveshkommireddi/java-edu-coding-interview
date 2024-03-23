package com.edu.java.arrays;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[][] numsLists = { {}, { 0, 1 }, { 1, 2, 3 }, { -1, 0, 3, 5, 9, 12 }, { -1, 0, 3, 5, 9, 12 } };
		int[] targetList = { 12, 1, 3, 9, 2 };
		for (int i = 0; i < numsLists.length; i++) {
			int[] nums = numsLists[i];
			int target = targetList[i];
			int index = binarySearch(nums, target);
			System.out.println(i + 1 + ". Array to search: " + Arrays.toString(nums));
			System.out.println("   Target: " + targetList[i]);
			if (index != -1) {
				System.out.println("   " + target + " exists in the array and its index is " + index);
			} else {
				System.out.println("   " + target + " does not exist in the array so the return value is " + index);
			}
			System.out.println(
					"----------------------------------------------------------------------------------------------------\n");
		}
	}

	private static int binarySearch(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = end + (start - end) / 2;
			if (nums[mid] < target) {
				start = mid + 1;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
