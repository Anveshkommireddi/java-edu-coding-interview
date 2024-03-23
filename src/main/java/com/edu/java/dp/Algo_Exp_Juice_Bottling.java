package com.edu.java.dp;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Algo_Exp_Juice_Bottling {

	private static final Logger LOGGER = LoggerFactory.getLogger(Algo_Exp_Juice_Bottling.class);

	static int maxPathSum = 0;
	static ArrayList<Integer> result;

	public static void main(String[] args) {
		int[] prices = { 0, 2, 3 };
		juiceBottling(prices);
		LOGGER.info("Result is {}", result);
	}

	public static ArrayList<Integer> juiceBottling(int[] prices) {
		ArrayList<Integer> currResult = new ArrayList<>();
		helper(prices, prices.length - 1, prices.length - 1, currResult);
		return result;
	}

	private static void helper(int[] prices, int priceIdx, int juice, ArrayList<Integer> currResult) {
		if (juice == 0) {
			int currPathSum = currResult.stream().mapToInt(idx -> prices[idx]).sum();
			if (currPathSum > maxPathSum) {
				maxPathSum = currPathSum;
				result = new ArrayList<>(currResult);
			}
			return;
		}
		if (juice < 0 || priceIdx == 0)
			return;
		helper(prices, priceIdx - 1, juice, currResult);
		if (priceIdx <= juice) {
			currResult.add(priceIdx);
			helper(prices, priceIdx, juice - priceIdx, currResult);
			currResult.remove(currResult.size() - 1);
		}
	}
}
