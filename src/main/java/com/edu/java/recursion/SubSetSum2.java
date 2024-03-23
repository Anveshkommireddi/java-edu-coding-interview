package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubSetSum2 {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubSetSum2.class);

	public static void main(String[] args) {
		int[] input = { 2, 1, 2 };
		List<List<Integer>> result = generateUniqueSubSets(input);
		LOGGER.info("Result is :: {}", result);
	}

	private static List<List<Integer>> generateUniqueSubSets(int[] input) {
		int startIdx = 0;
		List<Integer> currSet = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(input);
		for(int size = 0; size <= input.length; size++) {
			generateUniqueSubSetsOfSizeK(input, startIdx, currSet, size, result);
		}
		return result;
	}

	private static void generateUniqueSubSetsOfSizeK(int[] input, int startIdx, List<Integer> currSet,
			int size, List<List<Integer>> result) {

		if (currSet.size() == size) {
			result.add(new ArrayList<>(currSet));
			return;
		}

		if (startIdx >= input.length)
			return;

		for (int currIdx = startIdx; currIdx < input.length; currIdx++) {
			if (currIdx > startIdx && input[currIdx] == input[currIdx - 1])
				continue;
			currSet.add(input[currIdx]);
			generateUniqueSubSetsOfSizeK(input, currIdx + 1, currSet, size, result);
			currSet.remove(currSet.size() - 1);
		}

	}
	
	/**
	 * @param input
	 * @param startIdx
	 * @param currSet
	 * @param result
	 * Loop Method to get all subsets of all sizes
	 */
	private static void generateUniqueSubSetsLoop(int[] input, int startIdx, List<Integer> currSet, List<List<Integer>> result) {
		result.add(new ArrayList<>(currSet));
		for(int currIdx = startIdx; currIdx < input.length; currIdx++) {
			if(currIdx > startIdx && input[currIdx - 1] == input[currIdx])
				continue;
			currSet.add(input[currIdx]);
			generateUniqueSubSetsLoop(input, currIdx + 1, currSet, result);
			currSet.remove(currSet.size()-1);
		}
	}

}
