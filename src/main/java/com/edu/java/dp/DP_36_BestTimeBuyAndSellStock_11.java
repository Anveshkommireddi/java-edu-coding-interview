package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_36_BestTimeBuyAndSellStock_11 {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_36_BestTimeBuyAndSellStock_11.class);

	//maximize profit for the whole input (infinite transactions)
	public static void main(String[] args) {
		int[] arr = { 7, 1, 5, 3, 6, 4 };
		boolean isBuyPossible = true;
		int profit = maxProfit(arr, 0, isBuyPossible);
		LOGGER.info("Maximum Profit = {}", profit);
		Integer[][] mem = new Integer[arr.length][2];
		int profitMem = maxProfitMem(arr, 0, 1, mem);
		LOGGER.info("Maximum Profit = {}", profitMem);
	}

	private static int maxProfitBottomsUp(int[] arr) {
		int[][] mem = new int[arr.length + 1][2];
		mem[arr.length][0] = 0;
		mem[arr.length][1] = 0;
		for (int idx = arr.length - 1; idx >= 0; idx--) {
			for (int buy = 0; buy <= 1; buy++) {
				if (buy == 1) {
					mem[idx][buy] = Math.max(-arr[idx] + mem[idx + 1][0], mem[idx + 1][1]);
				} else {
					mem[idx][buy] = Math.max(arr[idx] + mem[idx + 1][0], mem[idx + 1][1]);
				}
			}
		}
		return mem[0][1];
	}

	private static int maxProfitMem(int[] arr, int currIdx, int isBuyPossible, Integer[][] mem) {

		if (currIdx == arr.length)
			return 0;

		if (null != mem[currIdx][isBuyPossible])
			return mem[currIdx][isBuyPossible];

		if (isBuyPossible == 1) {
			return mem[currIdx][isBuyPossible] = Math.max(-arr[currIdx] + maxProfitMem(arr, currIdx + 1, 0, mem),
					maxProfitMem(arr, currIdx + 1, 1, mem));
		} else {
			return mem[currIdx][isBuyPossible] = Math.max(arr[currIdx] + maxProfitMem(arr, currIdx + 1, 1, mem),
					maxProfitMem(arr, currIdx + 1, 0, mem));
		}
	}

	private static int maxProfit(int[] arr, int currIdx, boolean isBuyPossible) {

		if (currIdx == arr.length) {
			return 0;
		}

		if (isBuyPossible) {
			return Math.max(-arr[currIdx] + maxProfit(arr, currIdx + 1, !isBuyPossible),
					maxProfit(arr, currIdx + 1, isBuyPossible));
		} else {
			return Math.max(arr[currIdx] + maxProfit(arr, currIdx + 1, !isBuyPossible),
					maxProfit(arr, currIdx + 1, isBuyPossible));
		}
	}

}
