package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_27_LongestCommonSubString {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_27_LongestCommonSubString.class);

	static int[][] mem;
	static int s1Idx;
	static int s2Idx;

	public static void main(String[] args) {
		String s1 = "abcjklp";
		String s2 = "acjkp";
		int max = lcs(s1, s2);
		LOGGER.info("LCS Length is = {}", max);
		String lcs = printLcs(s1, s2, max);
		LOGGER.info("LCS is = {}", lcs);
	}

	private static String printLcs(String s1, String s2, int lcsLength) {
		char[] lcs = new char[lcsLength];
		int s1Length = s1Idx;
		int s2Length = s2Idx;
		int idx = lcsLength - 1;
		while (s1Length > 0 && s2Length > 0 && s1.charAt(s1Length - 1) == s2.charAt(s2Length - 1)) {
			lcs[idx] = s1.charAt(s1Length - 1);
			s1Length--;
			s2Length--;
			idx--;
		}
		return new String(lcs);
	}

	private static int lcs(String s1, String s2) {
		int max = Integer.MIN_VALUE;
		mem = new int[s1.length() + 1][s2.length() + 1];
		for (int s1Length = 1; s1Length <= s1.length(); s1Length++) {
			for (int s2Length = 1; s2Length <= s2.length(); s2Length++) {
				if (s1.charAt(s1Length - 1) == s2.charAt(s2Length - 1)) {
					mem[s1Length][s2Length] = mem[s1Length - 1][s2Length - 1] + 1;
					if (mem[s1Length][s2Length] > max) {
						max = mem[s1Length][s2Length];
						s1Idx = s1Length;
						s2Idx = s2Length;
					}
				}
			}
		}
		return max;
	}

}
