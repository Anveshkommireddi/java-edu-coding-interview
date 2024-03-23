package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_24_RodCuttingProblem {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_24_RodCuttingProblem.class);

	public static void main(String[] args) {
		int rolLength = 5;
		int[] prices = { 2, 5, 7, 8, 10 };
		int maxProfitWithRec = getMaxProfitFromRec(prices, rolLength, prices.length-1);
		LOGGER.info("With {} cuts, Maximum Profit Achieved is {}", rolLength, maxProfitWithRec);
	}

	//get max profit after n cuts given in input -- similar to unbounded knapsack
	private static int getMaxProfitFromRec(int[] prices, int totalRodLength, int currIdx) {
		if (currIdx == 0) {
			if (totalRodLength > 0)
				return totalRodLength * prices[currIdx];
			return Integer.MIN_VALUE;
		}
		int dontPick = getMaxProfitFromRec(prices, totalRodLength, currIdx - 1);
		int pick = Integer.MIN_VALUE;
		int currRodLength = currIdx + 1;
		if (totalRodLength - currRodLength >= 0) {
			pick = prices[currIdx] + getMaxProfitFromRec(prices, totalRodLength - currRodLength, currIdx);
		}
		return Math.max(dontPick, pick);
	}

}
