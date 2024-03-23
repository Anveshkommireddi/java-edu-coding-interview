package com.edu.java.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TestDP {

	public static void main(String[] args) {
		String str1 = "ZXVVYZW";
		String str2 = "XKYKZPW";
		List<Character> response = longestCommonSubsequence(str1, str2);
		System.out.println(response);
	}

	public static List<Character> longestCommonSubsequence(String str1, String str2) {
		int[][] dp = lcs(str1, str2);
		int maxLength = dp[str1.length()][str2.length()];
		System.out.println(maxLength);
		Stack<Character> result = new Stack<>();
		int s1Idx = str1.length();
		int s2Idx = str2.length();
		while (s1Idx > 0 && s2Idx > 0) {
			char s1Char = str1.charAt(s1Idx - 1);
			char s2Char = str2.charAt(s2Idx - 1);

			if (s1Char == s2Char) {
				result.add(s1Char);
				s1Idx--;
				s2Idx--;
			} else if (dp[s1Idx][s2Idx - 1] > dp[s1Idx - 1][s2Idx]) {
				s2Idx--;
			} else {
				s1Idx--;
			}
		}
		
		List<Character> newRes = new ArrayList<>();
		while(!result.isEmpty()) {
			newRes.add(result.pop());
		}
		return newRes;
	}

	private static int[][] lcs(String s1, String s2) {

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int s1Length = 1; s1Length <= s1.length(); s1Length++) {
			for (int s2Length = 1; s2Length <= s2.length(); s2Length++) {
				if (s1.charAt(s1Length - 1) == s2.charAt(s2Length - 1)) {
					dp[s1Length][s2Length] = 1 + dp[s1Length - 1][s2Length - 1];
				} else {
					dp[s1Length][s2Length] = Math.max(dp[s1Length - 1][s2Length], dp[s1Length][s2Length - 1]);
				}
			}
		}

		return dp;
	}

}
