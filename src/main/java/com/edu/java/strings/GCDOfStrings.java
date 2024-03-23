package com.edu.java.strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GCDOfStrings {

	private static final Logger LOGGER = LoggerFactory.getLogger(GCDOfStrings.class);

	public static void main(String[] args) {
		String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
		String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
		String result = gcdOfStrings(str1, str2);
		LOGGER.info("GCD Of Strings {} and {} is {}", str1, str2, result);
	}

	private static String gcdOfStrings(String str1, String str2) {
		if (!(str1 + str2).equals(str2 + str1))
			return "";
		int gcd = gcd(str1.length(), str2.length());
		return str1.substring(0, gcd);
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}
