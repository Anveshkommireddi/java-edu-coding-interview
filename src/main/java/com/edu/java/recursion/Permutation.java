package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Permutation {

	private static final Logger LOGGER = LoggerFactory.getLogger(Permutation.class);

	public static void main(String[] args) {
		int[] input = { 1, 1, 2 };
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currSet = new ArrayList<>();
		int currIdx = 0;
		permutations(input, currIdx, currSet, result);
		result.parallelStream().forEach(permutation -> LOGGER.info("Permuation is :: {}", permutation));
	}

	private static void permutations(int[] input, int startIdx, List<Integer> currSet, List<List<Integer>> result) {

		if (currSet.size() == input.length) {
			result.add(new ArrayList<>(currSet));
			return;
		}
		for (int currIdx = startIdx; currIdx < input.length; currIdx++) {
			if(currIdx > startIdx && input[currIdx] == input[currIdx-1])
				continue;
			swap(input, startIdx, currIdx);
			currSet.add(input[startIdx]);
			permutations(input, startIdx + 1, currSet, result);
			currSet.remove(currSet.size() - 1);
			swap(input, startIdx, currIdx);
		}
	}

	private static void swap(int[] input, int startIdx, int currIdx) {
		int temp = input[startIdx];
		input[startIdx] = input[currIdx];
		input[currIdx] = temp;
	}

}
