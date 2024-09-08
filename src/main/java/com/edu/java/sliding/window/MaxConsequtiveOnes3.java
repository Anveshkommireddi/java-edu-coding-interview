package com.edu.java.sliding.window;

public class MaxConsequtiveOnes3 {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		int k = 2;
		int result = longestOnes(nums, k);
		System.out.println(result);
	}

	public static int longestOnes(int[] nums, int k) {
		int result = 0;
		int start = 0;
		int zeroCount = 0;
		for (int end = 0; end < nums.length; end++) {

			int currNum = nums[end];

			if (currNum == 0) {
				zeroCount++;
			}

			while (zeroCount > k) {
				int startVal = nums[start];
				if (startVal == 0) {
					zeroCount--;
				}
				start++;
			}
			result = Math.max(result, end - start + 1);
		}
		return result;
	}

}
