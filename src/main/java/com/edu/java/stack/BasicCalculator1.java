package com.edu.java.stack;

import java.util.ArrayDeque;
import java.util.Deque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicCalculator1 {

	private static final Logger LOGGER = LoggerFactory.getLogger(BasicCalculator1.class);

	public static void main(String[] args) {
		String s = "12-3*4/2";
		int result = eval(s);
		LOGGER.info("Result is {}", result);
	}

	private static int eval(String s) {
		char sign = '+';
		int num = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {

			char currChar = s.charAt(i);

			if (Character.isDigit(currChar)) {
				num = num * 10 + (currChar - '0');
			}

			if ((!Character.isDigit(currChar) && currChar != ' ') || i == s.length() - 1) {
				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(-num);
				} else if (sign == '*') {
					stack.push(stack.pop() * num);
				} else if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = currChar;
				num = 0;
			}
		}
		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;
	}

}
