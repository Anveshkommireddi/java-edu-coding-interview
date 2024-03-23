package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Algo_Exp_Levenshtein_Distance {

	private static final Logger LOGGER = LoggerFactory.getLogger(Algo_Exp_Levenshtein_Distance.class);

	// edit, substitute, add
	public static void main(String[] args) {
		String str1 = "xabc";
		String str2 = "abcx";
		int result = getLCS(str1, str1.length(), str2, str2.length());
		LOGGER.info("Result is {}", result);
	}

	private static int getLCS(String s1, int s1Length, String s2, int s2Length) {
		if (s1Length == 0) return s2Length;
		if (s2Length == 0) return s1Length;
		if (s1.charAt(s1Length - 1) == s2.charAt(s2Length - 1)) {
			return 0 + getLCS(s1, s1Length - 1, s2, s2Length - 1);
		} else {
			int insert = getLCS(s1, s1Length, s2, s2Length - 1);
			int delete = getLCS(s1, s1Length - 1, s2, s2Length);
			int replace = getLCS(s1, s1Length - 1, s2, s2Length - 1);
			return 1 + Math.min(insert, Math.min(replace, delete));
		}
	}
}
