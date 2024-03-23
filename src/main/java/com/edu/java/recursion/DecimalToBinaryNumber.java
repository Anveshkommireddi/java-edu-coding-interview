package com.edu.java.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DecimalToBinaryNumber {

	private static final Logger LOGGER = LoggerFactory.getLogger(DecimalToBinaryNumber.class);

	public static void main(String[] args) {
		int number = 6;
		int result = decimalToBinary(number);
		LOGGER.info("Binary Number for the decimal {} is {}", number, result);
	}

	private static int decimalToBinary(int number) {
		if (number == 0)
			return number;
		return number % 2 + (10 * decimalToBinary(number / 2));
	}

}
