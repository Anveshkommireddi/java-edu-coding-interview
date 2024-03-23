package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PermutationsOfString {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PermutationsOfString.class);

	public static void main(String[] args) {
		String input = "abc";
		List<String> result = new ArrayList<>();
		String currString = "";
		int startIdx = 0;
		permutationsOfString(input, startIdx, currString, result);
		//LOGGER.info("Permuation is :: {}", result);
		System.out.println(result);
	}

	private static void permutationsOfString(String input, int startIdx, String currString, List<String> result) {
		
		if(currString.length() == input.length()) {
			result.add(currString);
			return;
		}
		
		for(int currIdx = startIdx; currIdx < input.length(); currIdx++) {
			input = swap(input, currIdx, startIdx);
			permutationsOfString(input, startIdx + 1, currString + input.charAt(startIdx), result);
			input = swap(input, currIdx, startIdx);
		}
		
	}

	private static String swap(String input, int currIdx, int startIdx) {
		if (currIdx == startIdx || input.charAt(currIdx) == input.charAt(startIdx))
			return input;
		char[] inputArr = input.toCharArray();
		char temp = inputArr[currIdx];
		inputArr[currIdx] = inputArr[startIdx];
		inputArr[startIdx] = temp;
		return new String(inputArr);
	}

}
