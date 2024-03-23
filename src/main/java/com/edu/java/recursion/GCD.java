package com.edu.java.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GCD {

	private static final Logger LOGGER = LoggerFactory.getLogger(GCD.class);

	public static void main(String[] args) {
		int a = 14;
		int b = 10;
		int result = gcd(a, b);
		LOGGER.info("Result is :: {}", result);
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
