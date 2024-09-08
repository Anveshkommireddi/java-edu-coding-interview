package com.edu.java.stack;

import java.util.ArrayDeque;
import java.util.Deque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicCalculator2 {

	private static final Logger LOGGER = LoggerFactory.getLogger(BasicCalculator2.class);

	public static void main(String[] args) {
		// String s = "12-( -2)";
		String s = "12-(-3+2)";
		int result = eval(s);
		LOGGER.info("Result is {}", result);
	}

	private static int eval(String s) {
		Deque<Integer> stack = new ArrayDeque<>();
		int sign = 1;
		int num = 0;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);
			if (Character.isDigit(currChar)) {
				num = num * 10 + (currChar - '0');
			}

			if (!Character.isDigit(currChar)) {
				if (currChar == '(') {
					stack.push(res);
					stack.push(sign);
					res = 0;
					sign = 1;
					num = 0;
				} else if (currChar == ')') {
					res += num * sign;
					res *= stack.pop();
					res += stack.pop();
					num = 0;
					sign = 1;
				} else if (currChar == '+' || currChar == '-') {
					res += num * sign;
					num = 0;
					sign = currChar == '+' ? 1 : -1;
				}
			}
		}
		res += sign * num;
		return res;
	}

}
