package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_25_26_LongestCommonSubSequence {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_25_26_LongestCommonSubSequence.class);

	public static void main(String[] args) {
		String s1 = "adcbc";
		String s2 = "dcadb";
		int lcsRec = lcsRec(s1, s1.length() - 1, s2, s2.length() - 1);
		LOGGER.info("lcs length from recursion is = {}", lcsRec);
		Integer[][] mem = new Integer[s1.length() + 1][s2.length() + 1];
		int lcsMem = lcsMem(s1, s1.length(), s2, s2.length(), mem);
		LOGGER.info("lcs length from memoization is = {}", lcsMem);
		int[][] memBottomsUp = lcsBottomsUp(s1, s2);
		LOGGER.info("lcs length from BottomsUp is = {}", memBottomsUp[s1.length()][s2.length()]);
		String lcs = lcs(mem, s1, s2, s1.length(), s2.length());
		LOGGER.info("lcs  is = {}", lcs);
	}

	private static String lcs(Integer[][] mem, String s1, String s2, int s1Length, int s2Length) {
		int lcsLength = mem[s1Length][s2Length];
		char[] lcsChar = new char[lcsLength];
		int idx = lcsLength - 1;
		while (s1Length > 0 && s2Length > 0) {
			if (s1.charAt(s1Length - 1) == s2.charAt(s2Length - 1)) {
				lcsChar[idx] = s2.charAt(s2Length - 1);
				idx--;
				s1Length--;
				s2Length--;
			} else if (mem[s1Length - 1][s2Length] >= mem[s1Length][s2Length]) {
				s1Length--;
			} else {
				s2Length--;
			}
		}
		return new String(lcsChar);
	}

	private static int[][] lcsBottomsUp(String s1, String s2) {
		int[][] mem = new int[s1.length() + 1][s2.length() + 1];
		for (int s1Idx = 1; s1Idx <= s1.length(); s1Idx++) {
			for (int s2Idx = 1; s2Idx <= s2.length(); s2Idx++) {
				if (s1.charAt(s1Idx - 1) == s2.charAt(s2Idx - 1)) {
					mem[s1Idx][s2Idx] = 1 + mem[s1Idx - 1][s2Idx - 1];
				} else {
					mem[s1Idx][s2Idx] = Math.max(mem[s1Idx - 1][s2Idx], mem[s1Idx][s2Idx - 1]);
				}
			}
		}
		return mem;
	}

	private static int lcsMem(String s1, int s1Len, String s2, int s2Len, Integer[][] mem) {

		if (s1Len == 0 || s2Len == 0)
			return 0;

		if (null != mem[s1Len][s2Len])
			return mem[s1Len][s2Len];

		if (s1.charAt(s1Len - 1) == s2.charAt(s2Len - 1))
			return mem[s1Len][s2Len] = 1 + lcsMem(s1, s1Len - 1, s2, s2Len - 1, mem);
		return mem[s1Len][s2Len] = Math.max(lcsMem(s1, s1Len - 1, s2, s2Len, mem),
				lcsMem(s1, s1Len, s2, s2Len - 1, mem));
	}

	private static int lcsRec(String s1, int s1Idx, String s2, int s2Idx) {
		if (s1Idx < 0 || s2Idx < 0)
			return 0;
		if (s1.charAt(s1Idx) == s2.charAt(s2Idx))
			return 1 + lcsRec(s1, s1Idx - 1, s2, s2Idx - 1);
		return Math.max(lcsRec(s1, s1Idx - 1, s2, s2Idx), lcsRec(s1, s1Idx, s2, s2Idx - 1));
	}

}
