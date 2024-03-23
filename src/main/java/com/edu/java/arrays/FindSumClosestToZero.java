package com.edu.java.arrays;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindSumClosestToZero {

	private static final Logger LOGGER = LoggerFactory.getLogger(FindSumClosestToZero.class);

	public static void main(String[] args) {
		int[] nums = { 1, 3, -5, 7, 8, 2, -6 };
		int[] res = findTwoNumbersWithClosestSumToZero(nums);
		LOGGER.info("Two Numbers are {} and {}", res[0], res[1]);
	}

	public static int[] findTwoNumbersWithClosestSumToZero(int[] nums) {
		int[] res = new int[2];
		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1;
		int minres = Integer.MAX_VALUE;
		while(start < end) {
			int sum = nums[start] + nums[end];
			if(sum == 0) {
				return new int[] {nums[start], nums[end] };
			}
			if(Math.abs(sum) < minres) {
				minres = sum;
				res[0] = nums[start];
				res[1] = nums[end];
			}
			if(sum > 0) {
				end--;
			} else {
				start++;
			}
		}
		return res;
	}
}
