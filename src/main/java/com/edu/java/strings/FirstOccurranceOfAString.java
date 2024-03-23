package com.edu.java.strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstOccurranceOfAString {

	private static final Logger LOGGER = LoggerFactory.getLogger(FirstOccurranceOfAString.class);

	public static void main(String[] args) {
		String haystack = "hello";
		String needle = "ll";
		int result = firstOccurance(haystack, needle);
		LOGGER.info("Result is {}", result);
	}

	private static int firstOccurance(String haystack, String needle) {
		// prepare hash for the needle
		int[] needleHash = generateHash(needle);

		int windowStart = 0;
		for (int i = needle.length(); i <= haystack.length(); i++) {
			String window = haystack.substring(windowStart, i);
			int[] windowHash = generateHash(window);
			if (needle.equals(window)) {
				return windowStart;
			}
			windowStart++;
		}
		return -1;
	}

	private static int[] generateHash(String input) {
		int[] hash = new int[26];
		for (int i = 0; i < input.length(); i++) {
			int idx = input.charAt(i) - 'a';
			hash[idx]++;
		}
		return hash;
	}

	private static boolean matches(int[] hash, int[] windowHash) {
		for (int i = 0; i < 26; i++) {
			if (hash[i] != windowHash[i])
				return false;
		}
		return true;
	}

}
