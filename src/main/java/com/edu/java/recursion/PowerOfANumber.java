package com.edu.java.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PowerOfANumber {

	private static final Logger LOGGER = LoggerFactory.getLogger(PowerOfANumber.class);

	private static final int MOD = 1000000007;

	public static void main(String[] args) {
		int a = 12;
		int b = 21;
		long res = pow2(a, b);
		LOGGER.info("Result is :: {}", res);
	}

	private static long pow(int a, int b) {
		if (b == 0)
			return 1;
		long temp = pow(a, b / 2) % MOD;
		if (b % 2 == 0) {
			return ((temp % MOD) * (temp % MOD)) % MOD;
		} else {
			return (a * (temp % MOD) * (temp % MOD)) % MOD;
		}
	}

	private static long pow2(int a, int b) {
		if (b == 0)
			return 1;
		long temp = pow2(a, b / 2) % MOD;
		temp = temp % MOD * temp % MOD;
		if (b % 2 == 0) {
			return temp % MOD;
		} else {
			return (a * temp) % MOD;
		}
	}
}
