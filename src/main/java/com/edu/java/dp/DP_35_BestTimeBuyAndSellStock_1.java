package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_35_BestTimeBuyAndSellStock_1 {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_35_BestTimeBuyAndSellStock_1.class);

	public static void main(String[] args) {
		int[] arr = { 7, 1, 5, 3, 6, 4 };
		int profit = maxProfit(arr);
		LOGGER.info("Maximum Profit = {}", profit);
	}

	// we will try to sell every day
	// keep track of minimum till the left
	// generate profit with current element and min calculated
	// update min again for next transaction
	private static int maxProfit(int[] arr) {
		int min = arr[0];
		int maxProfit = 0;
		for (int idx = 1; idx < arr.length; idx++) {
			maxProfit = Math.max(maxProfit, arr[idx] - min);
			min = Math.min(min, arr[idx]);
		}
		return maxProfit;
	}

}
