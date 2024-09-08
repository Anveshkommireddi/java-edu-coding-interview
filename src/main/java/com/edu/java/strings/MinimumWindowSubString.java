package com.edu.java.strings;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinimumWindowSubString {

	private static final Logger LOGGER = LoggerFactory.getLogger(MinimumWindowSubString.class);

	public static void main(String[] args) {
		String input = "ADOBECODEBANC";
		String pattern = "ABC";
		String result = minWindow(input, pattern);
		LOGGER.info("Result is {}", result);
	}

	public static String minWindow(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<>();

		for (char x : t.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		int matched = 0;
		int start = 0;
		int minLen = s.length() + 1;
		int subStr = 0;
		for (int endWindow = 0; endWindow < s.length(); endWindow++) {
			char right = s.charAt(endWindow);
			if (map.containsKey(right)) {
				map.put(right, map.get(right) - 1);
				if (map.get(right) == 0)
					matched++;
			}

			while (matched == map.size()) {
				if (minLen > endWindow - start + 1) {
					minLen = endWindow - start + 1;
					subStr = start;
				}
				char deleted = s.charAt(start++);
				if (map.containsKey(deleted)) {
					if (map.get(deleted) == 0)
						matched--;
					map.put(deleted, map.get(deleted) + 1);
				}
			}
		}
		return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
	}

}
