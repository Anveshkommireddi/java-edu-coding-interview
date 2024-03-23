package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CombinationSum1 {

	private static final Logger LOGGER = LoggerFactory.getLogger(CombinationSum1.class);

	public static void main(String[] args) {
		int[] input = { 2, 3, 5 };
		int currIdx = 0;
		int targetSum = 7;
		int currSum = 0;
		List<Integer> currSet = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		generateCombinationSum(input, currIdx, currSum, targetSum, currSet, result);
		LOGGER.info("Result is {}", result);
	}

	private static void generateCombinationSum(int[] input, int currIdx, int currSum, int targetSum,
			List<Integer> currSet, List<List<Integer>> result) {

		if (currSum == targetSum) {
			result.add(new ArrayList<>(currSet));
			return;
		}

		if (currSum > targetSum)
			return;

		if (currIdx >= input.length)
			return;

		generateCombinationSum(input, currIdx + 1, currSum, targetSum, currSet, result);

		currSet.add(input[currIdx]);
		generateCombinationSum(input, currIdx, currSum + input[currIdx], targetSum, currSet, result);
		currSet.remove(currSet.size() - 1);

	}

}
