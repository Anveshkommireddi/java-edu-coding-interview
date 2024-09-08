package com.edu.java.stack;

import java.util.ArrayDeque;
import java.util.Deque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StackTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(StackTest.class);

	public static void main(String[] args) {
		String s = "3+5  / 2";
		int result = calculate(s);
		LOGGER.info("Result is {}", result);
	}

	private static int calculate(String s) {
		int num = 0;
		char sign = '+';
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (curr == ' ') {
				continue;
			}
			if (Character.isDigit(curr)) {
				int currNum = curr - '0';
				num = num * 10 + currNum;
			}

			if (curr == '+' || curr == '-' || curr == '*' || curr == '/' || i == s.length() - 1) {
				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(-num);
				} else if (sign == '*') {
					stack.push(stack.pop() * num);
				}
				num = 0;
				sign = curr;
			}

		}
		return 0;
	}

}
