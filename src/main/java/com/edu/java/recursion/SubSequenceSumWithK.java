package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubSequenceSumWithK {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SubSequenceSumWithK.class);

	public static void main(String[] args) {
		int[] input = { 1, 2, 1 };
		int target = 2;
		int currSum = 0;
		int currIdx = 0;
		List<Integer> currSet = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		generateOneSubSequencesWithSumK(input, currIdx, currSum, target, currSet, result);
		LOGGER.info("Single Combination is {}", result);
		result = new ArrayList<>();
		generateAllSubSequencesWithSumK(input, currIdx, currSum, target, currSet, result);
		LOGGER.info("All Combinations are {}", result);
	}

	private static void generateAllSubSequencesWithSumK(int[] input, int currIdx, int currSum, int targetSum,
			List<Integer> currSet, List<List<Integer>> result) {

		if (currIdx == input.length && currSum == targetSum) {
			result.add(new ArrayList<>(currSet));
			return;
		}

		if (currSum > targetSum)
			return;

		if (currIdx >= input.length)
			return;

		generateAllSubSequencesWithSumK(input, currIdx + 1, currSum, targetSum, currSet, result);

		currSet.add(input[currIdx]);
		generateAllSubSequencesWithSumK(input, currIdx + 1, currSum + input[currIdx], targetSum, currSet, result);
		currSet.remove(currSet.size() - 1);

	}

	private static boolean generateOneSubSequencesWithSumK(int[] input, int currIdx, int currSum, int targetSum,
			List<Integer> currSet, List<List<Integer>> result) {

		if (currIdx == input.length && currSum == targetSum) {
			result.add(new ArrayList<>(currSet));
			return true;
		}

		if (currSum > targetSum)
			return false;

		if (currIdx >= input.length)
			return false;

		boolean isSuccess = false;

		isSuccess = generateOneSubSequencesWithSumK(input, currIdx + 1, currSum, targetSum, currSet, result);
		if (isSuccess)
			return true;

		currSet.add(input[currIdx]);
		isSuccess = generateOneSubSequencesWithSumK(input, currIdx + 1, currSum + input[currIdx], targetSum, currSet, result);
		currSet.remove(currSet.size() - 1);

		return isSuccess;
	}
	
	private static int countSubSequencesWithSumK(int[] input, int currIdx, int currSum, int targetSum,
			List<Integer> currSet, List<List<Integer>> result) {

		if (currIdx == input.length && currSum == targetSum) {
			result.add(new ArrayList<>(currSet));
			return 1;
		}

		if (currSum > targetSum)
			return 0;

		if (currIdx >= input.length)
			return 0;

		int includeSum = countSubSequencesWithSumK(input, currIdx + 1, currSum, targetSum, currSet, result);

		currSet.add(input[currIdx]);
		int nonIncludeSum = countSubSequencesWithSumK(input, currIdx + 1, currSum + input[currIdx], targetSum, currSet, result);
		currSet.remove(currSet.size() - 1);
		return includeSum + nonIncludeSum;
	}

}
