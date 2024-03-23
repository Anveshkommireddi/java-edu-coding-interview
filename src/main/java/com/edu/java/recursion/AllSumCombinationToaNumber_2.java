package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllSumCombinationToaNumber_2 {

	private static final Logger LOGGER = LoggerFactory.getLogger(AllSumCombinationToaNumber_2.class);

	public static void main(String[] args) {
		int n = 3;
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currResult = new ArrayList<>();
		int currSum = 0;
		generateAllCombinations(n, currSum, currResult, result);
		result.stream().forEach(res -> LOGGER.info("{}", res));
	}

	private static void generateAllCombinations(int target, int currSum, List<Integer> currResult,
			List<List<Integer>> result) {

		if (currSum == target) {
			result.add(new ArrayList<>(currResult));
			return;
		}

		for (int currVal = 1; currVal < target; currVal++) {
			if (currVal + currSum <= target) {
				currResult.add(currVal);
				generateAllCombinations(target, currSum + currVal, currResult, result);
				currResult.remove(currResult.size() - 1);
			}
		}
	}
}
