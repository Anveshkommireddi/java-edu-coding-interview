package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllSumCombinationToaNumber {

	private static final Logger LOGGER = LoggerFactory.getLogger(AllSumCombinationToaNumber.class);

	public static void main(String[] args) {
		int n = 3;
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currResult = new ArrayList<>();
		int currSum = 0;
		int currStart = 1;
		generateAllCombinations(n, currStart, currSum, currResult, result);
		result.stream().forEach(res -> LOGGER.info("{}", res));
	}

	/**
	 * currStart is required to get numbers without duplicates if the loop is
	 * iterated with 1 to n, then duplicates will come
	 */
	private static void generateAllCombinations(int target, int currStart, int currSum, List<Integer> currResult,
			List<List<Integer>> result) {

		if (currSum == target) {
			result.add(new ArrayList<>(currResult));
			return;
		}

		if (currStart > target)
			return;

		if (currSum > target)
			return;

		for (int currNum = currStart; currNum < target; currNum++) {
			if (currSum + currNum <= target) {
				currResult.add(currNum);
				generateAllCombinations(target, currNum, currSum + currNum, currResult, result);
				currResult.remove(currResult.size() - 1);
			}
		}
	}
}
