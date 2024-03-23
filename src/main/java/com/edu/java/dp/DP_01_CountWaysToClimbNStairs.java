package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_01_CountWaysToClimbNStairs {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_01_CountWaysToClimbNStairs.class);
	public static final int MOD = Double.valueOf(Math.pow(10, 9) + 7).intValue(); // 1000000007

	public static void main(String[] args) {
		long nStairs = 3;
		long totalDistinctWays = countDistinctWayToClimbStair(nStairs);
		LOGGER.info("Total Number of Distinct Ways with 1 or 2 steps climbing is {}", totalDistinctWays);
	}

	public static long countDistinctWayToClimbStair(long nStairs) {
		Long[] mem = new Long[(int) (nStairs + 1)];
		int currIdx = (int) nStairs;
		long result = countDistinctWaysHelper(nStairs, mem);
		return result;
	}

	private static long countDistinctWaysHelper(long nStairs, Long[] mem) {
		if (nStairs == 0 || nStairs == 1)
			return 1;
		if (nStairs < 0)
			return 0;
		if (null != mem[(int) nStairs])
			return mem[(int) nStairs];
		long oneStep = countDistinctWaysHelper(nStairs - 1, mem);
		long twoStep = countDistinctWaysHelper(nStairs - 2, mem);
		return mem[(int) nStairs] = (oneStep + twoStep) % MOD;
	}

}
