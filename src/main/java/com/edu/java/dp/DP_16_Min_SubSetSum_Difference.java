package com.edu.java.dp;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_16_Min_SubSetSum_Difference {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_16_Min_SubSetSum_Difference.class);

	public static void main(String[] args) {
		int[] arr = { 3, 2, 7 };
		int totalSum = Arrays.stream(arr).sum();
		int targetSum = totalSum / 2;
		boolean[] result = getTotalSumsPossible(arr, targetSum);
		int minDiff = Integer.MAX_VALUE;
		for (int idx = 0; idx < result.length; idx++) {
			if(result[idx] == true) {
				int diff = Math.abs(idx - (totalSum - idx));
				minDiff = Math.min(minDiff, diff);
			}
		}
		LOGGER.info("Minimum SubSet Sum Diff is {}", minDiff);
	}

	private static boolean[] getTotalSumsPossible(int[] arr, int targetSum) {
		boolean[][] dp = new boolean[arr.length][targetSum + 1];
		// mark zero sum target to true
		for (int idx = 0; idx < arr.length; idx++) {
			dp[idx][0] = true;
		}

		for (int tgt = 1; tgt < targetSum + 1; tgt++) {
			if (arr[0] == tgt)
				dp[0][tgt] = true;
		}

		for (int idx = 1; idx < arr.length; idx++) {
			for (int tgt = 1; tgt < targetSum + 1; tgt++) {
				boolean dontPick = dp[idx - 1][tgt];
				boolean include = false;
				if (arr[idx] <= tgt) {
					include = dp[idx - 1][tgt - arr[idx]];
				}
				dp[idx][tgt] = dontPick | include;
			}
		}
		return dp[arr.length - 1];
	}

}
