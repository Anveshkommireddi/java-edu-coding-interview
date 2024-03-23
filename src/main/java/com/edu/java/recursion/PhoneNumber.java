package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhoneNumber {

	private static final Logger LOGGER = LoggerFactory.getLogger(PhoneNumber.class);

	private static Map<Character, List<Character>> phneNumMap = new HashMap<>();

	static {
		phneNumMap.put('2', Arrays.asList('a', 'b', 'c'));
		phneNumMap.put('3', Arrays.asList('d', 'e', 'f'));
		phneNumMap.put('4', Arrays.asList('g', 'h', 'i'));
		phneNumMap.put('5', Arrays.asList('j', 'k', 'l'));
		phneNumMap.put('6', Arrays.asList('m', 'n', 'o'));
		phneNumMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
		phneNumMap.put('8', Arrays.asList('t', 'u', 'v'));
		phneNumMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
	}

	public static void main(String[] args) {
		String number = "23";
		List<String> resultNums = new ArrayList<>();
		String currResult = "";
		getPhneNumVal(number, 0, currResult, resultNums);
		LOGGER.info("{}", resultNums);
	}

	private static void getPhneNumVal(String number, Integer currIdx, String currResult, List<String> resultNums) {

		if (currIdx == number.length()) {
			resultNums.add(currResult);
			return;
		}

		if (currIdx > number.length())
			return;

		char currChar = number.charAt(currIdx);
		List<Character> charLst = phneNumMap.get(currChar);
		for (int currCharIdx = 0; currCharIdx < charLst.size(); currCharIdx++) {
			getPhneNumVal(number, currIdx + 1, currResult + charLst.get(currCharIdx), resultNums);
		}

	}

}
