package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_23_UnBoundedKnapSack {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_23_UnBoundedKnapSack.class);

	public static void main(String... args) {
		int[] val = { 10, 40, 50, 70 };
		int[] wt = { 1, 3, 4, 5 };
		int target = 8;
		int currIdx = wt.length - 1;
		int ans = unboundedKnapSackRec(wt, val, currIdx, target);
		LOGGER.info("Recursion Answer is :: {}", ans);
		Integer[][] mem = new Integer[val.length][target + 1];
		int memAns = unboundedKnapSackMem(wt, val, currIdx, target, mem);
		LOGGER.info("Memoization Answer is :: {}", memAns);
	}
	
	private static int unboundedKnapSackMem(int[] wt, int[] val, int currIdx, int targetWeight, Integer[][] mem) {
		if (currIdx == 0) {
			if (wt[currIdx] <= targetWeight) return (targetWeight / wt[currIdx]) * val[currIdx];
			return 0;
		}
		if (mem[currIdx][targetWeight] != null) return mem[currIdx][targetWeight];
		int dontPick = unboundedKnapSackMem(wt, val, currIdx - 1, targetWeight, mem);
		int pick = Integer.MIN_VALUE;
		if (wt[currIdx] <= targetWeight) {
			pick = val[currIdx] + unboundedKnapSackMem(wt, val, currIdx, targetWeight - wt[currIdx], mem);
		}
		return mem[currIdx][targetWeight] = Math.max(pick, dontPick);
	}

	private static int unboundedKnapSackRec(int[] wt, int[] val, int currIdx, int targetWeight) {
		if (currIdx == 0) {
			if (wt[currIdx] <= targetWeight)
				return (targetWeight / wt[currIdx]) * val[currIdx];
			return 0;
		}
		int dontPick = unboundedKnapSackRec(wt, val, currIdx - 1, targetWeight);
		int pick = Integer.MIN_VALUE;
		if (wt[currIdx] <= targetWeight) {
			pick = val[currIdx] + unboundedKnapSackRec(wt, val, currIdx, targetWeight - wt[currIdx]);
		}
		return Math.max(pick, dontPick);
	}

}
