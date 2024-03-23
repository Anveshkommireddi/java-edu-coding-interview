package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_14_SubSetSumEqualToK {

	private static final Logger Logger = LoggerFactory.getLogger(DP_14_SubSetSumEqualToK.class);

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int targetSum = 10;
		Boolean[][] mem = new Boolean[arr.length][targetSum + 1];
		// boolean subSetSumExist = checkIfSubSetSumEqualsKMem(arr, arr.length - 1,
		// targetSum, mem);
		boolean subSetSumExist = checkIfSubSetSumEqualsKTabFromMem(arr, targetSum);
		Logger.info("Result is :: {}", subSetSumExist);
	}

	private static boolean checkIfSubSetSumEqualsKMem(int[] arr, int currIdx, int targetSum, Boolean[][] mem) {
		if (targetSum < 0)
			return false;
		if (targetSum == 0)
			return true;
		if (currIdx == 0)
			return arr[currIdx] == targetSum;

		if (null != mem[currIdx][targetSum])
			return mem[currIdx][targetSum];

		boolean notInclude = checkIfSubSetSumEqualsKMem(arr, currIdx - 1, targetSum, mem);

		boolean include = false;
		if (arr[currIdx] <= targetSum) {
			include = checkIfSubSetSumEqualsKMem(arr, currIdx - 1, targetSum - arr[currIdx], mem);
		}

		return mem[currIdx][targetSum] = notInclude || include;
	}

	private static boolean checkIfSubSetSumEqualsKTabFromMem(int[] arr, int targetSum) {
		boolean[][] mem = new boolean[arr.length][targetSum + 1];
		for (int idx = 0; idx < arr.length; idx++)
			mem[idx][0] = true;
		for (int target = 0; target < targetSum + 1; target++) {
			if (arr[0] == target)
				mem[0][target] = true;
		}
		for (int valIdx = 1; valIdx < arr.length; valIdx++) {
			for (int target = 1; target < targetSum + 1; target++) {
				boolean notInclude = mem[valIdx - 1][target];
				boolean include = false;
				if (arr[valIdx] <= target) {
					include = mem[valIdx - 1][target - arr[valIdx]];
				}
				mem[valIdx][target] = include || notInclude;
			}
		}
		return mem[arr.length - 1][targetSum];
	}

	private static boolean checkIfSubSetSumEqualsKTab(int[] arr, int targetSum) {
		Boolean[][] mem = new Boolean[arr.length + 1][targetSum + 1];
		for (int valIdx = 0; valIdx < mem.length; valIdx++)
			mem[valIdx][0] = true;
		for (int currSum = 1; currSum < mem[0].length; currSum++)
			mem[0][currSum] = false;
		for (int val = 1; val < mem.length; val++) {
			for (int currSum = 1; currSum < mem[0].length; currSum++) {
				if (arr[val - 1] > currSum) {
					mem[val][currSum] = mem[val - 1][currSum];
				} else {
					boolean notInclude = mem[val - 1][currSum];
					boolean include = mem[val - 1][currSum - arr[val - 1]];
					mem[val][currSum] = notInclude || include;
				}
			}
		}
		return mem[mem.length - 1][mem[0].length - 1];
	}

	private static boolean checkIfSubSetSumEqualsK(int[] arr, int targetSum, int currIdx, int currSum,
			Boolean[][] mem) {

		if (currSum > targetSum)
			return false;

		if (currIdx > arr.length)
			return false;

		if (currIdx == arr.length) {
			return currSum == targetSum;
		}

		if (null != mem[currIdx][currSum]) {
			return mem[currIdx][currSum];
		}

		boolean includeFlag = checkIfSubSetSumEqualsK(arr, targetSum, currIdx + 1, currSum + arr[currIdx], mem);
		if (includeFlag == true) {
			return mem[currIdx][currSum] = true;
		}
		return mem[currIdx][currSum] = checkIfSubSetSumEqualsK(arr, targetSum, currIdx + 1, currSum, mem);
	}

}
