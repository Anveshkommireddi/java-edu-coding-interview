package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_20_MinimumCoins {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_20_MinimumCoins.class);

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 11;
		int minCoinsRec = getMinCoinsRec(coins, amount, coins.length - 1);
		LOGGER.info("Minimum Number of Coins From Recursion = {}", minCoinsRec);
		Integer[][] mem = new Integer[coins.length][amount + 1];
		int minCoinsMem = getMinCoinsMem(coins, amount, coins.length - 1, mem);
		LOGGER.info("Minimum Number of Coins From Memoization = {}", minCoinsMem);
		int minCoinsBottomsUp = getMinCoinsBottomsUp(coins, amount);
		LOGGER.info("Minimum Number of Coins From BottomsUp = {}", minCoinsBottomsUp);
	}

	private static int getMinCoinsBottomsUp(int[] coins, int amount) {

		int[][] mem = new int[coins.length][amount + 1];
		for (int coin = 0; coin < amount + 1; coin++) {
			mem[0][coin] = coins[0] <= coin && coin % coins[0] == 0 ? coin / coins[0] : (int) Math.pow(10, 9);
		}

		for (int idx = 1; idx < coins.length; idx++) {
			for (int coin = 0; coin < amount + 1; coin++) {
				int dontInclude = mem[idx - 1][coin];
				int include = (int) Math.pow(10, 9);
				if (coins[idx] <= coin) {
					include = 1 + mem[idx][coin - coins[idx]];
				}
				mem[idx][coin] = Math.min(dontInclude, include);
			}
		}
		return mem[coins.length - 1][amount];
	}

	private static int getMinCoinsMem(int[] coins, int amount, int currIdx, Integer[][] mem) {

		if (currIdx == 0) {
			if (coins[currIdx] <= amount && amount % coins[currIdx] == 0)
				return amount / coins[currIdx];
			return (int) Math.pow(10, 9);
		}

		if (null != mem[currIdx][amount])
			return mem[currIdx][amount];

		int dontInclude = getMinCoinsMem(coins, amount, currIdx - 1, mem);
		int include = (int) Math.pow(10, 9);
		if (coins[currIdx] <= amount) {
			include = 1 + getMinCoinsMem(coins, amount - coins[currIdx], currIdx, mem);
		}
		return mem[currIdx][amount] = Math.min(dontInclude, include);
	}

	private static int getMinCoinsRec(int[] coins, int amount, int currIdx) {

		if (currIdx == 0) {
			if (coins[currIdx] <= amount && amount % coins[currIdx] == 0)
				return amount / coins[currIdx];
			return (int) Math.pow(10, 9);
		}

		int dontInclude = getMinCoinsRec(coins, amount, currIdx - 1);
		int include = (int) Math.pow(10, 9);
		if (coins[currIdx] <= amount) {
			include = 1 + getMinCoinsRec(coins, amount - coins[currIdx], currIdx);
		}
		return Math.min(dontInclude, include);
	}

}
