package com.edu.java.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JosephusProblem {

	private static final Logger LOGGER = LoggerFactory.getLogger(JosephusProblem.class);

	public static void main(String[] args) {
		int n = 5;
		int k = 2;
		int val = josephus(n, k);
		LOGGER.info("Surviving Person is {}", val);
	}

	private static int josephus(int n, int k) {
		if (n == 1)
			return 1;
		return ((josephus(n - 1, k) + k - 1) % n) + 1;
	}

}
