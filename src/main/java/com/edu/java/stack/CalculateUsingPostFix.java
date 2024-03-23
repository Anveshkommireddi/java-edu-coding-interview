package com.edu.java.stack;

import java.util.Stack;

public class CalculateUsingPostFix {

	public static void main(String args[]) {
		System.out.println(evaluatePostFix("921*-8-4+"));
	}

	// for prefix traverse from right to left and do x operator y
	// for post fix traverse form left to right and do y operator x
	private static Integer evaluatePostFix(String input) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			Character inputChar = input.charAt(i);
			if (Character.isDigit(inputChar)) {
				stack.push(Character.getNumericValue(inputChar));
				continue;
			}

			Integer x = stack.pop();
			Integer y = stack.pop();
			switch (inputChar) {
			case '+':
				stack.push(y + x);
				break;
			case '-':
				stack.push(y - x);
				break;
			case '*':
				stack.push(y * x);
				break;
			case '/':
				stack.push(y / x);
				break;
			}
		}
		return stack.pop();
	}

}
