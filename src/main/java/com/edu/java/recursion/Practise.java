package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Practise {

	private static final Logger LOGGER = LoggerFactory.getLogger(Practise.class);

	public static void main(String[] args) {
		combinationSum1();
	}

	public static List<List<Integer>> combinationSum2() {
		int[] input = { 2, 5, 2, 1, 2 };
		int targetSum = 5, startIdx = 0, currSum = 0;
		List<List<Integer>> resultLst = new ArrayList<>();
		List<Integer> currSet = new ArrayList<>();
		Arrays.sort(input);
		combinationSum2Helper(input, startIdx, targetSum, currSum, currSet, resultLst);
		LOGGER.info("Result is {}", resultLst);
		return resultLst;
	}
	
	
	//code for palindrome partition
	public static void palindromicPartition(String input, int startIdx, List<String> currResult, List<List<String>> result) {
		
		if(startIdx == input.length()) {
			result.add(new ArrayList<>(currResult));
			return;
		}
		
		for(int currIdx = startIdx; currIdx < input.length(); currIdx++) {
			if(currIdx + 1 <= input.length()) {
				String newString = input.substring(startIdx, currIdx + 1);
				if(isPalindrome(newString)) {
					currResult.add(newString);
					palindromicPartition(input, currIdx + 1, currResult, result);
					currResult.remove(currResult.size()-1);
				}
			}
		}
	}

	private static boolean isPalindrome(String newString) {
		int start = 0;
		int end = newString.length() - 1;
		while (start < end) {
			if (newString.charAt(start) != newString.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

	private static void combinationSum2Helper(int[] input, int startIdx, int targetSum, int currSum,
			List<Integer> currSet, List<List<Integer>> resultLst) {

		if (currSum == targetSum) {
			resultLst.add(currSet);
			return;
		}

		if (currSum > targetSum)
			return;

		for (int currIdx = startIdx; currIdx < input.length; currIdx++) {
			if (currIdx > startIdx && input[currIdx - 1] == input[currIdx])
				continue;
			if (input[currIdx] > targetSum)
				break;
			currSet.add(input[currIdx]);
			combinationSum1Helper(input, targetSum, currIdx + 1, currSum + input[currIdx], currSet, resultLst);
			currSet.remove(currSet.size() - 1);
		}
	}

	public static List<List<Integer>> combinationSum1() {
		int[] input = { 2, 3, 5 };
		int targetSum = 7;
		int currSum = 0;
		int currIdx = 0;
		List<Integer> currSet = new ArrayList<>();
		List<List<Integer>> resultLst = new ArrayList<>();
		combinationSum1Helper(input, targetSum, currIdx, currSum, currSet, resultLst);
		LOGGER.info("Result is {}", resultLst);
		return resultLst;
	}

	private static void combinationSum1Helper(int[] input, int targetSum, int currIdx, int currSum,
			List<Integer> currSet, List<List<Integer>> resultLst) {

		if (currIdx == input.length) {
			if (targetSum == currSum) {
				resultLst.add(new ArrayList<>(currSet));
			}
			return;
		}

		if (currIdx > input.length)
			return;

		if (currSum > targetSum)
			return;

		// dont pick -- increasing the index since we chose to skip the currelement
		combinationSum1Helper(input, targetSum, currIdx + 1, currSum, currSet, resultLst);
		// pick -- can pick the same element again so not increasing index and
		// increasing the sum
		if (input[currIdx] <= targetSum) {
			currSet.add(input[currIdx]);
			combinationSum1Helper(input, targetSum, currIdx, currSum + input[currIdx], currSet, resultLst);
			currSet.remove(currSet.size() - 1);
		}
	}

}
