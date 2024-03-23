package com.edu.java.greedy;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidParanthesisString {

	private static final Logger LOGGER = LoggerFactory.getLogger(ValidParanthesisString.class);

	public static void main(String[] args) {
		String input1 = "(()*))";
		String input2 = ")*()";
		String input3 = "(*(**)";
		String input4 = "***(()";
		boolean result = isValid(input4);
		LOGGER.info("Result for input {} is {}", input4, result);
	}

	private static boolean isValid(String input) {
		Stack<Integer> openParamStack = new Stack<>();
		Stack<Integer> wildCardStack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char currChar = input.charAt(i);
			if (currChar == '(') {
				openParamStack.push(i);
			} else if (currChar == '*') {
				wildCardStack.push(i);
			} else if (currChar == ')') {
				if (!openParamStack.isEmpty()) {
					openParamStack.pop();
				} else if (!wildCardStack.isEmpty()) {
					wildCardStack.pop();
				} else {
					return false;
				}
			}
		}

		while (!openParamStack.isEmpty() && !wildCardStack.isEmpty()) {
			if (openParamStack.peek() < wildCardStack.peek()) {
				openParamStack.pop();
				wildCardStack.pop();
			} else {
				return false;
			}
		}
		return openParamStack.isEmpty() ? true : false ;
	}

}
