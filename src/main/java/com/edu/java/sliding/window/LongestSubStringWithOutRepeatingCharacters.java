package com.edu.java.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithOutRepeatingCharacters {

	public static void main(String[] args) {
		String s = "conceptoftheday";
		int length = findLongestSubstring(s);
		System.out.println(length);
	}

	public static int findLongestSubstring(String str) {
		int start = 0;
		Map<Character, Integer> charIdxMap = new HashMap<>();
		int length = Integer.MIN_VALUE;
		for (int end = 0; end < str.length(); end++) {
			char currChar = str.charAt(end);
			if (charIdxMap.containsKey(currChar)) {
				start = Math.max(start, charIdxMap.get(currChar) + 1);
			}
			charIdxMap.put(currChar, end);
			length = Math.max(length, end - start + 1);
		}
		return length;
	}

}
