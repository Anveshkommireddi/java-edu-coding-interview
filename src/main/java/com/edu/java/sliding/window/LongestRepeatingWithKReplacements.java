package com.edu.java.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingWithKReplacements {

	public static void main(String[] args) {
		String s = "aaacbbbaabab";
		int k = 2;
		int result = longestRepeatingCharacterReplacement(s, k);
		System.out.println(result);
	}

	public static int longestRepeatingCharacterReplacement(String s, int k) {
		int start = 0;
		int result = Integer.MIN_VALUE;
		Map<Character, Integer> charFreqMap = new HashMap<>();
		for (int end = 0; end < s.length(); end++) {
			Character currChar = s.charAt(end);
			int currVal = charFreqMap.getOrDefault(currChar, 0);
			charFreqMap.put(currChar, currVal + 1);
			int highestFreq = getHighestFrequ(charFreqMap);
			while (end - start + 1 - highestFreq > k) {
				Character startChar = s.charAt(start);
				int startVal = charFreqMap.getOrDefault(startChar, 0);
				charFreqMap.put(startChar, startVal - 1);
				start++;
			}
			result = Math.max(result, end - start + 1);
		}
		return result;
	}

	private static int getHighestFrequ(Map<Character, Integer> charFreqMap) {
		int maxFreq = 0;
		for (Map.Entry<Character, Integer> entry : charFreqMap.entrySet()) {
			maxFreq = Math.max(maxFreq, entry.getValue());
		}
		return maxFreq;
	}

}
