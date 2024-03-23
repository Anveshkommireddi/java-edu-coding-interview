package com.edu.java.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiplyStrings {

	private static final Logger LOGGER = LoggerFactory.getLogger(MultiplyStrings.class);

	public static void main(String[] args) {
		String num1 = "498828660196";
		String num2 = "840477629533";
		long start = System.currentTimeMillis();
		String result = multiply(num1, num2);
		LOGGER.info("Time taken is {} and Result is {}", (System.currentTimeMillis() - start) / 1000, result);
	}

	private static String multiply(String num1, String num2) {

		Long val1 = Long.parseLong(num1);
		Long val2 = Long.parseLong(num2);

		if (val1 < val2) {
			Long res = calculate(val2, val1);
			return String.valueOf(res);
		} else {
			Long res = calculate(val1, val2);
			return String.valueOf(res);
		}
	}

	private static Long calculate(Long num1, Long num2) {
		Long result = 0l;
		while (num2-- > 0) {
			result += num1;
		}
		return result;
	}

}
