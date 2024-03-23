package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_38_BestTimeBuyAndSellStock_1V {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_38_BestTimeBuyAndSellStock_1V.class);

	public static void main(String[] args) {
		int[] arr = { 7, 1, 5, 3, 6, 4 };
		int currTransaction = 0;
		int noOfTransactions = 2;
		int maxProfit = getMaxProfit(arr, 0, currTransaction, noOfTransactions);
		LOGGER.info("Max Profit is :: {}", maxProfit);
	}

	private static int getMaxProfit(int[] arr, int currIdx, int currTransaction, int noOfTransactions) {
		
		if(currIdx == arr.length || currTransaction == 2 * noOfTransactions)
			return 0;

		if (currTransaction % 2 == 0) {
			return Math.max(-arr[currIdx] + getMaxProfit(arr, currIdx + 1, currTransaction + 1, noOfTransactions),
					getMaxProfit(arr, currIdx + 1, currTransaction, noOfTransactions));
		} else {
			return Math.max(arr[currIdx] + getMaxProfit(arr, currIdx + 1, currTransaction + 1, noOfTransactions),
					getMaxProfit(arr, currIdx + 1, currTransaction + 1, noOfTransactions));
		}
	}

}
