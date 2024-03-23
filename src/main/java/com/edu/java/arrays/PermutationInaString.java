package com.edu.java.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PermutationInaString {

	private static final Logger LOGGER = LoggerFactory.getLogger(PermutationInaString.class);

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "baxyzabc";
		boolean result = checkInclusion(s1, s2);
		LOGGER.info("Result is {}", result);
	}

	private static boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		int windowLength = s1.length();
		int[] s1Hash = new int[26];
		for (int i = 0; i < windowLength; i++) {
			char currChar = s1.charAt(i);
			s1Hash[currChar - 'a']++;
		}
		int[] s2Hash = new int[26];
		for (int i = 0; i < windowLength; i++) {
			char currChar = s2.charAt(i);
			s2Hash[currChar - 'a']++;
		}
		for (int i = s1.length(); i < s2.length(); i++) {
			if (compareHash(s1Hash, s2Hash))
				return true;
			char currChar = s2.charAt(i);
			char preWindorChar = s2.charAt(i - windowLength);
			s2Hash[preWindorChar - 'a']--;
			s2Hash[currChar - 'a']++;
		}
		return compareHash(s1Hash, s2Hash);
	}

	private static boolean compareHash(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}

}
