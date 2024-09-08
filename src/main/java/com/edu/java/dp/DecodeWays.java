package com.edu.java.dp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DecodeWays {

	// leetcode - 91
	private static final Logger LOGGER = LoggerFactory.getLogger(DecodeWays.class);

	public static void main(String[] args) {
		String input = "111111111111111111111111111111111111111111111";
		//String input = "226";
		List<String> currResult = new ArrayList<>();
		int startIdx = 0;
		Integer[] mem = new Integer[input.length()+1];
		List<List<String>> result = new ArrayList<>();
		//int noOfWays = decodeWaysRecLoopWithMem(input, startIdx, mem);
		int noOfWays = decodeWays(input, startIdx, currResult, result);
		LOGGER.info("Total No: of Ways = {} and result is {}", noOfWays, result);
	}

	private static int decodeWays(String input, int startIdx, List<String> currResult, List<List<String>> result) {

		if (startIdx >= input.length()) {
			result.add(new ArrayList<>(currResult));
			return 1;
		}

		int oneLength = 0;
		if (startIdx + 1 <= input.length()) {
			String lengthOne = input.substring(startIdx, startIdx + 1);
			boolean isValidNumber = !lengthOne.startsWith("0") && Integer.parseInt(lengthOne) <= 26;
			if (isValidNumber == false)
				return 0;
			currResult.add(lengthOne);
			oneLength = decodeWays(input, startIdx + 1, currResult, result);
			currResult.remove(currResult.size() - 1);
		}

		int twoLength = 0;
		if (startIdx + 2 <= input.length()) {
			String lengthTwo = input.substring(startIdx, startIdx + 2);
			boolean isValidNumber = !lengthTwo.startsWith("0") && Integer.parseInt(lengthTwo) <= 26;
			if (isValidNumber == false)
				return 0 + oneLength;
			currResult.add(lengthTwo);
			twoLength = decodeWays(input, startIdx + 2, currResult, result);
			currResult.remove(currResult.size() - 1);
		}

		return oneLength + twoLength;
	}
	
	private static int decodeWaysRecLoop(String input, int startIdx, List<String> currResult) {

		if (startIdx >= input.length()) {
			return 1;
		}

		int decodeStringLength = 0;
		for (int length = 1; length <= 2; length++) {
			if (startIdx + length <= input.length()) {
				String numString = input.substring(startIdx, startIdx + length);
				boolean isValidNumber = !numString.startsWith("0") && Integer.parseInt(numString) <= 26;
				if (isValidNumber == false)
					return decodeStringLength;
				currResult.add(numString);
				decodeStringLength += decodeWaysRecLoop(input, startIdx + length, currResult);
				currResult.remove(currResult.size() - 1);
			}
		}

		return decodeStringLength;
	}
	
	private static int decodeWaysRecLoopWithMem(String input, int startIdx, Integer[] mem) {

		if (startIdx >= input.length()) {
			return 1;
		}

		if (null != mem[startIdx])
			return mem[startIdx];

		int decodeStringLength = 0;
		for (int length = 1; length <= 2; length++) {
			if (startIdx + length <= input.length()) {
				String numString = input.substring(startIdx, startIdx + length);
				boolean isValidNumber = !numString.startsWith("0") && Integer.parseInt(numString) <= 26;
				if (isValidNumber == false)
					return mem[startIdx] = decodeStringLength;
				decodeStringLength += decodeWaysRecLoopWithMem(input, startIdx + length, mem);
			}
		}

		return mem[startIdx] = decodeStringLength;
	}
	
	//latest
	private static int decodeWaysHelper(String input, int idx, Integer[] mem) {

		if (idx >= input.length()) {
			return 1;
		}
		
		if(null != mem[idx]) {
			return mem[idx];
		}

		int result = 0; 
		if (input.charAt(idx) != '0') {
			result += decodeWaysHelper(input, idx + 1, mem);
		}

		if (isValid(input, idx, idx + 2)) {
			result += decodeWaysHelper(input, idx + 2, mem);
		}

		return mem[idx] = result;
	}

	private static boolean isValid(String input, int start, int end) {
		if (start + 2 > input.length() || input.charAt(start) == '0')
			return false;
		Integer val = Integer.parseInt(input.substring(start, end));
		return val <= 26;
	}
	
}
