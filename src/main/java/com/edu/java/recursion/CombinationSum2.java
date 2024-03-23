package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CombinationSum2 {

	private static final Logger LOGGER = LoggerFactory.getLogger(CombinationSum2.class);

	public static void main(String[] args) {
		int[] input = {10,1,2,7,6,1,5};
		int targetSum = 8;
		int currSum = 0;
		int currIdx = 0;
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currSet = new ArrayList<>();
		Arrays.sort(input);
		generateUniqueCombinationsRecForLoop(input, currSum, currIdx, targetSum, currSet, result);
		LOGGER.info("Result is :: {}", result);
	}

	// 1 2 2 2 5
	public static void generateUniqueCombinationsRecForLoop(int[] input, int currSum, int startIdx, int targetSum,
			List<Integer> currSet, List<List<Integer>> result) {

		if (currSum == targetSum) {
			result.add(new ArrayList<>(currSet));
			return;
		}

		if (currSum > targetSum)
			return;

		if (startIdx >= input.length)
			return;

		for (int currIdx = startIdx; currIdx < input.length; currIdx++) {
			if (currIdx > startIdx && input[currIdx] == input[currIdx - 1]) continue;
			currSet.add(input[currIdx]);
			generateUniqueCombinationsRecForLoop(input, currSum + input[currIdx], currIdx + 1, targetSum, currSet, result);
			currSet.remove(currSet.size() - 1);
		}
	}

	public static void generateUniqueCombinations(int[] input, int currSum, int currIdx, int targetSum,
			List<Integer> currSet, List<List<Integer>> result) {

		if (currSum == targetSum) {
			result.add(new ArrayList<>(currSet));
			return;
		}

		if (currSum > targetSum)
			return;
		if (currIdx >= input.length)
			return;

		int tempIdx = currIdx + 1;
		while (tempIdx < input.length && input[tempIdx - 1] == input[tempIdx]) tempIdx++;
		generateUniqueCombinations(input, currSum, tempIdx, targetSum, currSet, result);

		currSet.add(input[currIdx]);
		generateUniqueCombinations(input, currSum + input[currIdx], currIdx + 1, targetSum, currSet, result);
		currSet.remove(currSet.size() - 1);
	}

}
