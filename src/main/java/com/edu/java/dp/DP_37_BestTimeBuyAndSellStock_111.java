package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_37_BestTimeBuyAndSellStock_111 {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_37_BestTimeBuyAndSellStock_111.class);

	//maximize profit for n transactions
	public static void main(String[] args) {
		int[] arr = { 7, 1, 5, 3, 6, 4 };
		int isBuyPossible = 1;
		int maxNoOfTransaction = 2;
		int maxProfit = getMaxProfit(arr, 0, maxNoOfTransaction, isBuyPossible);
		LOGGER.info("Max Profit is :: {}", maxProfit);
		Integer[][][] mem = new Integer[arr.length + 1][maxNoOfTransaction + 1][2];
		int maxProfitMem = getMaxProfitMem(arr, 0, maxNoOfTransaction, isBuyPossible, mem);
		LOGGER.info("Max Profit is :: {}", maxProfitMem);
	}

	private static int getMaxProfitMem(int[] arr, int currIdx, int numOfTransactions, int isBuyPossible, Integer[][][] mem) {

		if (numOfTransactions == 0 || currIdx == arr.length)
			return 0;

		if (null != mem[currIdx][numOfTransactions][isBuyPossible])
			return mem[currIdx][numOfTransactions][isBuyPossible];

		if (isBuyPossible == 1) {
			return mem[currIdx][numOfTransactions][isBuyPossible] = Math.max(
					-arr[currIdx] + getMaxProfit(arr, currIdx + 1, numOfTransactions, 0),
					getMaxProfit(arr, currIdx + 1, numOfTransactions, 1));
		} else {
			return mem[currIdx][numOfTransactions][isBuyPossible] = Math.max(
					arr[currIdx] + getMaxProfit(arr, currIdx + 1, numOfTransactions - 1, 1),
					getMaxProfit(arr, currIdx + 1, numOfTransactions, 0));
		}
	}

	private static int getMaxProfit(int[] arr, int currIdx, int numOfTransactions, int isBuyPossible) {

		if (numOfTransactions == 0 || currIdx == arr.length)
			return 0;

		if (isBuyPossible == 1) {
			return Math.max(-arr[currIdx] + getMaxProfit(arr, currIdx + 1, numOfTransactions, 0),
					getMaxProfit(arr, currIdx + 1, numOfTransactions, 1));
		} else {
			return Math.max(arr[currIdx] + getMaxProfit(arr, currIdx + 1, numOfTransactions - 1, 1),
					getMaxProfit(arr, currIdx + 1, numOfTransactions, 0));
		}
	}

}
