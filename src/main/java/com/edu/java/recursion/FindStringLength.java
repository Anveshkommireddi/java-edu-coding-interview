package com.edu.java.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindStringLength {

	private static final Logger LOGGER = LoggerFactory.getLogger(FindStringLength.class);

	public static void main(String[] args) {
		String name = "anvesh";
		int length = findLength(name, name.length() - 1);
		LOGGER.info("Length of the string is :: {}", length);
	}

	private static int findLength(String name, int index) {
		if (index == 0)
			return 1;
		if (index < 0)
			return 0;
		return 1 + findLength(name, index - 1);
	}

}
