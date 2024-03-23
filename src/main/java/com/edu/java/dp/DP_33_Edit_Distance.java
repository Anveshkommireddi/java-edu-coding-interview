package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_33_Edit_Distance {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_33_Edit_Distance.class);

	// convert s1 to s2 using insert delete and replace
	public static void main(String[] args) {
		String s1 = "horse";
		String s2 = "ros";
		Integer[][] mem = new Integer[s1.length()+1][s2.length()+1];
		//int result = minEditDistanceRec(s1, s1.length(), s2, s2.length(), mem);
		int result = minEditDistanceBottomsUp(s1, s2);
		LOGGER.info("Result is {}", result);
	}
	
	private static int minEditDistanceBottomsUp(String s1, String s2) {
		int[][] mem = new int[s1.length() + 1][s2.length() + 1];

		for (int s2Length = 0; s2Length <= s2.length(); s2Length++) {
			mem[0][s2Length] = s2Length;
		}

		for (int s1Length = 0; s1Length <= s1.length(); s1Length++) {
			mem[s1Length][0] = s1Length;
		}

		for (int s1Length = 1; s1Length <= s1.length(); s1Length++) {
			for (int s2Length = 1; s2Length <= s2.length(); s2Length++) {
				if (s1.charAt(s1Length - 1) == s2.charAt(s2Length - 1)) {
					mem[s1Length][s2Length] = mem[s1Length - 1][s2Length - 1];
				} else {
					int insert = 1 + mem[s1Length][s2Length - 1];
					int delete = 1 + mem[s1Length - 1][s2Length];
					int replace = 1 + mem[s1Length - 1][s2Length - 1];
					mem[s1Length][s2Length] = Math.min(insert, Math.min(replace, delete));
				}
			}
		}
		return mem[s1.length()][s2.length()];
	}

	private static int minEditDistanceRec(String s1, int s1Length, String s2, int s2Length, Integer[][] mem) {
		
		if(s1Length == 0) return s2Length;
		if(s2Length == 0) return s1Length;
		if(null != mem[s1Length][s2Length]) return mem[s1Length][s2Length];
		if (s1.charAt(s1Length - 1) == s2.charAt(s2Length - 1)) {
			return mem[s1Length][s2Length] = minEditDistanceRec(s1, s1Length - 1, s2, s2Length - 1, mem);
		}
		int insert = 1 + minEditDistanceRec(s1, s1Length, s2, s2Length - 1, mem);
		int delete = 1 + minEditDistanceRec(s1, s1Length - 1, s2, s2Length, mem);
		int replace = 1 + minEditDistanceRec(s1, s1Length - 1, s2, s2Length - 1, mem);
		return mem[s1Length][s2Length] = Math.min(insert, Math.min(replace, delete));
	}

}
