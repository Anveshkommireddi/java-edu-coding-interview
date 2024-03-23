package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_19_KnapSack {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_19_KnapSack.class);

	public static void main(String[] args) {
		int[] wt = { 1, 2, 4, 5 };
		int[] val = { 5, 4, 8, 6 };
		int bagWeight = 5;
		int maxProfitRec = maxProfitRec(wt, val, bagWeight, wt.length - 1);
		LOGGER.info("Max Profit From Rec is = {}", maxProfitRec);
		Integer[][] mem = new Integer[wt.length][bagWeight + 1];
		int maxProfitMem = maxProfitMem(wt, val, bagWeight, wt.length - 1, mem);
		LOGGER.info("Max Profit From Mem is = {}", maxProfitMem);
		int maxProfitBottomsUp = maxProfitBottomsUp(wt, val, bagWeight);
		LOGGER.info("Max Profit From BottomsUp is = {}", maxProfitBottomsUp);
	}
	
	 private static int maxProfitBottomsUp(int[] wt, int[] val, int bagWeight) {
			int[][] mem = new int[wt.length][bagWeight + 1];
			for(int weight = 0; weight < bagWeight + 1; weight++) {
				if(wt[0] <= bagWeight) mem[0][weight] = val[0];
			}
			
			for (int idx = 1; idx < wt.length; idx++) {
				for (int weight = 0; weight < bagWeight + 1; weight++) {
					int skipCurrent = mem[idx - 1][weight];
					int takeCurrent = Integer.MIN_VALUE;
					if (wt[idx] <= weight) {
						takeCurrent = val[idx] + mem[idx - 1][weight - wt[idx]];
					}
					mem[idx][weight] = Math.max(takeCurrent, skipCurrent);
				}
			}
			return mem[wt.length-1][bagWeight];
		}
	
   private static int maxProfitMem(int[] wt, int[] val, int bagWeight, int currIdx, Integer[][] mem) {
		
		if(currIdx == 0) {
			if(wt[currIdx] <= bagWeight) return val[currIdx];
			return 0;
		}
		
		if(null != mem[currIdx][bagWeight]) return mem[currIdx][bagWeight];
		
		int skipCurrent = maxProfitMem(wt, val, bagWeight, currIdx-1, mem);
		int takeCurrent = Integer.MIN_VALUE;
		if(wt[currIdx] <= bagWeight) {
			takeCurrent = val[currIdx] + maxProfitMem(wt, val, bagWeight - wt[currIdx], currIdx-1, mem);
		}
		return mem[currIdx][bagWeight] = Math.max(takeCurrent, skipCurrent);
	}

	private static int maxProfitRec(int[] wt, int[] val, int bagWeight, int currIdx) {
		
		if(currIdx == 0) {
			if(wt[currIdx] <= bagWeight) return val[currIdx];
			return 0;
		}
		
		int skipCurrent = maxProfitRec(wt, val, bagWeight, currIdx - 1);
		int takeCurrent = Integer.MIN_VALUE;
		if (wt[currIdx] <= bagWeight) {
			takeCurrent = val[currIdx] + maxProfitRec(wt, val, bagWeight - wt[currIdx], currIdx - 1);
		}
		return Math.max(takeCurrent, skipCurrent);
	}

}
