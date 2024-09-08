package com.edu.java8.test;

import java.util.Map;
import java.util.TreeMap;

public class DNASequenceTest {

	public static void main(String[] args) {
		String input = "aaacbbbaabab";
		int k = 2;
		int result = lrcr(input, k);
		System.out.println(result);
	}

	private static int lrcr(String input, int k) {
		int result = Integer.MIN_VALUE;
		int start = 0;
		Map<Character, Integer> charFreq = new TreeMap<>();
		for (int end = 0; end < input.length(); end++) {
			char currChar = input.charAt(end);
			charFreq.put(currChar, charFreq.getOrDefault(currChar, 0) + 1);
			while (start <= end && (((end - start + 1) - getMaxFreqVal(charFreq)) > k)) {
				char startChar = input.charAt(start);
				int startCharVal = charFreq.get(startChar);
				if (startCharVal > 1) {
					charFreq.put(startChar, charFreq.getOrDefault(startChar, 0) - 1);
				} else {
					charFreq.remove(startChar);
				}
				start++;
			}
			result = Math.max(result, end - start + 1);
		}
		return result;
	}

	private static int getMaxFreqVal(Map<Character, Integer> charFreq) {
		int maxFreq = 0;
		for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
			maxFreq = Math.max(entry.getValue(), maxFreq);
		}
		return maxFreq;
	}

}
