package com.edu.java.sliding.window;

public class MinimumSubArraySum {

	public static void main(String[] args) {
		int target = 7;
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int length = minSubArrayLen(target, nums);
		System.out.println(length);
	}

	public static int minSubArrayLen(int target, int[] nums) {
		int start = 0;
		int length = Integer.MAX_VALUE;
		int currSum = 0;
		for (int end = 0; end < nums.length; end++) {
			int currNum = nums[end];
			currSum += currNum;
			while (currSum >= target) {
				length = Math.min(length, end - start + 1);
				currSum -= nums[start];
				start++;
			}
		}
		return length == Integer.MAX_VALUE  ? -1 : length;
	}

}
