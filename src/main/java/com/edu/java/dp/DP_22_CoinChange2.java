package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_22_CoinChange2 {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_22_CoinChange2.class);

	public static void main(String[] args) {
		int[] coins = { 1, 2, 3 };
		int target = 4;
		int noOfWayRec = totalNoOfWaysRec(coins, target, coins.length - 1);
		LOGGER.info("Total Number of Ways Recursion :: {}", noOfWayRec);
		Integer[][] mem = new Integer[coins.length][target + 1];
		int noOfWaysMem = totalNoOfWaysMem(coins, target, coins.length - 1, mem);
		LOGGER.info("Total Number of Ways Memoization :: {}", noOfWaysMem);
		int noOfWaysBottomsUp = totalNoOfWaysBottomsUp(coins, target);
		LOGGER.info("Total Number of Ways BottomsUp :: {}", noOfWaysBottomsUp);
	}
	
	private static int totalNoOfWaysBottomsUp(int[] coins, int target) {
		int[][] mem = new int[coins.length][target + 1];
		for (int coin = 0; coin < target + 1; coin++) {
			mem[0][coin] = coin % coins[0] == 0 ? 1 : 0;
		}
		for (int idx = 1; idx < coins.length; idx++) {
			for (int coin = 0; coin < target + 1; coin++) {
				int dontTake = mem[idx - 1][coin];
				int take = 0;
				if (coins[idx] <= coin) {
					take = mem[idx][coin - coins[idx]];
				}
				mem[idx][coin] = take + dontTake;
			}
		}
		return mem[coins.length - 1][target];
	}

	private static int totalNoOfWaysMem(int[] coins, int target, int currIdx, Integer[][] mem) {

		if (currIdx == 0) {
			return target % coins[currIdx] == 0 ? 1 : 0;
		}

		if (null != mem[currIdx][target])
			return mem[currIdx][target];

		int dontTake = totalNoOfWaysMem(coins, target, currIdx - 1, mem);
		int take = 0;
		if (coins[currIdx] <= target) {
			take = totalNoOfWaysMem(coins, target - coins[currIdx], currIdx, mem);
		}
		return mem[currIdx][target] = take + dontTake;
	}

	private static int totalNoOfWaysRec(int[] coins, int target, int currIdx) {
		
		if(currIdx == 0) return target % coins[currIdx] == 0 ? 1 : 0;

		int dontInclude = totalNoOfWaysRec(coins, target, currIdx - 1);
		int include = 0;
		if (coins[currIdx] <= target) {
			include = totalNoOfWaysRec(coins, target - coins[currIdx], currIdx);
		}
		return dontInclude + include;
	}

}
