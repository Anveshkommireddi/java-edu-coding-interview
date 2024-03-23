package com.edu.java.strings;

import java.util.ArrayList;
import java.util.List;

public class PermutationInaString {

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "eidbaooo";
		// boolean isPresent = checkInclusion(s1, s2);
		boolean isPresent = checkInclusionWithSlidingWindow(s1, s2);
		System.out.println(isPresent);
	}

	private static boolean checkInclusionWithSlidingWindow(String s1, String s2) {
		int s1Length = s1.length();
		int[] hash = new int[26];
		int[] windowHash = new int[26];
		for (int i = 0; i < s1Length; i++) {
			int s1TgtIdx = s1.charAt(i) - 'a';
			hash[s1TgtIdx]++;
			int s2TgtIdx = s2.charAt(i) - 'a';
			windowHash[s2TgtIdx]++;
		}
		for (int i = s1.length(); i < s2.length(); i++) {
			if (matches(hash, windowHash))
				return true;
			int targetIdx = s2.charAt(i) - 'a';
			windowHash[targetIdx]++;
			int removeIdx = s2.charAt(i - s1.length()) - 'a';
			windowHash[removeIdx]--;
		}
		return false;
	}

	private static boolean matches(int[] hash, int[] windowHash) {
		for (int i = 0; i < 26; i++) {
			if (hash[i] != windowHash[i])
				return false;
		}
		return true;
	}

	// check if permutation of s1 is present in s2
	private static boolean checkInclusion(String s1, String s2) {
		List<Character> charList = new ArrayList<>();
		List<String> result = new ArrayList<>();
		boolean boolRes = permutationHelper(s1, 0, charList, result, s2);
		return boolRes;
	}

	private static boolean permutationHelper(String s1, int startIdx, List<Character> charList, List<String> result,
			String s2) {

		if (startIdx == s1.length()) {
			StringBuilder sb = new StringBuilder();
			for (Character chars : charList) {
				sb.append(chars);
			}
			result.add(sb.toString());
			if (s2.contains(sb.toString()))
				return true;
			return false;
		}

		for (int currIdx = startIdx; currIdx < s1.length(); currIdx++) {
			s1 = swap(s1, currIdx, startIdx);
			charList.add(s1.charAt(startIdx));
			if (permutationHelper(s1, startIdx + 1, charList, result, s2) == true) {
				return true;
			}
			charList.remove(charList.size() - 1);
			s1 = swap(s1, currIdx, startIdx);
		}
		return false;
	}

	private static String swap(String input, int idx1, int idx2) {
		if (input.charAt(idx1) == input.charAt(idx2))
			return input;
		char[] inputArr = input.toCharArray();
		char tempIdx = inputArr[idx1];
		inputArr[idx1] = inputArr[idx2];
		inputArr[idx2] = tempIdx;
		return new String(inputArr);
	}

}
