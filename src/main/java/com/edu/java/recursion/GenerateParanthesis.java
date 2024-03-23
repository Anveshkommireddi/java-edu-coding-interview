package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenerateParanthesis {

	private static final Logger LOGGER = LoggerFactory.getLogger(GenerateParanthesis.class);

	public static void main(String[] args) {

		int totalParanthesis = 2;
		List<String> result = new ArrayList<>();
		int openCount = 0;
		int closeCount = 0;
		String currResult = "";
		genereateParanthesis(openCount, closeCount, totalParanthesis, currResult, result);
		LOGGER.info("Result is {}", result);
	}

	private static void genereateParanthesis(int open, int close, int size, String currResult, List<String> result) {

		if (open == size && close == size) {
			result.add(currResult);
			return;
		}

		if (open < size) {
			genereateParanthesis(open + 1, close, size, currResult + "(", result);
		}

		if (open > close) {
			genereateParanthesis(open, close + 1, size, currResult + ")", result);
		}
	}

}
