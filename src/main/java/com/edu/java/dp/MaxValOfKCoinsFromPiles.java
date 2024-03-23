package com.edu.java.dp;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//LC :: 2218
public class MaxValOfKCoinsFromPiles {

	private static final Logger LOGGER = LoggerFactory.getLogger(MaxValOfKCoinsFromPiles.class);

	public static void main(String[] args) {
		List<List<Integer>> piles = Arrays.asList(Arrays.asList(1, 100, 3), Arrays.asList(7, 8, 9));
		int k = 2;
		int res = maxValByKCoins(piles, 0, k);
		LOGGER.info("Max Value is {}", res);
	}

	private static int maxValByKCoins(List<List<Integer>> piles, int pileIdx, int coins) {
		if (pileIdx >= piles.size() || coins <= 0)
			return 0;
		int dontPick = maxValByKCoins(piles, pileIdx + 1, coins);
		int pick = 0;
		int currPile = 0;
		List<Integer> coinsList = piles.get(pileIdx);
		for (int coinIdx = 0; coinIdx < Math.min(coinsList.size(), coins); coinIdx++) {
			currPile += coinsList.get(coinIdx);
			pick = Math.max(pick, currPile + maxValByKCoins(piles, pileIdx + 1, coins - coinIdx - 1));
		}
		return Math.max(pick, dontPick);
	}

}
