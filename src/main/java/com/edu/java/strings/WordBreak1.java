package com.edu.java.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//LC :: 139
public class WordBreak1 {

	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
		String s = new String();
		/*
		 * s = "hellonow"; addWordsToDictionary(dictionary,
		 * Arrays.asList("hello","hell","on","now"));
		 */
		s = "abcd";
		addWordsToDictionary(dictionary, Arrays.asList("a", "abc", "b", "cd"));
		if (canSegmentString(s, dictionary)) {
			System.out.println("String Can be Segmented");
		} else {
			System.out.println("String Can NOT be Segmented");
		}
	}

	private static boolean canSegmentString(String input, Set<String> dictionary) {
		boolean result = canSegmentStringHelper(input, 0, dictionary);
		return result;
	}

	private static boolean canSegmentStringHelper(String input, int startIdx, Set<String> dictionary) {
		boolean result = false;
		for (int idx = startIdx; idx < input.length(); idx++) {
			String subString = input.substring(startIdx, idx + 1);
			if (dictionary.contains(subString)) {
				String newString = input.substring(idx + 1);
				if (idx + 1 >= input.length() || dictionary.contains(newString) || canSegmentStringHelper(input, idx + 1, dictionary)) {
					return true;
				}
			}
		}
		return result;
	}

	private static void addWordsToDictionary(Set<String> dictionary, List<String> words) {
		dictionary.addAll(words);
	}

}
