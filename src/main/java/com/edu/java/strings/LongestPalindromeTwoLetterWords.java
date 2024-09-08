package com.edu.java.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeTwoLetterWords {

	public static void main(String[] args) {

	}

	public static int longestPalindrome(String[] words) {
		Map<String, Integer> wordFrequencyInfo = new HashMap<>();
		for (String word : words) {
			int currCount = wordFrequencyInfo.getOrDefault(word, 0);
			wordFrequencyInfo.put(word, currCount + 1);
		}
		boolean hasMiddle = false;
		int result = 0;
		for (Map.Entry<String, Integer> entry : wordFrequencyInfo.entrySet()) {
			String word = entry.getKey();
			Integer frequency = entry.getValue();
			if (word.charAt(1) == word.charAt(0)) {
				if (frequency % 2 == 0) {
					result += frequency;
				} else {
					result += frequency;
					result--;
					hasMiddle = true;
				}
			} else if (word.charAt(1) > word.charAt(0)
					&& wordFrequencyInfo.containsKey(word.charAt(1) + "" + word.charAt(0))) {
				result += 2 * Math.min(frequency, wordFrequencyInfo.get(word.charAt(1) + "" + word.charAt(0)));
			}

		}
		if(hasMiddle) {
			result += 1;
		}
		return 2 * result;
	}

}
