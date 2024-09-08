package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_17_Count_SubSets_With_SUM_K {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_17_Count_SubSets_With_SUM_K.class);

	public static void main(String[] args) {
		// int[] input = { 1, 2, 2, 3 }; int target = 3;
		int[] input = { 1, 0, 0 }; // if 0 is present make it to descending order to get correct answer
		int target = 1;
		int recCount = countSubSetsRec(input, input.length - 1, target);
		LOGGER.info("Recursion Count is = {}", recCount);
		Integer[][] mem = new Integer[input.length][target + 1];
		int memCount = countSubSetsMem(input, input.length - 1, target, mem);
		LOGGER.info("Memoization Count is = {}", memCount);
		int bottomsUpCount = countSubSetsBottomsUp(input, target);
		LOGGER.info("BottomsUp Count is = {}", bottomsUpCount);
	}

	private static int countSubSetsBottomsUp(int[] input, int target) {

		int[][] mem = new int[input.length][target + 1];

		for (int size = 0; size < input.length; size++) {
			mem[size][0] = 1;
		}

		for (int sum = 0; sum < target + 1; sum++) {
			if (sum == input[0])
				mem[0][sum] = 1;
		}

		for (int size = 1; size < input.length; size++) {
			for (int sum = 0; sum < target + 1; sum++) {
				int skipCurrElementCount = mem[size - 1][sum];
				int dontSkipCurrElementCount = 0;
				if (input[size] <= sum) {
					dontSkipCurrElementCount = mem[size - 1][sum - input[size]];
				}
				mem[size][sum] = skipCurrElementCount + dontSkipCurrElementCount;
			}
		}

		return mem[input.length - 1][target];
	}

	// calculating using zeros
	private static int countSubSetsMem(int[] input, int currIdx, int target, Integer[][] mem) {

		if (target == 0)
			return 1;

		if (currIdx == 0 && target == input[currIdx])
			return 1;

		if (currIdx <= 0 || target < 0)
			return 0;

		if (mem[currIdx][target] != null)
			return mem[currIdx][target];

		int skipCurrElementCount = countSubSetsRec(input, currIdx - 1, target);
		int dontSkipCurrElementCount = 0;
		if (input[currIdx] <= target) {
			dontSkipCurrElementCount = countSubSetsRec(input, currIdx - 1, target - input[currIdx]);
		}
		return mem[currIdx][target] = skipCurrElementCount + dontSkipCurrElementCount;
	}

	private static int countSubSetsRec(int[] input, int currIdx, int target) {

		if (target == 0)
			return 1;

		if (currIdx == 0 && target == input[currIdx])
			return 1;

		if (currIdx <= 0 || target < 0)
			return 0;

		int skipCurrElementCount = countSubSetsRec(input, currIdx - 1, target);
		int dontSkipCurrElementCount = 0;
		if (input[currIdx] <= target) {
			dontSkipCurrElementCount = countSubSetsRec(input, currIdx - 1, target - input[currIdx]);
		}
		return skipCurrElementCount + dontSkipCurrElementCount;
	}

	private static int checkIfSubSetSumEqualsKTab(int[] arr, int targetSum) {
		int[][] mem = new int[arr.length + 1][targetSum + 1];
		for (int valIdx = 0; valIdx < mem.length; valIdx++)
			mem[valIdx][0] = 1;
		for (int currSum = 1; currSum < mem[0].length; currSum++)
			mem[0][currSum] = 0;
		for (int val = 1; val < mem.length; val++) {
			for (int currSum = 1; currSum < mem[0].length; currSum++) {
				if (arr[val - 1] > currSum) {
					mem[val][currSum] = mem[val - 1][currSum];
				} else {
					int notInclude = mem[val - 1][currSum];
					int include = mem[val - 1][currSum - arr[val - 1]];
					mem[val][currSum] = notInclude + include;
				}
			}
		}
		return mem[mem.length - 1][mem[0].length - 1];
	}

}
