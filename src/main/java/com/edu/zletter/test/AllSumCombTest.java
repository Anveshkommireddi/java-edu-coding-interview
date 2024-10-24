package com.edu.zletter.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSumCombTest {

	public static void main(String[] args) {
		int[] input = { 10, 1, 2, 7, 6, 1, 5 };
		Arrays.sort(input);
		int startIdx = 0;
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currSet = new ArrayList<>();
		genUniqueSets(input, startIdx, currSet, result);
	}

	private static void genUniqueSets(int[] input, int startIdx, List<Integer> currSet, List<List<Integer>> result) {

		for (int currIdx = startIdx; currIdx < input.length; currIdx++) {
			if (currIdx > startIdx && input[currIdx] == input[currIdx - 1]) {
				continue;
			}
		}
	}

}
