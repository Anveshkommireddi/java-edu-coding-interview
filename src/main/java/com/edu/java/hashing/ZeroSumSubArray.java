package com.edu.java.hashing;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubArray {
	
	public static void main(String[] args) {
		int[] nums = { -5, -5, 2, 3, -2 };
		boolean isZeroSumSubArrayPossible = isPresent(nums);
		System.out.println(isZeroSumSubArrayPossible);
	}

	private static boolean isPresent(int[] nums) {
		Set<Integer> prefixSumStore = new HashSet<>();
		prefixSumStore.add(0);
		int currSum = 0;
		for (int num : nums) {
			currSum += num;
			if (prefixSumStore.contains(currSum)) {
				return true;
			}
			prefixSumStore.add(currSum);
		}
		return false;
	}

}
