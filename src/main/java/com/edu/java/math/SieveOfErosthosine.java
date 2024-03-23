package com.edu.java.math;

import java.util.Arrays;

public class SieveOfErosthosine {

	public static void main(String[] args) {
		int n = 1000;
		boolean[] nums = new boolean[n + 1];
		Arrays.fill(nums, true);
		getPrimes(nums, n);
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] == true) {
				System.out.print(i + " ");
			}
		}
	}

	private static void getPrimes(boolean[] nums, int n) {
		for (int num = 2; num * num <= n; num++) {
			for (int val = num * 2; val <= n; val += num) {
				nums[val] = false;
			}
		}
	}

}
