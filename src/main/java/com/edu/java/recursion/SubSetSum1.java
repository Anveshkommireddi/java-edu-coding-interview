package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubSetSum1 {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubSetSum1.class);

	public static void main(String[] args) {
		int[] input = { 1, 2, 3 };
		Integer currSum = 0, currIdx = 0;
		List<Integer> result = new ArrayList<>();
		sumOfAllSubSets(input, currIdx, currSum, result);
		Collections.sort(result);
		LOGGER.info("Result is :: {}", result);
	}

	private static void sumOfAllSubSets(int[] input, Integer currIdx, Integer currSum, List<Integer> result) {

		if (currIdx == input.length) {
			result.add(currSum);
			return;
		}

		if (currIdx > input.length)
			return;

		sumOfAllSubSets(input, currIdx + 1, currSum + input[currIdx], result);

		sumOfAllSubSets(input, currIdx + 1, currSum, result);

	}

}
