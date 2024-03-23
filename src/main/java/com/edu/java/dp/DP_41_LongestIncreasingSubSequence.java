package com.edu.java.dp;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_41_LongestIncreasingSubSequence {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_41_LongestIncreasingSubSequence.class);

	public static void main(String[] args) {
		int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int currIdx = 0;
		int prevIdx = -1;
		int maxLengthOfLIS = maxLenOfLISRec(arr, currIdx, prevIdx);
		LOGGER.info("Max LIS for REC = {}", maxLengthOfLIS);
		Integer[][] mem = new Integer[arr.length][arr.length + 1];
		int maxLengthOfLISMem = maxLenOfLISMem(arr, currIdx, prevIdx, mem);
		LOGGER.info("Max LIS for MEM = {}", maxLengthOfLISMem);
	}
	
	private static int maxLenOfLISDP(int[] arr) {
		int[] mem = new int[arr.length];
		int maxi = Integer.MIN_VALUE;
		Arrays.fill(mem, 1);
		for (int currIdx = 1; currIdx < arr.length; currIdx++) {
			for (int prevIdx = 0; prevIdx < currIdx; prevIdx++) {
				if (arr[currIdx] > arr[prevIdx]) {
					mem[currIdx] = Math.max(mem[currIdx], 1 + mem[prevIdx]);
				}
			}
			maxi = Math.max(maxi, mem[currIdx]);
		}
		return maxi;
	}

	private static int maxLenOfLISBottomsUp(int[] arr) {
		int[][] mem = new int[arr.length + 1][arr.length + 1];
		for (int prevIdx = 0; prevIdx <= arr.length; prevIdx++) {
			mem[arr.length][prevIdx] = 0;
		}

		for (int currIdx = arr.length - 1; currIdx >= 0; currIdx--) {
			for (int prevIdx = currIdx - 1; prevIdx >= -1; prevIdx--) {
				int notTake = mem[currIdx + 1][prevIdx + 1];
				int take = Integer.MIN_VALUE;
				if (prevIdx == -1 || arr[currIdx] > arr[prevIdx]) {
					take = 1 + mem[currIdx + 1][currIdx];
				}
				mem[currIdx][prevIdx + 1] = Math.max(notTake, take);
			}
		}
		return mem[0][0];
	}

	private static int maxLenOfLISMem(int[] arr, int currIdx, int prevIdx, Integer[][] mem) {

		if (currIdx == arr.length)
			return 0;

		if (null != mem[currIdx][prevIdx + 1])
			return mem[currIdx][prevIdx + 1];

		int notTake = maxLenOfLISRec(arr, currIdx + 1, prevIdx);
		int take = Integer.MIN_VALUE;
		if (prevIdx == -1 || arr[currIdx] > arr[prevIdx]) {
			take = 1 + maxLenOfLISRec(arr, currIdx + 1, currIdx);
		}
		return mem[currIdx][prevIdx + 1] = Math.max(notTake, take);
	}

	private static int maxLenOfLISRec(int[] arr, int currIdx, int prevIdx) {

		if (currIdx == arr.length)
			return 0;

		int notTake = maxLenOfLISRec(arr, currIdx + 1, prevIdx);
		int take = Integer.MIN_VALUE;
		if (prevIdx == -1 || arr[currIdx] > arr[prevIdx]) {
			take = 1 + maxLenOfLISRec(arr, currIdx + 1, currIdx);
		}
		return Math.max(notTake, take);
	}

}
