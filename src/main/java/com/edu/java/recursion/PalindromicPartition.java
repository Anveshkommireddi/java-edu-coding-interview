package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PalindromicPartition {

	private static final Logger LOGGER = LoggerFactory.getLogger(PalindromicPartition.class);

	public static void main(String[] args) {
		String input = "aabb";
		List<List<String>> result = new ArrayList<>();
		List<String> currSet = new ArrayList<>();
		int startIdx = 0;
		allPalindromicPartions(input, startIdx, currSet, result);
		result.parallelStream().forEach(partition -> LOGGER.info("Partition is :: {}", partition));
	}

	private static void allPalindromicPartions(String input, int startIdx, List<String> currSet,
			List<List<String>> result) {

		if (startIdx == input.length()) {
			result.add(new ArrayList<>(currSet));
			return;
		}

		if (startIdx >= input.length())
			return;

		for (int currIdx = startIdx; currIdx < input.length(); currIdx++) {
			// this condition can be removed
			if (currIdx + 1 <= input.length()) {
				String currString = input.substring(startIdx, currIdx + 1);
				boolean isPalindrome = checkPalindrome(currString);
				if (isPalindrome) {
					currSet.add(currString);
					allPalindromicPartions(input, currIdx + 1, currSet, result);
					currSet.remove(currSet.size() - 1);
				}
			}
		}
	}

	private static boolean checkPalindrome(String input) {
		int startIdx = 0;
		int endIdx = input.length() - 1;
		while (startIdx < endIdx) {
			if (input.charAt(startIdx) != input.charAt(endIdx))
				return false;
			startIdx++;
			endIdx--;
		}
		return true;
	}

};