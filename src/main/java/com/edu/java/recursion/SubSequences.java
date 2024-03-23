package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubSequences {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubSequences.class);

	public static void main(String[] args) {
		int[] input = { 3, 2, 3, 2, 1, 2 };
		List<Integer> currSet = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		subsequences(input, 0, currSet, result);
		LOGGER.info("SubSequences are :: {}", result);
	}

	private static void subsequences(int[] input, int currIdx, List<Integer> currSet, List<List<Integer>> result) {

		if (currIdx == input.length) {
			result.add(new ArrayList<>(currSet));
			return;
		}

		subsequences(input, currIdx + 1, currSet, result);

		currSet.add(input[currIdx]);
		subsequences(input, currIdx + 1, currSet, result);
		currSet.remove(currSet.size() - 1);

	}

}
