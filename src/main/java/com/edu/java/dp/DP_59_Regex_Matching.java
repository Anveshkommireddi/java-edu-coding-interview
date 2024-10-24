package com.edu.java.dp;

public class DP_59_Regex_Matching {

	public static void main(String[] args) {
		String s = "aab";
		String p = "c*a*b";
		boolean test = rmHelper(s, 0, p, 0);
		System.out.println(test);
	}

	private static boolean rmHelper(String input, int sIdx, String pattern, int pIdx) {

		if (pIdx == pattern.length() && sIdx == input.length()) {
			return true;
		}

		if (sIdx == input.length() && pIdx < pattern.length()) {
			return validateAllStars(pattern, pIdx);
		}

		if (sIdx < input.length() && pIdx < pattern.length()
				&& (input.charAt(sIdx) == pattern.charAt(pIdx) || pattern.charAt(pIdx) == '.')) {
			return rmHelper(input, sIdx + 1, pattern, pIdx + 1);
		} else if (sIdx < input.length() && pIdx < pattern.length() && pattern.charAt(pIdx) == '*') {
			return rmHelper(input, sIdx + 1, pattern, pIdx + 1) || rmHelper(input, sIdx + 1, pattern, pIdx);
		}
		return false;
	}

	private static boolean validateAllStars(String pattern, int pIdx) {
		while (pIdx < pattern.length()) {
			char currChar = pattern.charAt(pIdx);
			if (currChar != '*')
				return false;
			pIdx++;
		}
		return true;
	}

}
