package com.edu.java.dp;

import java.util.ArrayList;
import java.util.List;

public class DP_43_LIS_BinarySearch {

	public static void main(String[] args) {

	}

	public static int longestSubsequence(int[] nums) {
		List<Integer> lis = new ArrayList<>();
		lis.add(nums[0]);
		for (int idx = 1; idx < nums.length; idx++) {
			for (int idx2 = 0; idx2 < idx; idx2++) {
				int currSize = lis.size();
				int lb = getLowerBound(lis, nums[idx]);
				if (lb >= currSize) {
					lis.add(nums[idx]);
				} else {
					lis.set(lb, nums[idx]);
				}
			}
		}
		return lis.size();
	}

	private static int getLowerBound(List<Integer> list, int target) {
		int low = 0;
		int high = list.size() - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (list.get(mid) == target) {
				return mid;
			} else if (list.get(mid) < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

}
