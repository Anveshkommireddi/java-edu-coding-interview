package com.edu.java.misc;

import java.util.Arrays;

public class JumpGame {

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		Boolean[] mem = new Boolean[nums.length + 1];
		boolean result = checkMem(nums, 0, mem);
		System.out.println(result);
		int[] dp = new int[nums.length];
		Arrays.fill(dp, -1);
		int count = countMem(nums, 0, dp);
		System.out.println(count);
	}
	
	private static int count(int[] nums, int idx) {
		if (idx == nums.length - 1) return 0;
		int result = 99999;
		int maxJumpVal = nums[idx];
		for (int i = idx + 1; (i <= idx + maxJumpVal && i < nums.length); i++) {
			result = Math.min(result, 1 + count(nums, i));
		}
		return result;
	}
	
	private static int countMem(int[] nums, int idx, int[] mem) {
		if (idx == nums.length - 1) return mem[idx] = 0;
		if(mem[idx] != -1) return mem[idx];
		int result = 99999;
		int maxJumpVal = nums[idx];
		for (int i = idx + 1; (i <= idx + maxJumpVal && i < nums.length); i++) {
			result = Math.min(result, 1 + countMem(nums, i, mem));
		}
		return mem[idx] = result;
	}

	private static boolean checkMem(int[] nums, int idx, Boolean[] mem) {
		if (idx >= nums.length - 1)
			return mem[idx] = true;
		int currVal = nums[idx];
		boolean result = false;
		for (int i = idx; i < idx + currVal; i++) {
			boolean temp = check(nums, i + 1);
			if (temp == true)
				return mem[idx] = true;
		}
		return mem[idx] = result;
	}

	private static boolean check(int[] nums, int idx) {
		if (idx >= nums.length - 1)
			return true;
		int currVal = nums[idx];
		boolean result = false;
		for (int i = idx; i < idx + currVal; i++) {
			boolean temp = check(nums, i + 1);
			if (temp == true)
				return true;
		}
		return result;
	}
}
