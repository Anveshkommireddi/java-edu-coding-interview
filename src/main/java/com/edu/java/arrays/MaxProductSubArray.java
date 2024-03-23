package com.edu.java.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxProductSubArray {

	private static final Logger LOGGER = LoggerFactory.getLogger(MaxProductSubArray.class);

	public static void main(String[] args) {
		int[] nums = { 1, 2, -3, 0, -4, -5 };
		int result = maxProductSubArray(nums);
		LOGGER.info("Result is {}", result);
	}

	private static int maxProductSubArray(int[] nums) {
		int currMaxProduct = 1;
		int currMinProduct = 1;
		int maxProduct = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				currMaxProduct = 1;
				currMinProduct = 1;
				continue;
			}
			int tempMaxProduct = Math.max(nums[i], Math.max(nums[i] * currMinProduct, nums[i] * currMaxProduct));
			int tempMinProduct = Math.min(nums[i], Math.min(nums[i] * currMinProduct, nums[i] * currMaxProduct));
			currMaxProduct = Math.max(currMaxProduct, Math.max(tempMinProduct, tempMaxProduct));
			currMinProduct = Math.min(currMinProduct, Math.min(tempMinProduct, tempMaxProduct));
			maxProduct = Math.max(maxProduct, Math.max(currMinProduct, currMaxProduct));
		}
		return maxProduct;
	}

}
