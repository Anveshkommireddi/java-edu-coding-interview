package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_32_DistinctSubSequences {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_32_DistinctSubSequences.class);

	public static void main(String[] args) {
		String s1 = "babgbag";
		String s2 = "bag";
		int val = getDistinctSubSequnceCountRec(s1, s1.length(), s2, s2.length());
		LOGGER.info("Length is = {}", val);
		Integer[][] mem = new Integer[s1.length() + 1][s2.length() + 1];
		int memVal = getDistinctSubSequnceCountMem(s1, s1.length(), s2, s2.length(), mem);
		LOGGER.info("Length is = {}", memVal);
	}

	private static int getDistinctSubSequnceCountMem(String s1, int s1Length, String s2, int s2Length,
			Integer[][] mem) {
		if (s2Length == 0)
			return 1;
		if (s1Length == 0)
			return 0;

		if (null != mem[s1Length][s2Length])
			return mem[s1Length][s2Length];

		if (s1.charAt(s1Length - 1) == s2.charAt(s2Length - 1)) {
			return mem[s1Length][s2Length] = getDistinctSubSequnceCountRec(s1, s1Length - 1, s2, s2Length - 1)
					+ getDistinctSubSequnceCountRec(s1, s1Length - 1, s2, s2Length);
		} else {
			return mem[s1Length][s2Length] = getDistinctSubSequnceCountRec(s1, s1Length - 1, s2, s2Length);
		}
	}

	private static int getDistinctSubSequnceCountRec(String s1, int s1Length, String s2, int s2Length) {

		if (s2Length == 0)
			return 1;
		if (s1Length == 0)
			return 0;

		if (s1.charAt(s1Length - 1) == s2.charAt(s2Length - 1)) {
			return getDistinctSubSequnceCountRec(s1, s1Length - 1, s2, s2Length - 1)
					+ getDistinctSubSequnceCountRec(s1, s1Length - 1, s2, s2Length);
		} else {
			return getDistinctSubSequnceCountRec(s1, s1Length - 1, s2, s2Length);
		}
	}

}
